package com.cenrise.source;

import com.cenrise.database.meta.RowMetaInterface;
import com.cenrise.database.meta.ValueMetaInterface;
import com.cenrise.database.protocol.CDCEntry;
import com.cenrise.exception.DGFValueException;
import com.cenrise.source.variables.Variables;
import com.cenrise.source.vfs.KettleVFS;
import com.cenrise.util.Const;
import com.tongtech.dgf.Context;
import com.tongtech.dgf.DgfException;
import com.tongtech.dgf.Event;
import com.tongtech.dgf.EventDeliveryException;
import com.tongtech.dgf.conf.Configurables;
import com.tongtech.dgf.database.meta.RowDataUtil;
import com.cenrise.database.meta.RowMeta;
import com.cenrise.database.meta.RowMetaInterface;
import com.cenrise.database.meta.ValueMeta;
import com.cenrise.database.meta.ValueMetaInterface;
import com.cenrise.database.protocol.CDCEntry.Column;
import com.cenrise.database.protocol.CDCEntry.Entry;
import com.cenrise.database.protocol.CDCEntry.EntryType;
import com.cenrise.database.protocol.CDCEntry.Header;
import com.cenrise.database.protocol.CDCEntry.RowChange;
import com.cenrise.database.protocol.CDCEntry.RowData;
import com.tongtech.dgf.database.util.SqlUtils;
import com.tongtech.dgf.event.EventBuilder;
import com.cenrise.exception.DGFValueException;
import com.cenrise.source.variables.Variables;
import com.cenrise.source.vfs.KettleVFS;
import com.cenrise.util.Const;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * XML文件解析组件类，负责组件的处理逻辑
 *
 * @author jiadp
 */
public class XMLSource {
    private static final Logger logger = LoggerFactory
            .getLogger(XMLSource.class);

    private XMLSourceMeta meta = new XMLSourceMeta();
    private XMLSourceData data = new XMLSourceData();
    boolean first = true;// 第一次处理
    boolean stop = false;
    boolean readover = false;// 未读完或者刚开始读

    private CDCEntry.Entry.Builder entryBuilder = null;
    private CDCEntry.Header.Builder headerBuilder = null;
    private CDCEntry.RowChange.Builder rowChangBuilder = null;
    private CDCEntry.RowData.Builder rowDataBuilder = null;
    private CDCEntry.Column.Builder afterColumnBuilder = null;

    @Override
    protected Status doSchedule() throws EventDeliveryException {
        if (first && !meta.isInFields()) {// 第 一次处理，并且文件名称不是来自于字段
            first = false;
            data.files = meta.getFiles(new Variables());// 获取字段信息

            data.outputRowMeta = new RowMeta();// 输出字段的元数据的初始化
            meta.getFields(data.outputRowMeta, /* getStepname(), */null, null, /* this */
                    new Variables());// 把数据给上边初始化的元数组数据

            // For String to <type> conversions, we allocate a conversion meta
            // data row as well...
            data.convertRowMeta = data.outputRowMeta.clone();// 把数据结构复制一份到convertRowMeta里。

            for (int i = 0; i < data.convertRowMeta.size(); i++) {// 因为后边我们处理的时候是先把所有的数据转化成String，处理完后再转化回来
                data.convertRowMeta.getValueMeta(i).setType(
                        ValueMetaInterface.TYPE_STRING);
            }
        }

        while (!isReadOver()) {// 是否处理完啦
            if (data.rowList != null && data.rowList.size() > 0) {// 开始处理数据
                Object[] outputRowData = buildEmptyRow();// 构建一个空的Object数组

                data.thisRowMap = data.rowList.get(0);// 获取一个文件
                outputRowData = getRowFromRowList(data.thisRowMap);// 处理文件
                data.thisRowMap.remove(data.thisRowMap);

                // 对一个字段的处理结束，删除
                if (outputRowData != null && !Const.isEmpty(outputRowData)) {
                    // putRow(data.outputRowMeta, outputRowData);
                    // incrementLinesInput();

                    putDataToChannel(outputRowData);// 放入Channel中

                    data.previousRow = data.outputRowMeta
                            .cloneRow(outputRowData);
                    logger.debug("获取记录：{0}" + outputRowData.toString());
                }
                data.rowList.remove(0);
            }

            if (!first && data.rowList.size() != 0) {// 第一次肯定会处理一次，然后如果结果集还有数据就把读取标识为false,表示未读完，还要处理
                readover = false;
            }
        }
        return Status.SUCCESS;
    }

