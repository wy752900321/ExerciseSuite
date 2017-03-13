package cn.itcast.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private String username="root";
	private String psw="root";
	private String url="jdbc:mysql://localhost:3306/test";
	private String driverClassName="com.mysql.jdbc.Driver";
	
	
	/**
	 * 加载驱动
	 */
	public JdbcUtils(){
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, psw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeResource(Connection conn,Statement stmt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	
}
