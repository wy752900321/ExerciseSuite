package com.cenrise;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * Created by ThinkPad on 2017/8/2.
 */
public class DruidTest2 {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.16.133.220:3306/dmp");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10); // 启用监控统计功能  dataSource.setFilters("stat");// for mysql  dataSource.setPoolPreparedStatements(false);
        System.out.println(dataSource.getConnection());
    }
}
