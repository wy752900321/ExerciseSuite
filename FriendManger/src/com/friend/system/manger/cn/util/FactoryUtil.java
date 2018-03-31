package com.friend.system.manger.cn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryUtil {
	private static final Properties table;
	static{
		table = new Properties();
		InputStream file = FactoryUtil.class.getClassLoader().getResourceAsStream("factory.properties");
		try {
			table.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object getInstance(String type){
		Object object = null;
		if(table.containsKey(type)){
			String className = table.getProperty(type);
			object = ReflectUtil.createObject(className);
		}
		return object;
	}
}