    /**
     * 数据处理，放入Channel中
     */
    private void putDataToChannel(Object[] outputRowData) {
        // TODO Auto-generated method stub
        RowMetaInterface rowMetaInterface = data.outputRowMeta;// 数据类型
        Object[] rowMetaData = outputRowData;// 数据
        List<ValueMetaInterface> valueMeta = rowMetaInterface
                .getValueMetaList();
        Iterator<ValueMetaInterface> va = valueMeta.iterator();
        int i = 0;

        /** Entry实体构建类 */
        /* Entry.Builder */
        entryBuilder = CDCEntry.Entry.newBuilder();
        /* Header.Builder */
        headerBuilder = CDCEntry.Header.newBuilder();// 头
        // 头开始
        headerBuilder.setEnCoding("utf-8");
        headerBuilder.setEntryType(CDCEntry.EntryType.ROWDATA);
        entryBuilder.setHeader(headerBuilder.build());
        // 头结束

        /** 构建RowChange.Builder */
        // rowchange开始
        /* RowChange.Builder */
        rowChangBuilder = CDCEntry.RowChange.newBuilder();// 结果

        /** 构建RowData.Builder */
		/* RowData.Builder */
        rowDataBuilder = CDCEntry.RowData.newBuilder();
        rowDataBuilder.setTableName("XMLSource");// 抽取的表名称
        rowDataBuilder.setEventType(SqlUtils.getEventTypeFromType("insert"));// 'delete'

        while (va.hasNext()) {// 字段级处理
            i++;// 数据记录器，记录处理到哪个字段啦。
            ValueMetaInterface valueMetaInterface = va.next();
            String columnName = valueMetaInterface.getName();// 字段名
            int sqlTypes = valueMetaInterface.getType();// java.sql.Types

			/* Column.Builder */
            afterColumnBuilder = CDCEntry.Column.newBuilder();
            afterColumnBuilder.setName(columnName);
            afterColumnBuilder.setSqlType(sqlTypes);
            afterColumnBuilder.setUpdated(true);
            afterColumnBuilder.setIsNull(true);
            afterColumnBuilder.setIsKey(false);
            /** 根据类型填充数据开始 */
            afterColumnBuilder.setValue(String
                    .valueOf(rowMetaData[i] == null ? "" : rowMetaData[i]));
            /** 根据类型填充数据结束 */

            // 添加构建好的AfterColumn内容到rowDataBuilder中
            rowDataBuilder.addAfterColumns(afterColumnBuilder.build());
        }
        rowChangBuilder.addRowDatas(rowDataBuilder.build());

        // 添加到集合
        entryBuilder.setRowChange(rowChangBuilder.build());
        CDCEntry.Entry entry = entryBuilder.build();
        logger.debug("Entry信息：" + entry);

        byte[] dataByte = entry.toByteArray();
        Map<String, String> header = new HashMap<String, String>();
        header.put("batchId", getBatchId());
        header.put("subBatchId", String.valueOf(getSubBatchId()));
        Event e = EventBuilder.withBody(dataByte, header);
        getChannelProcessor().processEvent(e);// 之后出现错误导致msg不能删除，此处已经sink处理掉，再次添加会出错.
        rowChangBuilder = CDCEntry.RowChange.newBuilder();// 初始化rowchange
        /** 查询结束 */

    }

