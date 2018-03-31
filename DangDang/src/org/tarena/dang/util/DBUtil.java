package org.tarena.dang.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil {
	// 连接池对象
	private static DataSource dataSource;
	// 负责将connection与当前执行线程绑定
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();

	static {
		try {
			Properties props = new Properties();
			props.load(DBUtil.class.getClassLoader().getResourceAsStream(
					"dbcp.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection openConnection() throws SQLException {
		Connection conn = connLocal.get();
		if (conn == null) {
			conn = dataSource.getConnection();
			connLocal.set(conn);
		}
		conn.setAutoCommit(false);//解决了Can't call commit when autocommit=true异常问题
		return conn;
	}

	public static void closeConnection() throws SQLException {
		Connection conn = connLocal.get();
		connLocal.set(null);
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

}
