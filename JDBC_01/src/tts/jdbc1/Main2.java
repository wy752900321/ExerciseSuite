package tts.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main2 {
	public static void main(String[] args) throws Exception {
		Connection con = null;// 接口Connection,用于封装对数据库网络连接
		Statement stmt = null;// 接口，用来封装要执行的SQL语句
		ResultSet rs = null;// 接口，用于封装运行SQL语句执行之后的查询结果

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println(con);// null
		con = DriverManager.getConnection("jdbc:oracle:thin:"
				+ "@192.168.0.26:1521:tarena", "openlab", "opne123");
		System.out.println(con);

		stmt = con.createStatement();
		System.out.println(stmt);// 测试statement
		rs = stmt.executeQuery("select empno,ename,salary from emp_ning");

		while (rs.next()) {// 循环
			int empno = rs.getInt(1);// 第一行的第一列数据
			String ename = rs.getString(2);// 第一行的第二列数据
			double sal = rs.getDouble(3);// 第一行的第三列数据
			System.out.println(empno + "," + ename + "," + sal);
		}
		rs.close();
		stmt.close();
		con.close();
	}

}
