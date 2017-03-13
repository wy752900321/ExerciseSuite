package tts.xml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BookUtils {
	
	public static void bookToXML(List<Book> bookList,OutputStream os) 
		throws Exception {
		
	}
	public List<Book> xmlToBook(String xmlFileName) throws Exception {
		InputStream is = new FileInputStream(xmlFileName);
		return xmlToBook(is);
		
	}
	public List<Book> xmlToBook(InputStream is) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(is);
		Element root = doc.getRootElement();
		
		List<Element> bookElements = root.elements("book");//明确获得根元素下的book元素。
		for(Element bookElement : bookElements){
			Book book = new Book();
//			String name =bookElement.elements();
			List name =bookElement.elements();
		}
		
		return bookList;
	}
}
