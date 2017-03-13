package test;

import java.sql.Connection;

import org.junit.Test;

import cn.itcast.util.JdbcUtils;

public class TestConnection {
	
	@Test
	public void testc3p0() {
		Connection conn = JdbcUtils.getConnection();
		System.out.println("conn  "+conn);
		
		
		conn = JdbcUtils.getConnection();
		System.out.println("conn  "+conn);
		
		conn = JdbcUtils.getConnection();
		System.out.println("conn  "+conn);
		
	}
}
