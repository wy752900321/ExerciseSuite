package com.tarena.elts.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
  public static void main(String[] args) 
    throws IOException {
    //Properties 继承于Hashtable
    //Properties 也是散列表, key:value 都是String散列表
    Properties cfg = new Properties();
    //将 properties 格式的文本文件, 读取为散列表
    cfg.load(new FileInputStream("client.properties"));
    System.out.println(cfg); 
    String filename = cfg.getProperty("UserFile");
    System.out.println(filename);//user.txt
  }

}
