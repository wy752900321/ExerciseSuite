package tts.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestDom4jWrite {
	public static void main(String[] args) throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("books");
		Element book1 = root.addElement("book");
		Element book2 = root.addElement("book");
		Element book1Name = book1.addElement("name");
		Element book1Price = book1.addElement("price");
		Element book2Name = book2.addElement("name");
		Element book2Price = book2.addElement("price");
		book1Name.setText("JabaJaba");
		book1Price.setText("100");
		book2Name.setText("C++C++");
		book2Price.setText("200");
		
		OutputFormat format = //OutputFormat.createPrettyPrint();
			OutputFormat.createCompactFormat();//去空，效率高
//		OutputFormat.createCompactFormat()?
		
		XMLWriter writer = new XMLWriter(System.out ,format);
		writer.write(doc);
	}
}
