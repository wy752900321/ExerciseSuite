package com.cenrise.source;

import com.cenrise.source.xml.XMLHandler;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import java.io.IOException;
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

    public static void main(String[] args) {
        String url = "file:/Users/jiadongpo/Downloads/SychAddData.xml";
        String url2 = "file:/Users/jiadongpo/Documents/VbillRepo/increment/T_SES_PAY_ORD_OPT_HIS/SychAddData.kjb";
        org.w3c.dom.Document document = XMLHandler.loadXMLFile(url);
        System.out.println(document.getXmlEncoding());
        org.w3c.dom.Node pluginNode = XMLHandler.getSubNode(document, "entry");
        System.out.println(pluginNode.getNodeName());

//        XMLHandler.getSubNode( XMLHandler.loadXMLFile( is, null, false, false ), "step" )

    }

}
