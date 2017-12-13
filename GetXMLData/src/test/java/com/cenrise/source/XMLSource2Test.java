package com.cenrise.source;

import com.cenrise.source.vfs.KettleVFS;
import com.cenrise.util.Const;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML文件解析组件类，负责组件的处理逻辑
 *
 * @author jiadp
 */
public class XMLSource2Test {
    private static final Logger logger = LoggerFactory.getLogger(XMLSource2Test.class);

    public SAXParser saxParser;
    public XMLSourceHandler xmlHandler;
    public List<Map<String, String>> rowList;
    /**
     * 跳过数或行数在开始阅读
     */
    private String loopxpath = "entry";

    public static void main(String[] args) {

        try {
            String url = "/Users/jiadongpo/Downloads/SychAddData.xml";
            String url2 = "/Users/jiadongpo/Documents/VbillRepo/increment/T_SES_PAY_ORD_OPT_HIS/SychAddData.kjb";

            InputStream inputStream = KettleVFS.getInputStream(url);


            XMLSource2Test xmlSourceTest = new XMLSource2Test();
            xmlSourceTest.execute();

            String[] loopPathList = xmlSourceTest.getLoopPathList("/Users/jiadongpo/Documents/VbillRepo/increment/T_SES_PAY_ORD_OPT_HIS/SychAddData.kjb");
            System.out.println(loopPathList.length);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public void execute() throws IOException, SAXException, DocumentException {
        // 启动前的准备
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        List<String> tagNames = null;
        List<String> attNames = null;
        xmlHandler = new XMLSourceHandler(loopxpath, tagNames,
                attNames);


        String url = "/Users/jiadongpo/Downloads/SychAddData.xml";
        String url2 = "/Users/jiadongpo/Documents/VbillRepo/increment/T_SES_PAY_ORD_OPT_HIS/SychAddData.kjb";

//        InputStream inputStream = KettleVFS.getInputStream(url);
//        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream,
//                "UTF-8");
//
        SAXReader reader = new SAXReader();
        InputStream is = null;
        Document document = null;
        try {

            if (!Const.isEmpty(url)) {
                is = KettleVFS.getInputStream(url);
                document = reader.read(is, encoding);
            } else {
                if (!Const.isEmpty(xml)) {
                    document = reader.read(new StringReader(xml));
                } else {
                    document = reader.read(new URL(url));
                }
            }
        } catch (Exception e) {

        }
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read(inputStream);
        prepareNSMap(document.getRootElement());
        System.out.println(NAMESPACE.size());
        System.out.println(NSPath.size());

        FileInputStream inputStream = new FileInputStream("/Users/jiadongpo/Documents/VbillRepo/increment/T_SES_PAY_ORD_OPT_HIS/SychAddData.kjb");
        PushbackReader r = new PushbackReader(new InputStreamReader(inputStream,
                "UTF-8"));
        int ch = -1;
        // scan for the < character
        while ((ch = r.read()) != '<')
            ;
        if (ch == '<')
            r.unread('<');
        InputSource source = new InputSource(r);
        saxParser.parse(source, xmlHandler);
        List<Map<String, String>> rowList = xmlHandler.getList();
    }


    public Map<String, String> NAMESPACE = new HashMap<String, String>();
    public List<String> NSPath = new ArrayList<String>();

    public void prepareNSMap(Element l) {
        @SuppressWarnings("unchecked")
        List<Namespace> namespacesList = l.declaredNamespaces();
        for (Namespace ns : namespacesList) {
            if (ns.getPrefix().trim().length() == 0) {
                NAMESPACE.put("pre" + NSPath.size(), ns.getURI());
                String path = "";
                Element element = l;
                while (element != null) {
                    if (element.getNamespacePrefix() != null && element.getNamespacePrefix().length() > 0) {
                        path = "/" + element.getNamespacePrefix() + ":" + element.getName() + path;
                    } else {
                        path = "/" + element.getName() + path;
                    }
                    element = element.getParent();
                }
                NSPath.add(path);
            } else {
                NAMESPACE.put(ns.getPrefix(), ns.getURI());
            }
        }

        @SuppressWarnings("unchecked")
        List<Element> elementsList = l.elements();
        for (Element e : elementsList) {
            prepareNSMap(e);
        }
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
               /* Node entry = getSubNode((Node) node, "entry");
                if (entry == null) {
                    continue;
                }
                System.out.println(entry.getText());*/

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

    public static final Node getSubNode(Node n, String tag) {
        System.out.println(n.getName());
        if (n.getName().equals(tag)) {
            return n;
        }
        return null;
    }
}
