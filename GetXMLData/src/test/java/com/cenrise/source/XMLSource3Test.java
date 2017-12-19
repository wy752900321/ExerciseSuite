package com.cenrise.source;

import com.cenrise.source.vfs.KettleVFS;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.Namespace;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML文件解析组件类，负责组件的处理逻辑
 *
 * @author jiadp
 */
public class XMLSource3Test {
    private static final Logger logger = LoggerFactory.getLogger(XMLSource3Test.class);

    public SAXParser saxParser;
    public XMLSourceHandler xmlHandler;
    public List<Map<String, String>> rowList;
    /**
     * 跳过数或行数在开始阅读
     */
    private String loopxpath = "entry";

    String file = "/Users/jiadongpo/Downloads/SychAddData.xml";
    public static final int RESULT_TYPE_VALUE_OF = 0;
    public static final int RESULT_TYPE_TYPE_SINGLE_NODE = 1;

    List<AbstractNode> an;
    public static final String N0DE_SEPARATOR = "/";
    public static final String AT = "@";
    public List<String> NSPath = new ArrayList<String>();
    public String PathValue = "job/entries/entry";


    public static void main(String[] args) throws DocumentException {
        XMLSource3Test xmlSource3Test = new XMLSource3Test();
        xmlSource3Test.execute();
    }


    public void execute() throws DocumentException {
        SAXReader reader = XMLParserFactoryProducer.getSAXReader(null);
        // 跳过DTD
        reader.setEntityResolver(new IgnoreDTDEntityResolver());
        // 跳过注释
        reader.setIgnoreComments(true);
        reader.addHandler(PathValue, new ElementHandler() {
            public void onStart(ElementPath path) {
                // do nothing here...
            }

            public void onEnd(ElementPath path) {

            }
        });
        InputStream is = KettleVFS.getInputStream(file);
        Document document = reader.read(is, "UTF-8");

        applyXPath(document, PathValue);
        String XPathValue = "name";
        String nodevalue;
        for (AbstractNode node : an) {
            XPath xpathField = node.createXPath(addNSPrefix(XPathValue, PathValue));
            nodevalue = node.valueOf(XPathValue);
            System.out.println(nodevalue);
            /*if ( xmlDataField.getResultType() == RESULT_TYPE_VALUE_OF ) {
                nodevalue = node.valueOf( XPathValue );
            } else {
                // nodevalue=node.selectSingleNode(XPathValue).asXML();
                Node n = node.selectSingleNode( XPathValue );
                if ( n != null ) {
                    nodevalue = n.asXML();
                } else {
                    nodevalue = "";
                }
            }*/

        }

    }

    private boolean applyXPath(Document document, String PathValue) {
        try {
            XPath xpath = document.createXPath(PathValue);
            xpath = document.createXPath(addNSPrefix(PathValue, PathValue));
            // get nodes list
            an = xpath.selectNodes(document);

        } catch (Exception e) {
            System.out.println("Error while applying xPath. Error");
            return false;
        }
        return true;
    }

    public String addNSPrefix(String path, String loopPath) {
        if (NSPath.size() > 0) {
            String fullPath = loopPath;
            if (!path.equals(fullPath)) {
                for (String tmp : path.split(N0DE_SEPARATOR)) {
                    if (tmp.equals("..")) {
                        fullPath = fullPath.substring(0, fullPath.lastIndexOf(N0DE_SEPARATOR));
                    } else {
                        fullPath += N0DE_SEPARATOR + tmp;
                    }
                }
            }
            int[] indexs = new int[fullPath.split(N0DE_SEPARATOR).length - 1];
            java.util.Arrays.fill(indexs, -1);
            int length = 0;
            for (int i = 0; i < NSPath.size(); i++) {
                if (NSPath.get(i).length() > length && fullPath.startsWith(NSPath.get(i))) {
                    java.util.Arrays.fill(indexs, NSPath.get(i).split(N0DE_SEPARATOR).length - 2,
                            indexs.length, i);
                    length = NSPath.get(i).length();
                }
            }

            StringBuilder newPath = new StringBuilder();
            String[] pathStrs = path.split(N0DE_SEPARATOR);
            for (int i = 0; i < pathStrs.length; i++) {
                String tmp = pathStrs[i];
                if (newPath.length() > 0) {
                    newPath.append(N0DE_SEPARATOR);
                }
                if (tmp.length() > 0 && !tmp.contains(":") && !tmp.contains(".") && !tmp.contains(AT)) {
                    int index = indexs[i + indexs.length - pathStrs.length];
                    if (index >= 0) {
                        newPath.append("pre").append(index).append(":").append(tmp);
                    } else {
                        newPath.append(tmp);
                    }
                } else {
                    newPath.append(tmp);
                }
            }
            return newPath.toString();
        }
        return path;
    }

    public Map<String, String> NAMESPACE = new HashMap<String, String>();

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
                        path = N0DE_SEPARATOR + element.getNamespacePrefix() + ":" + element.getName() + path;
                    } else {
                        path = N0DE_SEPARATOR + element.getName() + path;
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

}
