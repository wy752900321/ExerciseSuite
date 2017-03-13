package com.tarena.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;

public class CategoryDAOImpl extends GetConnection implements CategoryDAO{
	private static final long serialVersionUID = 708100179886898038L;
	private static final String FindAll = "select * from d_category order by turn";
	private static final String FindByPId="select * from d_category where parent_id = ? ";
	private static final String FindNameById="select * from d_category where id = ? ";
	private static final String FindBookNumber = 
	"	select count(*)  from d_category_product dcp "+
	" join d_product dp on ( dcp.product_id = dp.id ) "+
	" join d_book db  on ( dp.id = db.id ) "+
	" where dcp.cat_id = ? ";


	public List<Category> findAll() throws Exception {
		List<Category> list = new ArrayList<Category>();
		Category category = null;
		PreparedStatement prep = getConnection().prepareStatement(FindAll);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setEnName(rs.getString("en_name"));
			category.setParentId(rs.getInt("parent_id"));
			category.setDiscription(rs.getString("description"));
			category.setTurn(rs.getInt("turn"));
			list.add(category);
		}
		return list;
	}
	
	
	public List<Category> findByPID(int pid) throws Exception {
		List<Category> list = new ArrayList<Category>();
		Category category = null;
		PreparedStatement prep = getConnection().prepareStatement(FindByPId);
		prep.setInt(1, pid);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setEnName(rs.getString("en_name"));
			category.setParentId(rs.getInt("parent_id"));
			category.setDiscription(rs.getString("description"));
			//System.out.println(rs.getInt("id")+"      .....................的图书数量为；    "+findBookNumber(rs.getInt("id")));
			category.setBookNum(findBookNumber(rs.getInt("id")));
			category.setTurn(rs.getInt("turn"));
			list.add(category);
		}
		return list;
	}
	//通过d_category_product 中的cat_id 查找对应的书籍数目；
	//d_category_product ,d_product,d_book 三表联合查询；
	public int findBookNumber(int cat_id) throws Exception{
		int bookNumber=0;
		PreparedStatement prep = getConnection().prepareStatement(FindBookNumber);
		prep.setInt(1, cat_id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			bookNumber = rs.getInt(1);
		}
		return bookNumber;
	}
	
	public String findNameById(Integer pid) throws Exception {
		String name = null;
		PreparedStatement prep = getConnection().prepareStatement(FindNameById);
		prep.setInt(1, pid);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			name=rs.getString("name");
		}
		return name;
	}
	
	public static void main(String[]args) throws Exception{
		CategoryDAOImpl dao = new CategoryDAOImpl();
//		List<Category> list = dao.findAll();
//		for(Category c : list){
//			System.out.println(c.getId()+"    "+c.getName());
//		}
//		List<Category> list = dao.findByPID(3);
//		for(Category c : list){
//			System.out.println(c.getId()+"    "+c.getName());
//			System.out.println(c.getBookNum());
//		}
		String list = dao.findNameById(3);
		System.out.println(list);

	}


}
