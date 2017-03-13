package tts.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {
	public static void main(String[] args) throws Exception{
		/*Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager
			.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena",
					"openlab","open123");*/
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into " +
				"tts_7516(username,password values(?,?)");
		stmt.setString(1,"name1");
		stmt.setString(2,"pwd1");
		//返回值表示执行的语句所影响的行数
		int rows = stmt.executeUpdate();
		System.out.println("rows="+rows);
		
		stmt.close();
		con.close();
	}
}
