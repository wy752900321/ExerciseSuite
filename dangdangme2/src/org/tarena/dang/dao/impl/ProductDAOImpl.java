package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
	private static final String FindRecommendProduct=
		"select * from d_category_product dcp join d_product dp on ( dcp.id=dp.id ) "
		+" join d_book db on ( dp.id = db.id) where dp.has_deleted = 0  " 
		+ "  order by  dp.fixed_price-dp.dang_price desc limit ?, ?";
	
	private static final String FindHotProduct = 
		"select dp.id,dp.product_name,dp.description, "
		+ " dp.add_time,dp.fixed_price,dp.dang_price , "
		+ " dp.keywords,dp.product_pic,sum(di.product_num) num from d_product dp "
		+ " join d_item di on ( di.product_id = dp.id) "
		+ " join d_book db on (dp.id = db.id) "
		+ " where dp.has_deleted=0 "
		+ " group by dp.id order by num desc limit ?,?";
	private static final String NewProductAll=
		"select * from d_product dp join d_book db on(dp.id=db.id) " +
		" where dp.has_deleted=0 order by dp.add_time desc limit ?,?";
	private static final String FindProductNumber=
		"select count(*) from d_product dp join d_book db on (dp.id=db.id) " +
		"where dp.has_deleted=0";
	private static final String newHotProductAll=
		"select *, sum(di.product_num) num  from d_product dp "
		+ "join d_item di on ( dp.id = di.product_id ) "
		+ "join d_book db on ( db.id = dp.id ) where dp.has_deleted = 0  and dp.add_time >  ? "
		+ "group by db.id order by num desc limit 0 , ? ";
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

		return list;
	}
	@Override
	public List<Book> findRecommendProduct(int number) throws Exception {
		List<Book> list = new ArrayList<Book>();
		Book book = null;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindRecommendProduct);
		pst.setInt(1, 0);
		pst.setInt(2, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			if(rs.getBoolean("has_deleted")){// 判断该图书是否被删除
				continue;
			}
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			list.add(book);
		}
		return list;
	}
	// 热销图书
	@Override
	public List<Product> findHotProduct(int start, int number) throws Exception {
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindHotProduct);
		start = (start - 1) * number;
		pst.setInt(1, start);
		pst.setInt(2, number);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProduct_name(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAdd_time(rs.getLong("add_time"));
			pro.setFixed_price(rs.getDouble("fixed_price"));
			pro.setDang_price(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProduct_pic(rs.getString("product_pic"));
			pro.setSaleCount(rs.getInt("num"));
			list.add(pro);
		}
		return list;
	}
	@Override
	public List<Product> newProductAll(int start, int newNum) throws Exception {
		List<Product> list =new ArrayList<Product>();
		Product pro = null;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(NewProductAll);
		start = (start-1)*newNum;
		pst.setInt(1, start);	
		pst.setInt(2, newNum);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProduct_name(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAdd_time(rs.getLong("add_time"));
			pro.setFixed_price(rs.getDouble("fixed_price"));
			pro.setDang_price(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProduct_pic(rs.getString("product_pic"));
			list.add(pro);
		}
		return list;
	}
	@Override
	public int findProductNumber() throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindProductNumber);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	// 全部新书热销排行榜的图书
	@Override
	public List<Product> newHotProductAll(int number, int month)
			throws Exception {
		List<Product> list = new ArrayList<Product>();
		Date time = new Date();
		long limitTime = time.getTime()-month*30*24*60*60*1000L;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(newHotProductAll);
		pst.setLong(1,limitTime);
		pst.setInt(2, number);
		ResultSet rs = pst.executeQuery();
		Product pro ;
		while(rs.next()){
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProduct_name(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAdd_time(rs.getLong("add_time"));
			pro.setFixed_price(rs.getDouble("fixed_price"));
			pro.setDang_price(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProduct_pic(rs.getString("product_pic"));
			pro.setSaleCount(rs.getInt("num"));
			list.add(pro);
		}
		return list;
	}

}
