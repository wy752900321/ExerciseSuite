package dbUtil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//数据源
	private static BasicDataSource dbs=null;
	//配置文件
	private static Configuration config=null;
	//ThreadLocal
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	//获取配置文件数据，生成数据源对象
	static{
		config=Configuration.config("/dbUtil/db.xml");
		dbs=new BasicDataSource();
		dbs.setDriverClassName(config.getDriver());
		dbs.setUrl(config.getUrl());
		dbs.setUsername(config.getUsername());
		dbs.setPassword(config.getPassword());
		dbs.setInitialSize(config.getInitialSize());
		dbs.setMaxActive(config.getMaxActive());
		dbs.setMaxIdle(config.getMaxIdle());
		dbs.setMinIdle(config.getMinIdle());
	}
	//获得数据库连接
	public static Connection getConnection() throws SQLException{
		Connection conn=tl.get();
		if(conn==null){
			conn=dbs.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	//关闭数据库连接
	public static void close() throws SQLException{
		Connection conn=tl.get();
		if(conn!=null){
			conn.close();
		}
		tl.remove();
	}
}






