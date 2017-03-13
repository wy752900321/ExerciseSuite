package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *		基于查询分页，排序
 */
public class SelectPageUp {
	public static void main(String[] args) {
		getOrderPage();
	}

	public static void getOrderPage() {
		String sql = "select rownum,empno,ename,salary from("
				+ "select empno,ename,salary " + "from emp_xxx"
				+ " where salary is not null " + "order by salary desc)"
				+ "where rownum<6";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ","
						+ rs.getString("ename") + "," + rs.getDouble("salary"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs);
			ConnectionUtils.close(stmt);
			ConnectionUtils.close(conn);
		}
	}
}