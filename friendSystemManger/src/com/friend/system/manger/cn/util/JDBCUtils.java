package com.friend.system.manger.cn.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String url;
	private static String dbUser;
	private static String dbpassword;
	private static String driver;
	
	
	static {
		Properties table = new Properties();
		InputStream file;
		try {
			file = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
			table.load(file);
			url = table.getProperty("url");
			dbUser = table.getProperty("dbUser");
			dbpassword = table.getProperty("dbPassword");
			driver = table.getProperty("driver");
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection(url,dbUser,dbpassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Connection connection){
		if(connection != null){
			try {
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement statement){
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet resultSet){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setAutoCommit(Connection connection ,boolean autoCommit){
		try {
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection connection){
		try {
			if(connection.getAutoCommit()){
				return;
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollBack(Connection connection){
		try {
			if(connection.getAutoCommit()){
				return;
			}
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}