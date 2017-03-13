package tts.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatement {
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@192.168.0.26:1521:tarena", "openlab", "open123");
    String username = "a";
    String password = "c' or 'b'='b";
    // Statement stmt = con.createStatement();
    // ResultSet rs = stmt
    // .executeQuery("select count(*) from tts_user where username='"
    // + username + "'");

    // PreparedStatement封装了含有预定义参数的SQL语句
    // 必须给定预定义参数后,才可以运行
    PreparedStatement stmt = con
        .prepareStatement("select count(*) from tts_user "
            + "where username=? and password =?");
    // 用于设置预定义参数
    // 第一参数表示设置第几个预定义参数(问号)
    // 第二参数表示设置的值
    // 使用的类型必须和要设置的参数对应的列的类型匹配
    stmt.setString(1, username);
    stmt.setString(2, password);
    		//ResultSet executeQuery()throws SQLException
    		// 在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象。 
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      System.out.println(rs.getInt(1));
    }

    rs.close();
    stmt.close();
    con.close();

  }
}


