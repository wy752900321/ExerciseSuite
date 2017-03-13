package com.tarena.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * 为了读取dao配置文件
 * 
 * @author soft01
 * 
 */
public class ConfigUtil implements Serializable {
	private static final long serialVersionUID = 2052132455163489640L;
	private static Properties table = new Properties();

	static {
		try {
			// 通过反射流读取dao.properties配置文件
			table.load(ConfigUtil.class.getResourceAsStream("jdbcdao.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过key找到value
	 * 
	 * @param key
	 *            配置文件的key
	 * @return 返回一个字符串类型的value
	 */
	public static String getValue(String key) {
		return table.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(getValue("UserDAO"));
	}
}
