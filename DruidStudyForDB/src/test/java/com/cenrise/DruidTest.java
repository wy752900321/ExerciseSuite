package com.cenrise;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.cenrise.simple.DbPoolConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DruidTest {
    public static void main(String[] args) throws SQLException {
        DruidTest druidTest= new DruidTest();
        druidTest.executeUpdateBySQL("select * from T_DATASOURCE;");
    }
    private void executeUpdateBySQL(String sql) throws SQLException {
        DbPoolConnection dbp = DbPoolConnection.getInstance();
        DruidPooledConnection con = dbp.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
//        ps.executeUpdate();
        ResultSet rs = ps.executeQuery();
        System.out.println("查询的结果："+rs);
        ps.close();
        con.close();
        dbp = null;
    }
}
