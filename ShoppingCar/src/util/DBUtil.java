package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jd1202db?useUnicode=true&characterEncoding=utf8", "root", "root");
			Statement stat = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
}