    /**
     * 标识是否还有数据需要处理
     *
     * @return
     */
    public boolean isReadOver() {
        // 获取valueList,如果无法获取到valueList,即认为所有文件解析完成
        while (data.rowList == null || data.rowList.size() == 0) {// data.rowList里放的是所有要处理的文件
            if (!getRowListFromXML()) {
                readover = true;
                // return false;
                return true;// 无数据返回
            }
        }
        return false;
    }

    /**
     * 上一个文件读取结束，开始读取下一个文件
     *
     * @return
     * @throws DGFValueException
     */
    private boolean getRowListFromXML() throws DGFValueException {
        // finished reading the file, read the next file
        data.file = null;
        data.rowList = null;
        if (!meta.isInFields()) {
            while (data.filenr < data.files.nrOfFiles() && data.file == null) {
                if (!openNextFile()) {
                    return false;
                }
            }
        } else {// 如果文件名来自于上一个组件
            while (data.file == null) {
            }
        }
        if (data.file == null) {
            return false;
        }
        // 增加相对路径和使用变量的情形
        String encoding = "UTF-8";
        InputStream is = null;
        try {
            if (!Const.isEmpty(meta.getEncoding()))
                encoding = meta.getEncoding();
            is = KettleVFS.getInputStream(data.file);
            PushbackReader r = new PushbackReader(new InputStreamReader(is,
                    encoding));
            int ch = -1;
            // scan for the < character
            while ((ch = r.read()) != '<')
                ;
            if (ch == '<')
                r.unread('<');
            InputSource source = new InputSource(r);
            data.saxParser.parse(source, data.xmlHandler);
            data.rowList = data.xmlHandler.getList();
            // AddAdditionalFields(data.file);// 是否添加附加字段
            // addFileToResultFilesname(data.file);// 是否添加到结果文件名列表
        } catch (Exception e) {
            // TODO
            logger.error("" + e);
        } finally {
            // 关闭资源
        }

        return true;
    }

    private boolean openNextFile() {
        try {
            if (data.filenr >= data.files.nrOfFiles()) // finished processing!
            {
                logger.debug("Finished processing files.");
                return false;
            }
            // Is this the last file?
            data.file = data.files.getFile(data.filenr);
            data.previousRow = null;
            logger.debug("Opening file: " + data.file.getName().toString());
            data.filenr++;
        } catch (Exception e) {
            logger.error("不能打开文件" + data.file.toString() + data.filenr,
                    e.toString());
            // TODO停止所有
            return false;
        }
        return true;
    }

