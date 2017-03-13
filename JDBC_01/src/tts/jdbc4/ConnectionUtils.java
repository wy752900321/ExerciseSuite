package tts.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
	//每调一次getConnection()，就产生一个新的连接。
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager
			.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena",
					"openlab","open123");
		return con;
	}
}
