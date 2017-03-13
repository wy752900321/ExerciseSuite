package tts.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	/**
	 * 实现登录操作，成功返回true,否则返回false
	 * @param username
	 * @param password
	 * @return 
	 * @return
	 */
	public boolean login(String username,String password) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
	
		PreparedStatement stmt = con
			.prepareStatement("select count(*) from tts_user "
					+"where username=? and password =?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
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