    /**
     * 对一条记录的各个字段进行一些处理，比如去空格、转换字段类型等
     *
     * @param rowMap
     * @return
     */
    private Object[] getRowFromRowList(Map<String, String> rowMap) {
        Object[] outputRowData = buildEmptyRow();

        String value = null;
        try {
            for (int i = 0; i < meta.getInputFields().length; i++) {
                XMLSourceField fieldMeta = meta.getInputFields()[i];
                if (rowMap.keySet().contains(fieldMeta.getName())) {
                    value = rowMap.get(fieldMeta.getName());
                    // 当字段值为空，且在集成开发工具设置空值与null值不同时，设置字段值为null
                    if (Const.isEmpty(value)
                            && ValueMeta.EMPTY_STRING_AND_NULL_ARE_DIFFERENT) {
                        value = null;
                    }
                    // DO Trimming!
                    switch (fieldMeta.getTrimtype()) {
                        case XMLSourceField.TYPE_TRIM_LEFT:
                            value = Const.ltrim(value);
                            break;
                        case XMLSourceField.TYPE_TRIM_RIGHT:
                            value = Const.rtrim(value);
                            break;
                        case XMLSourceField.TYPE_TRIM_BOTH:
                            value = Const.trim(value);
                            break;
                        default:
                            break;
                    }

                    // DO CONVERSIONS...
                    ValueMetaInterface targetValueMeta = data.outputRowMeta
                            .getValueMeta(data.totalpreviousfields + i);
                    ValueMetaInterface sourceValueMeta = data.convertRowMeta
                            .getValueMeta(data.totalpreviousfields + i);
                    outputRowData[data.totalpreviousfields + i] = targetValueMeta
                            .convertData(sourceValueMeta, value);
                } else {
                    value = null;
                }

                // 如果字段值为空且选择了重复
                if (meta.getInputFields()[i].isRepeat()) {
                    if (data.previousRow != null && Const.isEmpty(value)) {
                        outputRowData[data.totalpreviousfields + i] = data.previousRow[data.totalpreviousfields
                                + i];
                    }
                }
            }// End of loop over fields...
            // 是否添加附加字段
            int rowIndex = data.totalpreviousfields + data.nrInputFields;

            // See if we need to add the filename to the row...
            if (meta.includeFilename()
                    && !Const.isEmpty(meta.getFilenameField())) {
                outputRowData[rowIndex++] = data.filename;
            }
            // See if we need to add the row number to the row...
            if (meta.includeRowNumber()
                    && !Const.isEmpty(meta.getRowNumberField())) {
                outputRowData[rowIndex++] = new Long(data.rownr);
            }
            // Possibly add short filename...
            if (meta.getShortFileNameField() != null
                    && meta.getShortFileNameField().length() > 0) {
                outputRowData[rowIndex++] = data.shortFilename;
            }
            // Add Extension
            if (meta.getExtensionField() != null
                    && meta.getExtensionField().length() > 0) {
                outputRowData[rowIndex++] = data.extension;
            }
            // add path
            if (meta.getPathField() != null && meta.getPathField().length() > 0) {
                outputRowData[rowIndex++] = data.path;
            }
            // Add Size
            if (meta.getSizeField() != null && meta.getSizeField().length() > 0) {
                outputRowData[rowIndex++] = new Long(data.size);
            }
            // add Hidden
            if (meta.isHiddenField() != null
                    && meta.isHiddenField().length() > 0) {
                outputRowData[rowIndex++] = new Boolean(data.path);
            }
            // Add modification date
            if (meta.getLastModificationDateField() != null
                    && meta.getLastModificationDateField().length() > 0) {
                outputRowData[rowIndex++] = data.lastModificationDateTime;
            }
            // Add Uri
            if (meta.getUriField() != null && meta.getUriField().length() > 0) {
                outputRowData[rowIndex++] = data.uriName;
            }
            // Add RootUri
            if (meta.getRootUriField() != null
                    && meta.getRootUriField().length() > 0) {
                outputRowData[rowIndex++] = data.rootUriName;
            }
        } catch (Exception e) {// TODO
            logger.error("");
        } finally {
            rowMap.remove(rowMap);// 处理完这条记录，从集合里删除
        }
        return outputRowData;
    }

    /**
     * Build an empty row based on the meta-data...
     *
     * @return
     */
    private Object[] buildEmptyRow() {
        return RowDataUtil.allocateRowData(data.outputRowMeta.size());
    }

