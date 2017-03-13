package com.tarena.elts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tarena.elts.entity.User;

public class UserDao {
  private static final String sql_findUserByIdAndPwd = "select id, passwd from tts_user"
      + "where id=? and passwd=?";

  public User findUserByIdAndPwd(int id, String pwd) 
      throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = ConnectionUtils.getConnection();
      stmt = con.prepareStatement(sql_findUserByIdAndPwd);
      stmt.setInt(1, id);
      stmt.setString(2, pwd);

      rs = stmt.executeQuery();

      if (rs.next()) {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setPasswd(rs.getString(2));
        return user;
      }
    } catch (Exception e) {
      // con.rollback();
      e.printStackTrace();
      throw e;
    } finally {
      if (rs != null)
        rs.close();
      if (stmt != null)
        stmt.close();
      if (con != null)
        con.close();
    }

    return null;
  }
}
