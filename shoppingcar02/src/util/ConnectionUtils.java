package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtils {
		private static String url;
		private static String dbUser;
		private static String dbPassword;

		/*
		 * 读入filename指定的文件并解析，取出键值对中的数据给全局变量url,dbUser,dbPassword赋值
		 */
		public static boolean	getParam(String filename){
			Properties propes = new Properties();
			File file = new File(filename);
			try{
				FileInputStream fis = new FileInputStream(file);
				//加载输入流指定的文件，数据放入键值对对象 
				propes.load(fis);
				//获取文件中key对应的value，给全局变量赋值
				url = propes.getProperty("url");
				dbUser = propes.getProperty("dbUser");
				dbPassword = propes.getProperty("dbPassword");
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			return false;
		}
		//利用getParam()获得参数，构造连接并返回,返回连接对象
		public static Connection getConnection(){
			getParam("src"+File.separator+"util"+File.separator+"db_mysql.properties");
			Connection conn= null;
			try{
				conn = DriverManager.getConnection(url,dbUser,dbPassword);
			}catch(SQLException e){
				e.printStackTrace();
			}
			return conn;
		}
		//关闭连接
		public static void close(Connection conn){
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		//关闭语句对象
		public static void close(Statement stmt){
			if(stmt !=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		//关闭结果集
		public static void close(ResultSet rs){
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
}
