package com.tarena.util.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.util.file.Env;

public class DBConnection {

	// 一般加载配置文件和注册驱动使用static
	// 一次性加载
	static {
		try {
			Class.forName(Env.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Env.getString("url"), Env
				.getString("user"), Env.getString("password"));
	}

	/**
	 * 
	 * 有结果集关闭(查询)
	 * 
	 * @param rs
	 *            结果集
	 * @param ps
	 *            PreparedStatement
	 * @param conn
	 *            连接
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 有结果集关闭(查询)
	 * 
	 * @param rs
	 *            结果集
	 * @param stat
	 *            Statement
	 * @param conn
	 *            连接
	 */

	static public void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 无结果集关闭(删除、修改、更新)
	 * 
	 * @param ps
	 *            PreparedStatement
	 * @param conn
	 *            连接
	 */
	static public void close(PreparedStatement ps, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 无结果集关闭(删除、修改、更新)
	 * 
	 * @param stat
	 *            Statement
	 * @param conn
	 *            连接
	 */

	static public void close(Statement stat, Connection conn) {
		try {
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 事务处理
	// 提交事务
	public static void commitTran(Connection conn) {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 回滚事务
	public static void rollbackTran(Connection conn) {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
