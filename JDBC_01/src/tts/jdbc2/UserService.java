package tts.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	/**
	 * 实现登录操作，成功返回true,否则返回false
	 */
	public boolean login(String username,String password) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
		Statement stmt = con.createStatement();
		String sql = "select count(*) from tts_user"+ " where username='" +
				username +"'and password ='"+ password+"'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		boolean b =false;
		if(rs.next()){
			int n = rs.getInt(1);
			if(n>0){
				b=true;
			}
		}
		con.close();
		stmt.close();
		rs.close();
		return b;
	}
}
/**
 * 		总结：
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