    @Override
    protected void doStart() throws DgfException {
        // 启动前的准备
        try {
            data.saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        XMLSourceField[] fields = meta.getInputFields();
        List<String> tagNames = new ArrayList<String>();
        List<String> attNames = new ArrayList<String>();
        for (int i = 0; i < fields.length; i++) {
            XMLSourceField field = fields[i];
            if (field.getElementtype() == XMLSourceField.ELEMENT_TYPE_NODE) {
                tagNames.add(field.getName());
            } else {
                attNames.add(field.getName());
            }
        }
        data.xmlHandler = new XMLSourceHandler(meta.getLoopXPath(), tagNames,
                attNames);

    }

    @Override
    protected void doStop() throws DgfException {
        logger.info("stop XMLSource.....");
        stop = false;
    }

    // 常量
    private static final String DOT = ".";
    private static final String FILE = "file";
    private static final String FIELD = "field";

    public static final String XML_SOURCE_ENCODING = "encoding";
    public static final String XML_SOURCE_LOOPXPATH = "loopXpath";
    public static final String XML_SOURCE_FILENAME = "name";
    public static final String XML_SOURCE_FILEMASK = "filemask";// 连接源的文件名称,如：mysql.ds
    public static final String XML_SOURCE_EXCLUDEFILEMASK = "excludeFilemask";
    public static final String XML_SOURCE_FILEREQUIRED = "fileRequired";
    public static final String XML_SOURCE_INCLUDESUBFOLDERS = "includeSubfolders";

    public static final String XML_SOURCE_FIELDNAME = "name";// 数据库中的类型
    public static final String XML_SOURCE_XPATH = "xpath";// java.sql.Types
    public static final String XML_SOURCE_ELEMENTTYPE = "elementType";
    public static final String XML_SOURCE_RESULTTYPE = "resultType";// 字段数据库中的字段类型名字
    public static final String XML_SOURCE_TYPE = "type";
    public static final String XML_SOURCE_FORMAT = "format";
    public static final String XML_SOURCE_LENGTH = "length";
    public static final String XML_SOURCE_PRECISION = "precision";
    public static final String XML_SOURCE_CURRENCYSYMBOL = "currencySymbol";
    public static final String XML_SOURCE_DECIMALPOINTSYMBOL = "decimalPointSymbol";
    public static final String XML_SOURCE_THOUSANDSEPARATOR = "thousandSeparator";
    public static final String XML_SOURCE_TRIMTYPE = "trimType";

    @Override
    protected void doConfigure(Context context) throws DgfException {
        // 数据配置
        Configurables.ensureRequiredNonNull(context, XML_SOURCE_ENCODING);
        String encoding = context.getString(XML_SOURCE_ENCODING);

        Configurables.ensureRequiredNonNull(context, XML_SOURCE_LOOPXPATH);
        String loopxpath = context.getString(XML_SOURCE_LOOPXPATH);

        meta.setEncoding(encoding);
        meta.setLoopXPath(loopxpath);

        List<String> files = context.getNumberedKeys(FILE);
        String fileNames[] = new String[files.size()];
        String fileMask[] = new String[files.size()];
        String excludeFileMask[] = new String[files.size()];
        String fileRequired[] = new String[files.size()];
        String includeSubFolders[] = new String[files.size()];
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(i);
            String name = file + DOT + XML_SOURCE_FILENAME;
            String regexp = file + DOT + XML_SOURCE_FILEMASK;
            String excluderegexp = file + DOT + XML_SOURCE_EXCLUDEFILEMASK;
            String required = file + DOT + XML_SOURCE_FILEREQUIRED;
            String includesubfolders = file + DOT
                    + XML_SOURCE_INCLUDESUBFOLDERS;

            fileNames[i] = context.getString(name);
            fileMask[i] = context.getString(regexp);
            excludeFileMask[i] = context.getString(excluderegexp);
            fileRequired[i] = context.getString(required);
            includeSubFolders[i] = context.getString(includesubfolders);
        }

        meta.setFileName(fileNames);
        meta.setFileMask(fileMask);
        meta.setExcludeFileMask(excludeFileMask);
        meta.setFileRequired(fileRequired);
        meta.setIncludeSubFolders(includeSubFolders);

        List<String> fields = context.getNumberedKeys(FIELD);
        XMLSourceField[] inputFields = new XMLSourceField[fields.size()];// 初始化XMLSourceField
        for (int i = 0; i < fields.size(); i++) {
            XMLSourceField field = new XMLSourceField();
            String fieldStr = fields.get(i);
            String fieldname = fieldStr + DOT + XML_SOURCE_FIELDNAME;
            String xpath = fieldStr + DOT + XML_SOURCE_XPATH;
            String elementtype = fieldStr + DOT + XML_SOURCE_ELEMENTTYPE;
            String resulttype = fieldStr + DOT + XML_SOURCE_RESULTTYPE;
            String type = fieldStr + DOT + XML_SOURCE_TYPE;
            String format = fieldStr + DOT + XML_SOURCE_FORMAT;
            String length = fieldStr + DOT + XML_SOURCE_LENGTH;

            String precision = fieldStr + DOT + XML_SOURCE_PRECISION;
            String currencysymbol = fieldStr + DOT + XML_SOURCE_CURRENCYSYMBOL;
            String decimalpointsymbol = fieldStr + DOT
                    + XML_SOURCE_DECIMALPOINTSYMBOL;
            String thousandseparator = fieldStr + DOT
                    + XML_SOURCE_THOUSANDSEPARATOR;
            String trimtype = fieldStr + DOT + XML_SOURCE_TRIMTYPE;

            field.setName(context.getString(fieldname));
            field.setXpath(context.getString(xpath));
            field.setElementtype(context.getInteger(elementtype));
            field.setResultType(context.getInteger(resulttype));
            field.setType(context.getInteger(type));
            field.setFormat(context.getString(format));

            field.setLength(context.getInteger(length) == null ? 0 : context
                    .getInteger(length));
            field.setPrecision(context.getInteger(precision) == null ? 0
                    : context.getInteger(precision));
            field.setCurrencySymbol(context.getString(currencysymbol) == null ? ""
                    : context.getString(currencysymbol));
            field.setDecimalPointSymbol(context.getString(decimalpointsymbol) == null ? ""
                    : context.getString(decimalpointsymbol));
            field.setThousandSeparator(context.getString(thousandseparator) == null ? ""
                    : context.getString(thousandseparator));
            field.setTrimtype(context.getInteger(trimtype) == null ? 0
                    : context.getInteger(trimtype));
            inputFields[i] = field;
        }
        meta.setInputFields(inputFields);

    }

