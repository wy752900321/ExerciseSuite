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
		try{	
		//获取连接
		conn=JdbcUtils.getConnection();
		list=categoryDao.findAllCategorys(conn);
	}finally{
		JdbcUtils.closeResource(conn, null, null);
		}
	return list;
	}
	/**
	 * 通过id查询图书分类信息
	 * @param id
	 * @return
	 */
	public Category findCategoryById(String id){
		Connection conn = null;
		Category category = null;
		try{
			conn = JdbcUtils.getConnection();
			category = categoryDao.findCategoryById(conn,id);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
		return category;
	}
	/**
	 * 修改图书分类信息
	 * @param category
	 */
	public void updateCategory(Category category){
		Connection conn = null;
		try{
			//获取连接
			conn = JdbcUtils.getConnection();
			categoryDao.updateCategory(conn,category);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
	}
	/**
	 * 	通过Id删除图书分类信息
	 * @param id
	 */
	public void deleteCategoryById(String id) {
		Connection conn = null;
		try{
			//获取连接
			conn = JdbcUtils.getConnection();
			categoryDao.deleteCategoryById(conn,id);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
	}

}
