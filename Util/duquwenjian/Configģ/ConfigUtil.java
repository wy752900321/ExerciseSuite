package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties props = 
		new Properties();
	static{
		//读.properites文件，并且将文件的内容加载到
		//props对象里。
		//ClassLoader:类加载器,负责将.class文件加载到
		//方法区，转变成一个class对象。
		ClassLoader loader = 
			ConfigUtil.class.getClassLoader();
		System.out.println("loader:" + loader);
		InputStream ips = 
			loader.getResourceAsStream("util/dao.properties");
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return props.getProperty(key);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getValue("EmployeeDAO"));
	}

}
