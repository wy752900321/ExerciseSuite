package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
		public static Connection getConnection() throws Exception{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wangxin?useUnicode=true&characterEncoding=utf8","root","");
			return conn;
		}
		//关闭连接
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
		/*public static void main(String args[]){
			try {
				System.out.println(getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
}
