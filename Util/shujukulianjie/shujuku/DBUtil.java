package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String url;
	private static String driver;
	private static String user;
	private static String password;
	static Connection conn = null;
	static{
		
		driver = Config.getString("driver");
		url = Config.getString("url");
		user = Config.getString("username");
		password = Config.getString("password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		public static Connection getConnection() throws Exception{ 
			conn = DriverManager.getConnection(url,user,password);
			return conn;
		}
		public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
			try {
				if(conn!=null){
					conn.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Connection conn,PreparedStatement pstmt){
			try {
				if(conn!=null){
					conn.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Connection conn,Statement stmt,ResultSet rs){
			try {
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Connection conn,Statement stmt){
			try {
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*public static void main(String[] args) {
				try {
					System.out.println(getConnection());
				} catch (Exception e) {
					e.printStackTrace();
				}
		}*/
}

