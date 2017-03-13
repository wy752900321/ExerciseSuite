package com.tarena.elts.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 *public class Properties extends Hashtable<Object,Object>
 *Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 *一个属性列表可包含另一个属性列表作为它的“默认值”；如果未能在原有的属性列表中搜索到属性键，则搜索第二个属性列表。 
 *String getProperty(String key) 用指定的键在此属性列表中搜索属性
 *void load(InputStream inStream) 从输入流中读取属性列表（键和元素对）。
 *void load(Reader reader) 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）
 */
public class ConnectionUtils {
  // 连接属性
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  static {
    try {
      // 在类加载时初始化连接属性
      Properties props = new Properties();
      // 通过文件流将属性文件的信息
      // 读入到Properties对象中
      InputStream is = ConnectionUtils.class
        .getClassLoader()
        .getResourceAsStream("db.properties");
        
        props.load(is);
      
      driver = props.getProperty("driver");
      url = props.getProperty("url");
      username = props.getProperty("username");
      password = props.getProperty("password");

      Class.forName(driver);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static Connection getConnection() throws Exception {
    Connection con = DriverManager
      .getConnection(url, username, password);
    return con;
  }
}
