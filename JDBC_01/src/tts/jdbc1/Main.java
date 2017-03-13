package tts.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * JDBC第一天，上午课程
 */
public class Main {
	public static void main(String[] args) throws Exception{
		// 用JDBC的API来访问Oracle
		// 192.168.0.26 openlab/open123
		//声明关键API
		Connection con = null;// 接口Connection,用于封装对数据库网络连接
		Statement stmt = null;// 接口，用来封装要执行的SQL语句
		ResultSet rs = null;// 接口，用于封装运行SQL语句执行之后的查询结果
		
		//装载Oracle对JDBC API的实现
		
		//Class.forName():把括号里的类装到内存里边
		//把oracle.jdbc.OracleDriver装入内存
		//Class.forName("tts.jdbc.Foo");//如果有静态块，在类装载时执行
		//static块中的代码会向DriverManager注册Oracle驱动类(即OracleDriver)对象
		//将来JDBC将通过该驱动类找到JDBC API的相应实现
		//OracleDriver类里边有找其它实现类的方法，自动找 
		Class.forName("oracle.jdbc.OracleDriver");
		//MySql:com.mysql.jdbc.Driver
		
		//获得Oracle对应Connection接口的实现
		//返回值是对Connecction接口的实现
		//tarena:oracle的实例名,装Oracle时的SID
		//jdbc:oracle:thin:IP地址：端口号：实例名，user,password
		System.out.println(con);//null
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","opne123");
		//jdbc:mysql://ip:port/databaseName
		System.out.println(con);
		
		stmt = con.createStatement();
		System.out.println(stmt);//测试statement
		//执行一个查询语句,返回值是Resultset
		rs = stmt.executeQuery("select empno,ename,salary from emp_ning");
		
		//将调用rs的方法获取查询的结果。rs内部有个游标，指向哪一行就可以取哪一行的数据，默认在第一行的前边那一行上
		//rs.next();//把游标移动到下一行，返回一具boolean类型
	/*	if(rs.next()){
			//获得这一行，的第columnIndex列的数据。getInt,getDate,等。把取出的数据转换成XXX类型
			//rs.getXXX(columnIndex)
			int empno = rs.getInt(1);//第一行的第一列数据
			String ename = rs.getString(2);//第一行的第二列数据
			double sal = rs.getDouble(3);//第一行的第三列数据
			System.out.println(empno+","+ename+","+sal);
		}*/
		while(rs.next()){//循环
			//获得这一行，的第columnIndex列的数据。getInt,getDate,等。把取出的数据转换成XXX类型
			//rs.getXXX(columnIndex)
			int empno = rs.getInt(1);//第一行的第一列数据
			String ename = rs.getString(2);//第一行的第二列数据
			double sal = rs.getDouble(3);//第一行的第三列数据
			System.out.println(empno+","+ename+","+sal);
		}
		
		//释放资源
		rs.close();
		stmt.close();
		con.close();
	}

}
