package com.tarena.elts.util;

/**
 * 7. 系统配置文件的加载
 	1) Properties 类继承于Hashtable 是一个散列表.
 	2) Properties 提供了load方法可以将 client.properties 文件读取为散列表对象, 简洁方便
 	3) Properties 提供散列表查找方法 getProperty(key) 读取key对应的value值.
 	4) 创建Config 类封装Properties 方便配置文件的读取:
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Config读取系统的配置文件
public class Config {
	private Properties table = new Properties();

	public Config(String file) {
		try {
			//load方法可以将 client.properties 文件读取为散列表对象, 简洁方便
			table.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getInt(String key) {
		//散列表查找方法 getProperty(key) 读取key对应的value值.
		return Integer.parseInt(table.getProperty(key));
	}

	public String getString(String key) {
		return table.getProperty(key);
	}

	public double getDouble(String key) {
		return Double.parseDouble(table.getProperty(key));
	}
}