    private String[] Xpaths;
    //	private String filename = "D:\\test\\demo.xml";
    private String xml;
    private String url;
    private String encoding = "UTF-8";
    private ArrayList<String> listpath;
    private int nr;

    /**
     * 获取XPath信息
     *
     * @param filename xml文件名，如果为多个时，取第一个
     * @return
     * @throws SAXException
     * @throws DocumentException
     * @throws MalformedURLException
     */
    @SuppressWarnings("unchecked")
    private String[] getLoopPathList(String filename) throws SAXException,
            DocumentException, MalformedURLException {
        this.listpath = new ArrayList<String>();// 初始化
        SAXReader reader = new SAXReader();
        InputStream is = null;
        try {
            Document document = null;
            if (!Const.isEmpty(filename)) {
                is = KettleVFS.getInputStream(filename);
                document = reader.read(is, encoding);
            } else {
                if (!Const.isEmpty(xml)) {
                    document = reader.read(new StringReader(xml));
                } else {
                    document = reader.read(new URL(url));
                }
            }
            List<Node> nodes = document.selectNodes(document.getRootElement()
                    .getName());
            for (Node node : nodes) {
                if (!listpath.contains(node.getPath())) {
                    nr++;
                    listpath.add(node.getName());
                    addLoopXPath(node);
                }
            }

        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
            }
        }
        String[] list_xpath = listpath.toArray(new String[listpath.size()]);
        return list_xpath;
    }

    private void addLoopXPath(Node node) {
        Element ce = (Element) node;
        for (int j = 0; j < ce.nodeCount(); j++) {
            Node cnode = ce.node(j);

            if (!Const.isEmpty(cnode.getName())) {
                Element cce = (Element) cnode;
                if (!listpath.contains(cnode.getName())) {
                    nr++;
                    listpath.add(cnode.getName());
                }
                // let's get child nodes
                if (cce.nodeCount() > 1)
                    addLoopXPath(cnode);
            }
        }
    }
}
