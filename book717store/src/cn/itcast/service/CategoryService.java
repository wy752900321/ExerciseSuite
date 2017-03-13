package cn.itcast.service;

import java.sql.Connection;
import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.exception.ServiceException;
import cn.itcast.factory.DaoFactory;
import cn.itcast.util.JdbcUtils;

/**
 * 业务层
 */
public class CategoryService {

	private CategoryDao categoryDao = DaoFactory.getCategoryDao();

	public void saveCategory(Category category) {
		Connection conn = null;
		try {
			// 获取连接
			conn = JdbcUtils.getConnection();

			// 设置连接为非自动提交
			JdbcUtils.beginTransaction(conn);// 把事务封装

			// 调用dao层的方法保存
			categoryDao.saveCategory(conn, category);

			// 提交
			JdbcUtils.commitTransaction(conn);// 封装
		} catch (Exception e) {
			JdbcUtils.rollbackTransaction(conn);// 封装
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e);
		} finally {
			// 关闭资源
			JdbcUtils.closeResource(conn, null, null);
		}
	}
	/**
	 * 	获取所有的图书分类信息
	 */
	public List<Category> findAllCategorys() {
		Connection conn =null;
		List<Category> list=null;
			//获取连接
		conn=JdbcUtils.getConnection();
		list=categoryDao.findAllCategorys(conn);
		return list;
	}

}
