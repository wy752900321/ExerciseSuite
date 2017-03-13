package com.tarena.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	static Properties props = new Properties();
	static {
		try {
			props.load(PropertiesUtil.class
					.getClassLoader()
					.getResourceAsStream("opt.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String key){
		String val = props.getProperty(key);
		if(val == null){
			val = "";
		}
		return val;
	}
	public static void main(String[] args) {
		System.out.println(getProperty("com.tarena.dao.impl.UserDAOImpl.save"));
	}
}
