package tts.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
		//用DOM4j的API去解析books.xml
		
		//解析器，封装了对XML数据的解析
		SAXReader reader = new SAXReader();
		
		//解析器读取数据
		//reader.read(InputStream is);
		FileInputStream fis = new FileInputStream("tts"+File.separator+"xml"+File.separator+"books.xml");
		//解析器读取数据,完成解析工作
		//返回Document对象，该对象中存
		//储解析后的XML树型数据
		Document doc = reader.read(fis);
		
		//调用Document的API或需要的数据
		
		//获取根元素
		Element root = doc.getRootElement();
		System.out.println(root.getName());
		
		//Element的elements方法
		//用于该元素的所有子元素
		//返回值是Element类型的List
		List<Element> list = root.elements();
		for(Element e: list){
			System.out.println(e.getName());
			List<Element> list1 = e.elements();
			for(Element e1:list){
				System.out.println(e1.getName());
				System.out.println(e1.getData());//返回元素的文件，在下面是文本时。
			}
		}
	}
}
