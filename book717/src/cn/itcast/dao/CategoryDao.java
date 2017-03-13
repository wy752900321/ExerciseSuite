package cn.itcast.dao;

import java.sql.Connection;
import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryDao {

	/**
	 * 	保存图书的种类
	 * @param conn
	 * @param category
	 */
	void saveCategory(Connection conn, Category category);
	/**
	 * 	查询所有的图书分类信息
	 * @return
	 */
	List<Category> findAllCategorys(Connection conn);
	/**
	 * 通过id删除图书信息
	 * @param conn
	 * @param id
	 */
	void deleteCategoryById(Connection conn, String id);
	/**
	 * 修改图书分类信息
	 * @param conn
	 * @param category
	 */
	void updateCategory(Connection conn, Category category);
	/**
	 * 通过id查询图书分类信息
	 * @param conn
	 * @param id
	 * @return
	 */
	Category findCategoryById(Connection conn, String id);

}
