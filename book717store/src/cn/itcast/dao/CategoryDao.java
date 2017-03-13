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

}
