package tts.jdbc5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtils {
	//连接属性
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//类加载时就加载好这些变量
	static{
		try{
		//在类加载时初始化连接属性
		Properties props = new Properties();
		//通过文件流将属性的信息读入到Properties对象中
		//人类路径下加载属性文件
		//getClassLoader()获得装载类的装载器，也可以从类路径下装载文件
		//装载器的getResourceAsStream()，用半截器装类路径下的一个文件
		InputStream is =ConnectionUtils.class
				.getClassLoader()
				.getResourceAsStream("db.properties");
		props.load(is);
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//每调一次getConnection()，就产生一个新的连接。
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}
