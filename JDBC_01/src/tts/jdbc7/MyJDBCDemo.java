package tts.jdbc7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyJDBCDemo {
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	
	public static void getParam(String filename){
		Properties propes=new Properties();
		File file = new File(filename);
		try{
			FileInputStream fis = new FileInputStream(file);
			//加载输入流指定的文件
			propes.load(fis);
			//获取文件中url（key）对应的value,并赋值给全局变量
			url = propes.getProperty("url");
			dbUser = propes.getProperty("dbUser");
			dbPassword=propes.getProperty("dbPassword");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//连接数据库，获取emp表的数据并输出到控制台
	public static void getEmpData(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//sql语句，注意没有分号
		String sql = "select * from emp";
		try{
			//利用DriverManager给连接对象赋值
			//需要三个参数：连接字符串，数据的用户名，密码
			conn=DriverManager.getConnection(url,dbUser,dbPassword);
			stmt = conn.createStatement();
			//传递sql语句到数据库中，并返回结果集
			rs = stmt.executeQuery(sql);
			
			//next()方法：指针一行，并返回boolean值
			while(rs.next()){
				//id,name,age是列名，oracle数据库中number类型的数据用getInt()取值
				//varchar2/char类型的数据用getString()取值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(id+","+name+","+age);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getParam("src/db_oracle.properties");
		getEmpData();
	}
}	
