package com.wangxin.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBPoolUtil {
		private static DataSource dataSource;
		private static ThreadLocal<Connection> connLocal = 
			new ThreadLocal<Connection>();
		static{
			Properties prop = new Properties();
			try {
				prop.load(DBPoolUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
				dataSource = BasicDataSourceFactory.createDataSource(prop);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public synchronized static Connection getConnection() throws SQLException{
			Connection conn = connLocal.get();
			if(conn == null){
				conn = dataSource.getConnection();
				connLocal.set(conn);
			}
			return conn;
		}
		public synchronized static void close() throws SQLException{
			Connection conn = connLocal.get();
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
			connLocal.set(null);
		}
}
