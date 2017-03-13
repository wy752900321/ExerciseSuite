package tts.jdbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		System.out.println(con);
		PreparedStatement stmt = con.prepareStatement("delect from tts_user where username=?");
		stmt.setString(1, "name1");
		//返回值表示执行的语句所影响的行数
		int rows = stmt.executeUpdate();
		System.out.println("rows="+rows);
		stmt.close();
		con.close();
	}
}
