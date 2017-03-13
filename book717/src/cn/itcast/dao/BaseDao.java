package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Category;
import cn.itcast.exception.DaoException;

public abstract class BaseDao {
	/** 业务层
	 * 	通用的对数据进行crud操作的类 
	 * @param conn	连接 
	 * @param sql		sql语句
	 * @param params		参数
	 * @param errorMsg	错误信息
	 */
	public void update(Connection conn,String sql,Object[] params,String errorMsg){
		try {
			//调用方法保存
			QueryRunner query = new QueryRunner();
			query.update(conn,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(errorMsg,e);
		}
	}

	@SuppressWarnings("unchecked")
	public List findObjectByCondition(Connection conn, String sql,
			Object[] params, Class clazz, String errorMsg) {
		List list=null;
		try{
			QueryRunner query = new QueryRunner();
			list=(List)query.query(conn, sql,new BeanListHandler(clazz),params);
		}catch(SQLException e){
			e.printStackTrace();
			throw new DaoException(errorMsg,e);
		}
		return list;
	}

	/**
	 * 通过 id 查询图书信息
	 * @param conn
	 * @param sql
	 * @param params
	 * @param clazz
	 * @param errorMsg
	 * @return
	 */
	public Object findObjectById(Connection conn, String sql,
			Object[] params, Class<Category> clazz, String errorMsg) {
			Object bean = null;
			try{
				QueryRunner query = new QueryRunner();
				bean = query.query(conn, sql,new BeanHandler(clazz),params);
			}catch(SQLException e){
				e.printStackTrace();
				throw new DaoException(errorMsg,e);
			}
			return bean;
	}
}
