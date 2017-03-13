package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	private static Properties prop = new Properties();
	static{
		InputStream in = ConfigUtils.class.getClassLoader().getResourceAsStream("merchantInfo.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Properties getConfig(){
		return prop;
	}
	
}
