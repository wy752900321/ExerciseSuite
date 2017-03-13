package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 基于查询分页，排序
 */
public class SelectPageDown {
	public static void main(String[] args) {
		// 按工资降序排序，取出第5－10条
		getOrderPage(5, 2);
	}

	public static void getOrderPage(int pageSize, int page) {
		int begin = (page - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		String sql = "select empno,ename,salary " +
				"from" +
				"(select rownum rn,empno,ename,salary" +
				" from" +
							"(select empno,ename,salary " +
							"from emp_xxx " +
							"where salary is not null" +
							"order by salary desc)"+
					")"+
							"where rn between ? and ?";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
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