package com.tarena.elts.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		// Properties继承于Hashtable
		// Properties也是散列表，key:value 都是String散列表
		Properties cfg = new Properties();
		// 将roperties格式的文本文件，读取为散列表
		// load可以将一个文件打开，做一个文件流
		cfg.load(new FileInputStream("client.properties"));// 读取控制文件
		System.out.println(cfg);
		// getProperty查散列表，根据key，查value.返回值是字符串类型
		String filename = cfg.getProperty("UserFile");
		System.out.println(filename);// user.txt
	}
}
