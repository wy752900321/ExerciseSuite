package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestNull {
	public static void main(String[] args) throws Exception {
		//如果是数值类型，而且是NULL，JDBC返回的是0
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement stmt = con
			.prepareStatement("select ename,bonus from emp_ning");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			//如果是数值类型，而且是NULL,JDBC返回0
			System.out.println(rs.getString(1)+" ");
			System.out.println(rs.getDouble(2)+" ");
			//刚刚取的列是否为空
			System.out.println(rs.wasNull());
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
