package com.cenrise;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库 用于获得数据库连接的工具类
 *
 * @author
 */
public class DBUtil {
    // 连接池对象
    private static DataSource dataSource;

    // 负责将connection与当前执行线程绑定
    private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();

    static {
        try {
            Properties props = new Properties();
            props.load(DBUtil.class.getClassLoader().getResourceAsStream("db_datasource.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection openConnection()
            throws SQLException {
        Connection conn = connLocal.get();
        if (conn == null) {
            conn = dataSource.getConnection();
            connLocal.set(conn);
        }
        return conn;
    }

    public static void closeConnection()
            throws SQLException {
        Connection conn = connLocal.get();
        connLocal.set(null);
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    /**
     * 关闭数据库各种资源Connection Statement PreparedStatement ResultSet的方法
     * @param conn
     * @param st
     * @param pps
     * @param rs
     */
    public static void close(Connection conn, Statement st, PreparedStatement pps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pps != null) {
            try {
                pps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if (conn != null && !conn.isClosed()) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try {
            Connection conncection= DBUtil.openConnection();
            System.out.println(conncection.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
