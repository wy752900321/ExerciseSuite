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
		 * ����filenameָ�����ļ���������ȡ����ֵ���е����ݸ�ȫ�ֱ���url,dbUser,dbPassword��ֵ
		 */
		public static boolean	getParam(String filename){
			Properties propes = new Properties();
			File file = new File(filename);
			try{
				FileInputStream fis = new FileInputStream(file);
				//����������ָ�����ļ������ݷ����ֵ�Զ��� 
				propes.load(fis);
				//��ȡ�ļ���key��Ӧ��value����ȫ�ֱ�����ֵ
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
		//����getParam()��ò������������Ӳ�����,�������Ӷ���
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
		//�ر�����
		public static void close(Connection conn){
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		//�ر�������
		public static void close(Statement stmt){
			if(stmt !=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		//�رս����
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
