package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.tarena.dang.dao.CartDAO;
import org.tarena.dang.entity.Product;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.util.DBUtil;

public class CartDAOImpl implements CartDAO {

	private static final String FIND_BY_PID = 
		"select * from d_book,d_product " +
		"where d_book.id=d_product.id " +
		"and d_product.id=?;";

	@Override
	public Product findProductByPid(int pid) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FIND_BY_PID);
		pst.setLong(1, pid);
		ResultSet rs = pst.executeQuery();
		Product pro = null;
		while(rs.next()){
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProduct_name(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAdd_time(rs.getLong("add_time"));
			pro.setFixed_price(rs.getDouble("fixed_price"));
			pro.setDang_price(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setHas_deleted(rs.getBoolean("has_deleted"));
			pro.setProduct_pic(rs.getString("product_pic"));
		}
		return pro;
	}

}
