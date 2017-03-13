package DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(Thread.currentThread().getId());
			Connection conn=DBConnection.getConnection();
			Connection conn1=DBConnection.getConnection();
			System.out.println(conn==conn1);
			System.out.println(conn.equals(conn1));
			System.out.println(Thread.currentThread().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
