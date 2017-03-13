package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {

	private static final String FIND_NEW_PRODUCT=
		"select * from d_product " +
		"where has_deleted=0 " +
		"order by add_time desc " +
		"limit ?";
	private static final String FIND_BOOK_BY_CATID=
		"select dp.*,db.* " +
		"from d_category_product dcp " +
		"		join d_product dp on(dcp.product_id=dp.id) " +
		"		join d_book db on(dp.id=db.id) " +
		"where dcp.cat_id=? ";
	@Override
	public List<Product> findNewProduct(int size) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FIND_NEW_PRODUCT);
		pst.setInt(1, size);
		ResultSet rs = pst.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while(rs.next()){
			Product pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProduct_name(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAdd_time(rs.getLong("add_time"));
			pro.setFixed_price(rs.getDouble("fixed_price"));
			pro.setDang_price(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setHas_deleted(rs.getBoolean("has_deleted"));
			pro.setProduct_pic(rs.getString("product_pic"));
			list.add(pro);
		}
		DBUtil.closeConnection();
		return list;
	}
	@Override
	public List<Product> findBookByCatId(int catId) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FIND_BOOK_BY_CATID);
		pst.setInt(1, catId);
		ResultSet rs = pst.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while(rs.next()){
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(rs.getBoolean("has_deleted"));
			book.setProduct_pic(rs.getString("product_pic"));
			// 设置其他属性
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setWord_number(rs.getString("word_number"));
			book.setWhich_edtion(rs.getString("which_edtion"));
			book.setTotal_page(rs.getString("total_page"));
			book.setPrint_time(rs.getLong("print_time"));
			book.setPrint_number(rs.getString("print_number"));
			book.setIsbn(rs.getString("isbn"));
			book.setAuthor_summary(rs.getString("author_summary"));
			book.setCatalogue(rs.getString("catalogue"));
			list.add(book);
		}
		DBUtil.closeConnection();
		return list;
	}

}
