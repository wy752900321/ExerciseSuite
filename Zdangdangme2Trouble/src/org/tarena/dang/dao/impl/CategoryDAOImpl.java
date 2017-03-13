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
	//TODO 查询出category信息和包含的产品数量
	private static final String FIND_BY_PARENTID = 
		"select * from d_category where parent_id=?";
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
		DBUtil.closeConnection();
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
		DBUtil.closeConnection();
		return list;
	}

}
