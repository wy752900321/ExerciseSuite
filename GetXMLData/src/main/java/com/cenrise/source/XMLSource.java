package com.cenrise.source;

import com.cenrise.RowDataUtil;
import com.cenrise.database.meta.RowMeta;
import com.cenrise.database.meta.ValueMeta;
import com.cenrise.database.meta.ValueMetaInterface;
import com.cenrise.exception.DGFValueException;
import com.cenrise.exception.DgfException;
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


    protected void doSchedule() {
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

//                    putDataToChannel(outputRowData);// 放入Channel中

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
