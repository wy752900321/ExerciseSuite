package com.tarena.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbPoolUtil {
	private static DataSource dataSource;
	private static ThreadLocal<Connection> connLocal=
		new ThreadLocal<Connection>();
	static {
		Properties props = new Properties();
		try {
			props.load(DbPoolUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connection getConnection()throws SQLException{
		Connection conn = connLocal.get();
		if(conn==null){
			conn=dataSource.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	
	public synchronized static void closeConnection() throws SQLException{
		Connection conn  = connLocal.get();
		connLocal.set(null);
		if(conn !=null&& !conn.isClosed()){
			conn.close();
		}
	}
	
}
