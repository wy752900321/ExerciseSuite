package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcUtils;

public class EmpDaoImpl {

	@SuppressWarnings("static-access")
	public void saveEmp(String name) {
		JdbcUtils jdbcUtils = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 加载驱动
		jdbcUtils = new JdbcUtils();

		// 获取连接
		conn = jdbcUtils.getConnection();

		try {
			// 组织sql语句
			String sql = "INSERT INTO emp(id,name) VALUES(null,?)";
			// String sql="INSERT INTO emp(name) VALUES(?)";

			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			pstmt.setString(1, name);

			// 执行
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			jdbcUtils.closeResource(conn, pstmt, null);
		}
	}

}
