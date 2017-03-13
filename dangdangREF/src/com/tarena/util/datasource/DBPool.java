package com.tarena.util.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBPool {

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	private static DataSource datasource;
	static {
		try {
			InitialContext context = new InitialContext();
			datasource = (DataSource) context
					.lookup("java:comp/env/jdbc/datasource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = threadLocal.get();
		if (conn == null) {
			conn = datasource.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}

	public static void close() {
		Connection conn = threadLocal.get();
		try {
			if (conn != null) {
				conn.close();
				threadLocal.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
