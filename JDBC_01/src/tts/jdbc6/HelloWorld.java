package tts.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloWorld {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // 用JDBC的API来访问Oracle
    // 192.168.0.26 openlab/open123
    // 声明关键API
    Connection con = null; // 用于封装对数据库网络连接
    Statement stmt = null; // 用于封装用于执行的SQL语句
    ResultSet rs = null; // 用于封装SQL执行完后的查询结果
    // 装载Oracle对JDBC API的实现

    // 把oracle.jdbc.OracleDriver装入内存
    // OracleDriver的static块随即运行
    // static块中的代码会向DriverManager注册Oracle驱动类(即OracleDriver)对象
    // 将来JDBC将通过该驱动类找到JDBC API的相应实现
    Class.forName("oracle.jdbc.OracleDriver");
    // MySQL: com.mysql.jdbc.Driver
    // 获得Oracle对应Connection接口的实现
    System.out.println(con);
    con = DriverManager.getConnection(
        "jdbc:oracle:thin:@192.168.0.26:1521:tarena", "openlab", "open123");
    // jdbc:mysql://ip:port/databaseName
    System.out.println(con);

    stmt = con.createStatement();
    System.out.println(stmt);
    // 执行一个查询语句,返回值是ReslutSet
    rs = stmt.executeQuery("select empno, ename, salary from emp_ning");

    // 将调用rs的方法获取查询的结果
    while (rs.next()) {
      int empno = rs.getInt(1);
      String ename = rs.getString(2);
      double sal = rs.getDouble(3);
      System.out.println(empno + "," + ename + "," + sal);
    }

    // 释放资源
    rs.close();
    stmt.close();
    con.close();

  }

}
