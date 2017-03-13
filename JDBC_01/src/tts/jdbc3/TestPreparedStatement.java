package tts.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("" +
				"jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
		String username = "abc";//SQL注射问题
		String password = "123";
//		String password = "a' or 'c'='c ";
//		Statement stmt = con.createStatement();//用子接口PreparedStatement代替
//		ResultSet rs = stmt.executeQuery("select count(*) form tts_user where username'"+username +"'");
		//PreparedStatement准备运行 的SQL语句，只要给？值，就可以运行了
		//PreparedStatement封装了含有预定义参数的SQL语句
		//必须给定预定义参数后，才可以运行
		PreparedStatement stmt =con
			.prepareStatement("select count(*) from tts_user "
				+"where username=? and  password =?");

		//用于设置预定义参数
		//setInt,setDouble等代表你设置值的类型，必须和Oracle返回的类型一致的。
		//第一参数表示设置第几个预定义参数（问号）
		//第二个参数表示设置的值
		//使用的类型必须和要设置的参数对应的列的类型匹配 。
//		stmt.setXXX(1,XXX);
		//JDBC都是从1开始数，不是零
//		如果没参数(?)可以直接stmt.executeQuery()，如果有参数(?)就必须stmt.setString(1,XXX);
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			System.out.println(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
/**
总结：
Select与DML(insert/update/delete)的区别：
	1）sql语句不一样
	2）Select通过Statement对象的executeQuery()方法获得结果集：
			ResultSet rs = stmt.executeQuery()
	3) DML语句通过Statement对象的executeUpdate()方法获得操作数：
			int n = stmt.executeUpdate();
Select与DML(insert/update/delete)的相同点：
	1)   获得连接(Connection)方式相同。
	2）数据库连接对象(Statemetn/PreparedStatement)
			两种都可以需要多次执行的sql语句，使用PreparedStatement性能更好。
	3）如果使用PreparedStatement,sql语句在生成语句对象的时候传递，并绑定占位符(问号)和数据的关系
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,password);
			stmt.setString(1,id);
			stmt.setInt(2,id);
			stmt.executeQuery()或executeUpdate();//参数不写sql
	4) 	如果使用Statement,sql语句在执行时传递
			stmt = conn.createStatement();
			stmt.executeQuery(sql)或executeUpdate(sql)
	5)	PreparedStatement和Statement对象，sql语句的传递时机不同。
*/