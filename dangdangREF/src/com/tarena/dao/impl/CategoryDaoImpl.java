package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tarena.dao.ICategoryDao;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.entity.exet.Product;
import com.tarena.util.datasource.DBConnection;

public class CategoryDaoImpl implements ICategoryDao {
	private static Log log = LogFactory.getLog(CategoryDaoImpl.class);

	// 获取所有的类别
	@Override
	public List<Category> findAllCategory() {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_category order by turn";
			log.info(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				// 描述
				category.setDescription(rs.getString("description"));
				category.setEnName(rs.getString("en_name"));
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setParentId(rs.getInt("parent_id"));
				category.setTurn(rs.getInt("turn"));
				categorys.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return categorys;
	}

	// 获得一个类别下的产品
	@Override
	public List<Product> findProductByCategoryId(Category category) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = " select * from d_product ,d_category_product where d_product.id=d_category_product.product_id and d_category_product.cat_id=?";
			log.info(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setAddTime(rs.getLong("add_time"));
				product.setFixedPrice(rs.getDouble("fixed_price"));
				product.setDangPrice(rs.getDouble("dang_price"));
				product.setKeywords(rs.getString("keywords"));
				product.setHasDeleted(rs.getInt("has_deleted"));
				product.setProductPic(rs.getString("product_pic"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return products;
	}

	
	@Override
	public Category findCategoryByid(int parentId) {
		Category category = new Category();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_category where id=?";
			log.info(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, parentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return category;
	}

}
