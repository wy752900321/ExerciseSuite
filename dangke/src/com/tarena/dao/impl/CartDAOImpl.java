package com.tarena.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tarena.dao.CartDAO;
import com.tarena.entity.Product;

public class CartDAOImpl extends GetConnection  implements CartDAO {
	private static final String FindProductById = "select * from d_product where id= ?";
	public Product findProductById(int pid) throws Exception {
		Product pro =null;
		PreparedStatement prep = getConnection().prepareStatement(FindProductById);
		prep.setInt(1, pid);
		ResultSet rs = prep.executeQuery();
		while(rs.next()){
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProductPic(rs.getString("product_pic"));
		}
		return pro;
	}

}
