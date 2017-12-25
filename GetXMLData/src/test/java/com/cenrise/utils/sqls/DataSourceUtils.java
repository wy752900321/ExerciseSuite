package com.cenrise.utils.sqls;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.cenrise.azkaban.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by jeeth on 2017/10/30.
 */
public class DataSourceUtils {

    static Logger log = LoggerFactory.getLogger(DataSourceUtils.class);
    private static ConcurrentHashMap<String, DruidDataSource> dsMap = new ConcurrentHashMap<String, DruidDataSource>();
    private static Lock poollock = new ReentrantLock();

    // 连接池对象
    private static DataSource dataSource;

    public static Connection getConnection(String dsName) throws Exception {
        Connection conn = null;
        try {
            poollock.lock();
            DruidDataSource bds = dsMap.get(dsName);
            if (bds == null) {
                log.info("Can not get connection for ds[" + dsName + "].尝试创建连接。");
                createConnectionPool(getPropertiesByName(dsName));
                bds = dsMap.get(dsName);
                if (bds == null) {
                    throw new DatabaseException("Can not get connection for ds["
                            + dsName + "],after retry!");
                }
                return dsMap.get(dsName).getConnection();
            }
            if (bds != null && (bds.getActiveCount() < bds.getMaxActive())) {// 当前连接数据小于最大连接
                conn = dsMap.get(dsName).getConnection();
                log.info("after getConnection " + getDataSourceState(dsName)
                        + " max[" + bds.getMaxActive() + "]");
            } else {
                throw new Exception("获取过来的数据源为空！");
            }
            return conn;
        } catch (SQLException e1) {
            throw new DatabaseException("获取连接时发生异常！", e1);
        } finally {
            poollock.unlock();
        }
    }

    public static void createConnectionPool(Properties p) {
        String connectionName = p.getProperty("connectionName");
        try {
            DruidDataSource ds = (DruidDataSource) DruidDataSourceFactory
                    .createDataSource(p);
            ds.setAccessToUnderlyingConnectionAllowed(true);
            dsMap.put(connectionName, ds);
            log.info("Create connection pool succeed, datasource ["
                    + connectionName + "]");
        } catch (Exception e) {
            log.error("Create connection pool error, datasource["
                    + connectionName + "]", e);
        }

    }


    public static String getDataSourceState(String dbsourcename) {
        if (dbsourcename == null) {
            return "DataSourceName[" + dbsourcename + "]";
        }
        DruidDataSource bds = dsMap.get(dbsourcename);
        if (bds == null) {
            return "DataSourceName[" + dbsourcename + "] not found!";
        }
        String url = bds.getUrl();
        int i = bds.getActiveCount();
        int j = bds.getMaxActive() - bds.getActiveCount();

        int k = bds.getMaxActive();
        String rtn = "DataSourceName[" + dbsourcename + "]; url[" + url + "]; MaxActive[" + k + "]; Active[" + i + "]; Idle[" + j + "]";
        return rtn;
    }


    public static Properties getPropertiesByName(String datasourceName) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        Properties properties = new Properties();
        try {
            conn = DBUtil.openConnection();
            st = conn.createStatement();

            //执行SQL
            String sqlSource = "select * from dmp.T_DATASOURCE where connectionName='" + datasourceName + "';";
            rs = st.executeQuery(sqlSource);

            //处理结果
            while (rs.next()) {
                //每次循环，都取出一条记录
                int id = rs.getInt("id");
                String connectionName = rs.getString("connectionName");
                String type = rs.getString("type");
                String hostName = rs.getString("hostName");
                String dbName = rs.getString("dbName");
                int code = rs.getInt("code");
                String username = rs.getString("username");
                String password = rs.getString("password");
                checkArgument(id != 0, "ID不能为空！");
                checkArgument(connectionName != null, "数据库连接名称不能为空！");
                checkArgument(type != null, "数据库连接类型不能为空！");
                checkArgument(hostName != null, "主机名称或IP不能为空！");
                checkArgument(dbName != null, "数据库名称不能为空！");
                checkArgument(code != 0, "数据库端口号不能为空！");
                checkArgument(username != null, "用户名不能为空！");
                checkArgument(password != null, "密码为能为空！");

                properties.put("username", username);
                properties.put("password", RsaUtil.decrypt(password));
//                properties.put("maxActive", "30");
//                properties.put("maxIdle", "10");
//                properties.put("maxWait", "1000");
                properties.put("removeAbandoned", "true");
                properties.put("removeAbandonedTimeout", "1800");
                properties.put("logAbandoned", "true");

                //druid
                properties.put("filters", "stat");
                properties.put("initialSize", "2");
                properties.put("maxActive", "300");
                properties.put("maxWait", "60000");
                properties.put("timeBetweenEvictionRunsMillis", "60000");
                properties.put("minEvictableIdleTimeMillis", "300000");
                properties.put("validationQuery", "SELECT 'x'");
                properties.put("testWhileIdle", "true");
                properties.put("testOnBorrow", "true");
                properties.put("testOnReturn", "true");
                properties.put("poolPreparedStatements", "false");
                properties.put("maxPoolPreparedStatementPerConnectionSize", "200");

                properties.put("connectionName", connectionName);//用于后续注释
                if ("mysql".equals(type.toLowerCase())) {
                    String url = "jdbc:" + type + "://" + hostName + ":" + code + "/" + dbName +
                            "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&autoReconnectForPools=true&yearIsDateType=false";
                    String[] strings = url.split(":");
                    properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
                    properties.put("url", url);
                } else if ("oracle".equals(type.toLowerCase())) {
                    String url = "jdbc:" + type + ":thin:@" + hostName + ":" + code + ":" + dbName;
                    String[] strings = url.split(":");
                    properties.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                    properties.put("url", url);
                    properties.put("validationQuery", "SELECT 1 FROM DUAL");
                } else if ("kylin".equals(type.toLowerCase())) {
                    String url = "jdbc:" + type + "://" + hostName + ":" + code + "/" + dbName;
                    String[] strings = url.split(":");
                    properties.setProperty("driverClassName", "org.apache.kylin.jdbc.Driver");
                    properties.put("url", url);
                    properties.put("validationQuery", "SELECT 1 FROM DUAL");
                } else if ("12c".equals(type.toLowerCase())) {
                    String url = "jdbc:oracle:thin:@" + hostName + ":" + code + "/" + dbName;
                    String[] strings = url.split(":");
                    properties.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                    properties.put("url", url);
                    properties.put("validationQuery", "SELECT 1 FROM DUAL");
                } else {
                    //TODO 如果是其它方式的连接，如driverClassName可以尝试连接
//                    properties.put("driverClassName", type);
//                    properties.put("url", "");//
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                DBUtil.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            DBUtil.close(conn, st, null, rs);
        }

        return properties;
    }


}
