package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.entity.Category;
import org.tarena.dang.util.DBUtil;

public class CategoryDAOImpl implements CategoryDAO {
	private static final String FIND_ALL=
		"select * from d_category";
	//查询出category信息和包含的产品数量
	private static final String FIND_BY_PARENTID = 
		"select * from d_category where parent_id=?";
	private static final String FindBookNumber = 
		"	select count(*)  from d_category_product dcp "+
		" join d_product dp on ( dcp.product_id = dp.id ) "+
		" join d_book db  on ( dp.id = db.id ) "+
		" where dcp.cat_id = ? ";
	private static final String FindNameById ="select name from d_category where id=?";
	@Override
	public List<Category> findAll() throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FIND_ALL);
		ResultSet rs = pst.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while(rs.next()){
			Category cat = new Category();
			cat.setId(rs.getInt("id"));
			cat.setTurn(rs.getInt("turn"));
			cat.setEn_name(rs.getString("en_name"));
			cat.setName(rs.getString("name"));
			cat.setDescription(rs.getString("description"));
			cat.setParent_id(rs.getInt("parent_id"));
			list.add(cat);
		}
	
		return list;
	}
	@Override
	public List<Category> findByParentId(int pid) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FIND_BY_PARENTID);
		pst.setInt(1, pid);
		ResultSet rs = pst.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while(rs.next()){
			Category cat = new Category();
			cat.setId(rs.getInt("id"));
			cat.setTurn(rs.getInt("turn"));
			cat.setEn_name(rs.getString("en_name"));
			cat.setName(rs.getString("name"));
			cat.setDescription(rs.getString("description"));
			cat.setParent_id(rs.getInt("parent_id"));
			list.add(cat);
		}
	
		return list;
	}
	/**
	 	通过d_category_product 中的cat_id 查找对应的书籍数目；
		d_category_product ,d_product,d_book 三表联合查询；
	 */
	@Override
	public int findBookNumber(int catId) throws Exception {
		int bookNumber =  0;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBookNumber);
		pst.setInt(1, catId);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			//取第一行第一列的记录
			bookNumber = rs.getInt(1);
		}
		return bookNumber;
	}
	@Override
	public String findNameById(int pid) throws Exception {
		String name=null;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindNameById);
		pst.setInt(1, pid);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			// 根据ID查找name，知道列上的ID，就可知道对应的name
			name=rs.getString("name");
		}
		return name;
	}

}
