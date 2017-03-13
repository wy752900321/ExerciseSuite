package com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	如果发生异常，返回null。
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			conn = DriverManager
			.getConnection(
					"jdbc:mysql://localhost:3306/jd1202db?useUnicode=true&characterEncoding=utf8",
					"root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	public static void close(Connection conn) throws SQLException{
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
