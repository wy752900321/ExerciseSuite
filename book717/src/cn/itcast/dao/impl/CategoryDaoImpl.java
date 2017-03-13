package cn.itcast.dao.impl;

import java.sql.Connection;
import java.util.List;


import cn.itcast.dao.BaseDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.util.Global;

public class CategoryDaoImpl extends BaseDao implements CategoryDao{

	public void saveCategory(Connection conn, Category category) {
		// 设置错误提示信息
		String errorMsg = Global.DAO＿CATEGORY_ADD_EXCEPTION;
		//组织sql
		String sql = "insert into category(id,name,description) values(?,?,?)";
		//设置sql语句需要的参数
		Object[] params ={category.getId(),category.getName(),category.getDescription()};
		//调用父类的方法
		super.update(conn,sql,params,errorMsg);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategorys(Connection conn) {
		//设置错误提示信息
		String errorMsg="查询图书分类信息失败";
		//组织sql
		String sql = "select id,name,description from category";
		
		Object[] params=null;
		
		/*QueryRunner query=new QueryRunner();
		query.query(conn,sql, new BeanListHandlet(Category.class), params);*/
		
		return super.findObjectByCondition(conn,sql,params,Category.class,errorMsg);
	}

	public Category findCategoryById(Connection conn, String id) {
		//设置错误提示信息
		String errorMsg="通过ID查询图书分类信息失败";
		
		//组织sql语句
		String sql="SELECT id,name,description from category where id=?";
		Object[] params={id};
		return (Category)super.findObjectById(conn, sql, params, Category.class, errorMsg);
	}

	public void updateCategory(Connection conn, Category category) {
			//设置错误提示信息
		String errorMsg = "修改图书信息失败";
		
		//组织sql语句 
		String sql = "update category set name = ?,description=? where id = ?";
		
		//设置sql 语句 需要的参数
		Object[] params = {category.getName(),category.getDescription(),category.getId()};
		
		//调用父类的方法
		super.update(conn, sql, params, errorMsg);
	}
	
	public void deleteCategoryById(Connection conn, String id) {
		//设置错误提示信息
	String errorMsg = "删除图书信息失败";
	
	//组织sql语句 
	String sql = "delete from category where id = ?";
	
	//设置id语句需要的参数
	Object[] params = {id};
	
	//调用父类的方法
	super.update(conn, sql, params, errorMsg);
}


}
