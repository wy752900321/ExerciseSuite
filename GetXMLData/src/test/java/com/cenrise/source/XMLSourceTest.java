package com.cenrise.source;

import com.cenrise.source.vfs.KettleVFS;
import com.cenrise.util.Const;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractNode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取ktr
 */
public class XMLSourceTest {
    public static final int RESULT_TYPE_VALUE_OF = 0;
    public static final int RESULT_TYPE_TYPE_SINGLE_NODE = 1;

    List<AbstractNode> an;
    public static final String N0DE_SEPARATOR = "/";
    public static final String AT = "@";
    public List<String> NSPath = new ArrayList<String>();
    public String PathValue = "job/entries/entry";

    String nodevalue;

    public static void main(String[] args) {
        XMLSourceTest xmlSource = new XMLSourceTest();
        String filename = "/Users/jiadongpo/Downloads/SychAddData.xml";
        List<Map<String, String>> maps = xmlSource.readXML(filename, "/job/entries/entry");
        List<Map<String, String>> mapsHop = xmlSource.readXML(filename, "/job/hops/hop");
        List<Map<String, String>> mapsStep = xmlSource.readXML(filename, "/job/steps/step");

        for (Map<String, String> map : maps) {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + "======" + entry.getValue());
            }
        }
        for (Map<String, String> map : mapsHop) {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + "======" + entry.getValue());
            }
        }
        /*for (Map<String, String> map : mapsStep) {
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + "======" + entry.getValue());
            }
        }*/


    }

    public List<Map<String, String>> readXML(String fileAbsolutePath, String NodeName) {

        ArrayList<Map<String, String>> methodValueList = new ArrayList<Map<String, String>>();

        Document document = queryDocument(fileAbsolutePath);
        XPath xPath = document.createXPath(NodeName);
        List<AbstractNode> abstractNodes = xPath.selectNodes(document);
        //List<Node> nodes = document.selectNodes(NodeName);

        XMLSourceLoopTest xmlSourceLoopTest = new XMLSourceLoopTest(fileAbsolutePath);
        List<String> strings = xmlSourceLoopTest.queryXpath(NodeName);
        for (Node node : abstractNodes) {
            Map<String, String> methodValueMap = new HashMap<String, String>();
            for (String XPathValue : strings) {
//                XPath xpathField = node.createXPath(XPathValue);
//                String s = xpathField.valueOf(XPathValue);
//                List<AbstractNode> selectNodeFor = xpathField.selectNodes(document);

//                if (xmlDataField.getResultType() == RESULT_TYPE_VALUE_OF) {
                if (XPathValue != null && !XPathValue.contains("/")) {
                    nodevalue = node.valueOf(XPathValue);
                } else {
                    //如果是目录
//                    if ( xmlDataField.getResultType() == GetXMLDataField.RESULT_TYPE_VALUE_OF ) {
                    XPath xpathField = node.createXPath(XPathValue);
                    nodevalue = xpathField.valueOf(XPathValue);
//                    }
                    // nodevalue=node.selectSingleNode(XPathValue).asXML();
                    Node n = node.selectSingleNode(XPathValue);
                    if (n != null) {
                        nodevalue = n.asXML();
                    } else {
                        nodevalue = "";
                    }
                }
                //如果节点内无值，跳过
                if (nodevalue == null || nodevalue.equals("")) {
                    continue;
                }
                methodValueMap.put(XPathValue, nodevalue);
            }
            if (methodValueMap != null && methodValueMap.size() != 0) {
                methodValueList.add(methodValueMap);
            }

        }
        return methodValueList;

    }


    /**
     * 读取xml
     *
     * @param filename
     * @return
     */
    public Document queryDocument(String filename) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {

            if (!Const.isEmpty(filename)) {
                InputStream is = KettleVFS.getInputStream(filename);
                document = reader.read(is, "UTF-8");
            }
        } catch (Exception e) {

        }
        return document;
    }
}
