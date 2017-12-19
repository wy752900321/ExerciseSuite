package com.cenrise.source;

import com.cenrise.source.vfs.KettleVFS;
import com.cenrise.util.Utils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.eclipse.core.runtime.IProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * XML文件解析组件类，获取xml解析的测试方式
 * 0 = "/job"
 * 1 = "/job/name"
 * 2 = "/job/description"
 * 3 = "/job/extended_description"
 *
 * @author jiadp
 */
public class XMLSourceLoopTest {
    private static final Logger logger = LoggerFactory.getLogger(XMLSourceLoopTest.class);


    public XMLSourceLoopTest(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) throws Exception {
        XMLSourceLoopTest xmlSource3Test = new XMLSourceLoopTest("/Users/jiadongpo/Downloads/SychAddData.xml");
        List<String> strings = xmlSource3Test.queryXpath("/job/entries/entry");
        System.out.println(strings.size());
    }

    private String[] Xpaths;
    private String filename;
    private String xml;
    private String url;
    private String encoding = "UTF-8";
    private ArrayList<String> listpath = new ArrayList<String>();
    private int nr;

    /**
     * 查指定前缀的xpath
     *
     * @param xpath
     * @return
     */
    public List<String> queryXpath(String xpath) {
        String[] xpathArray = open();
        List<String> stringList = Arrays.asList(xpathArray);
        return getNumberedKeys2(stringList, xpath);

    }

    public String[] open() {
        try {
            Xpaths = doScan(monitor);
            System.out.println(Xpaths.toString());
        } catch (Exception e) {
            e.printStackTrace();

            try {
                throw new Exception(" Error scanning file [" + filename + "]! " + e.toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return Xpaths;
    }


    @SuppressWarnings("unchecked")
    private String[] doScan(IProgressMonitor monitor) throws Exception {
        monitor.beginTask("Scanning file [{0}] ...", 1);

        SAXReader reader = XMLParserFactoryProducer.getSAXReader(null);
        monitor.worked(1);
        if (monitor.isCanceled()) {
            return null;
        }

        // Ignore DTD
        reader.setEntityResolver(new IgnoreDTDEntityResolver());
        monitor.worked(1);
        monitor
                .beginTask("Reading document...", 1);
        if (monitor.isCanceled()) {
            return null;
        }
        InputStream is = null;
        try {
            Document document = null;
            if (!Utils.isEmpty(filename)) {
                is = KettleVFS.getInputStream(filename);
                document = reader.read(is, encoding);
            } else {
                if (!Utils.isEmpty(xml)) {
                    document = reader.read(new StringReader(xml));
                } else {
                    document = reader.read(new URL(url));
                }
            }
            monitor.worked(1);
            monitor.beginTask("Document opened.",
                    1);
            monitor.worked(1);
            monitor.beginTask("Reading nodes ...", 1);

            if (monitor.isCanceled()) {
                return null;
            }
            List<Node> nodes = document.selectNodes(document.getRootElement().getName());
            monitor.worked(1);
            monitor.subTask("We found {0} Nodes ...");

            if (monitor.isCanceled()) {
                return null;
            }
            for (Node node : nodes) {
                if (monitor.isCanceled()) {
                    return null;
                }
                if (!listpath.contains(node.getPath())) {
                    nr++;
                    monitor.subTask("We found " + String.valueOf(nr) + " Nodes ..."
                    );
                    monitor.subTask("Adding Node [" + node
                            .getPath() + "]");
                    listpath.add(node.getPath());
                    addLoopXPath(node, monitor);
                }
            }
            monitor.worked(1);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) { /* Ignore */
            }
        }
        String[] list_xpath = listpath.toArray(new String[listpath.size()]);

        monitor.setTaskName("Nodes were returned. Finishing");

        monitor.done();

        return list_xpath;

    }

    private void addLoopXPath(Node node, IProgressMonitor monitor) {
        Element ce = (Element) node;
        monitor.worked(1);
        // List child
        for (int j = 0; j < ce.nodeCount(); j++) {
            if (monitor.isCanceled()) {
                return;
            }
            Node cnode = ce.node(j);

            if (!Utils.isEmpty(cnode.getName())) {
                Element cce = (Element) cnode;
                if (!listpath.contains(cnode.getPath())) {
                    nr++;
                    monitor.subTask(" We found " + String.valueOf(nr) + " Nodes ..."
                    );
                    monitor.subTask("Adding Node [" + cnode.getPath() + "]"
                    );
                    listpath.add(cnode.getPath());
                }
                // let's get child nodes
                if (cce.nodeCount() > 1) {
                    addLoopXPath(cnode, monitor);
                }
            }
        }
    }

    /**
     * 根据给定的前缀，获得该前缀的带序号的key
     *
     * @param prefix
     * @return
     */
    public List<String> getNumberedKeys(List<String> parameters, String prefix) {
        List<String> numberedKeys = new ArrayList<String>();
        if (parameters != null) {
            for (String pkey : parameters) {
                if (pkey.startsWith(prefix)) {
                    numberedKeys.add(pkey);
                }
            }
        }
        return numberedKeys;
    }

    /**
     * 根据给定的前缀，获得该前缀的带序号的key
     *
     * @param prefix
     * @return
     */
    public List<String> getNumberedKeys2(List<String> parameters, String prefix) {
        List<String> numberedKeys = new ArrayList<String>();
        if (parameters != null) {
            for (String pkey : parameters) {
                if (pkey.startsWith(prefix)) {
                    if (prefix.equals(pkey)) {
                        continue;
                    }
                    numberedKeys.add(pkey.replace(prefix + "/", ""));
                }
            }
        }
        return numberedKeys;
    }

    IProgressMonitor monitor = new IProgressMonitor() {
        public void beginTask(String s, int i) {

        }

        public void done() {

        }

        public void internalWorked(double v) {

        }

        public boolean isCanceled() {
            return false;
        }

        public void setCanceled(boolean b) {

        }

        public void setTaskName(String s) {

        }

        public void subTask(String s) {

        }

        public void worked(int i) {

        }
    };
}
