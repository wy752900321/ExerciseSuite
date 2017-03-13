package com.tarena.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Book;
import com.tarena.entity.Product;

public class ProductDAOImpl extends GetConnection implements ProductDAO {
	private static final String FindNewProduct = "select * from d_product where has_deleted = 0  order by add_time desc limit ? , ? ";
	private static final String FindRecommendProduct = 
		     "select * from d_category_product dcp join d_product dp on ( dcp.id=dp.id ) "
			+" join d_book db on ( dp.id = db.id) where dp.has_deleted = 0  " 
			+ "  order by  dp.fixed_price-dp.dang_price desc limit ?, ?";
	private static final String FindHotProduct = "select dp.id,dp.product_name,dp.description, "
			+ " dp.add_time,dp.fixed_price,dp.dang_price , "
			+ " dp.keywords,dp.product_pic,sum(di.product_num) num from d_product dp "
			+ " join d_item di on ( di.product_id = dp.id) "
			+ " join d_book db on (dp.id = db.id) "
			+ " where dp.has_deleted=0 "
			+ " group by dp.id order by num desc limit ?,?";
	private static final String NewHotSaleColumn = "select db.id bookId, dp.product_name , sum(di.product_num) num  from d_product dp "
			+ "join d_item di on ( dp.id = di.product_id ) "
			+ "join d_book db on ( db.id = dp.id ) where dp.has_deleted = 0  and dp.add_time >  ? "
			+ "group by db.id order by num desc limit 0 , ? ";
	private static final String newHotProductAll = "select *, sum(di.product_num) num  from d_product dp "
			+ "join d_item di on ( dp.id = di.product_id ) "
			+ "join d_book db on ( db.id = dp.id ) where dp.has_deleted = 0  and dp.add_time >  ? "
			+ "group by db.id order by num desc limit 0 , ? ";
	private static final String NewProductAll = 
		"  select * from d_product  dp join d_book db on (dp.id=db.id) " +
		"  where dp.has_deleted = 0  order by dp.add_time desc limit ? , ? ";
	private static final String FindProductNumber = 
		"  select count(*) from d_product  dp join d_book db on (dp.id=db.id) " +
		"  where dp.has_deleted = 0  ";
	private static final String findProductById=
		"select * from d_product where id=?";
	
	
	
	
	
	public List<Product> findNewProduct(int size) throws Exception {
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		PreparedStatement prep = getConnection().prepareStatement(
				FindNewProduct);
		prep.setInt(1, 0);
		prep.setInt(2, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProductPic(rs.getString("product_pic"));
			list.add(pro);
		}
		return list;
	}

	public List<Product> newProductAll(int start, int newNum) throws Exception {
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		PreparedStatement prep = getConnection().prepareStatement(
				NewProductAll);
		start = (start - 1) * newNum;
		prep.setInt(1, start);
		prep.setInt(2, newNum);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProductPic(rs.getString("product_pic"));
			list.add(pro);
		}
		return list;
	}
	public int findProductNumber() throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(
				FindProductNumber);
		ResultSet rs = prep.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	public List<Book> findRecommendProduct(int size) throws Exception {
		List<Book> list = new ArrayList<Book>();
		Book book = null;
		PreparedStatement prep = getConnection().prepareStatement(
				FindRecommendProduct);
		prep.setInt(1, 0);
		prep.setInt(2, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			if (rs.getBoolean("has_deleted")) {// 判断该图书是否被删除
				continue;
			}
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			list.add(book);
		}
		return list;
	}

	// 热销图书
	public List<Product> findHotProduct(int start, int number) throws Exception {
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		PreparedStatement prep = getConnection().prepareStatement(
				FindHotProduct);
		start = (start - 1) * number;
		prep.setInt(1, start);
		prep.setInt(2, number);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProductPic(rs.getString("product_pic"));
			pro.setSaleCount(rs.getInt("num"));
			list.add(pro);
		}
		return list;
	}

	public List<String> newHotSaleColumn(int number, int month)
			throws Exception {
		List<String> list = new ArrayList<String>();
		String name;
		Date time = new Date();
		long limitTime = time.getTime() - month * 30 * 24 * 60 * 60 * 1000L;
		// System.out.println(limitTime);
		PreparedStatement prep = getConnection().prepareStatement(
				NewHotSaleColumn);
		prep.setLong(1, limitTime);
		prep.setInt(2, number);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			name = rs.getInt("bookId") + "**" + rs.getString("product_name")
					+ "**" + rs.getInt("num");
			list.add(name);
		}
		return list;

	}

	// 全部新书热销排行榜的图书
	public List<Product> newHotProductAll(int number, int month)
			throws SQLException {
		List<Product> list = new ArrayList<Product>();
		Date time = new Date();
		long limitTime = time.getTime() - month * 30 * 24 * 60 * 60 * 1000L;
		PreparedStatement prep = getConnection().prepareStatement(
				newHotProductAll);
		prep.setLong(1, limitTime);
		prep.setInt(2, number);
		ResultSet rs = prep.executeQuery();
		Product pro;
		while (rs.next()) {
			pro = new Product();
			pro.setId(rs.getInt("id"));
			pro.setProductName(rs.getString("product_name"));
			pro.setDescription(rs.getString("description"));
			pro.setAddTime(rs.getLong("add_time"));
			pro.setFixedPrice(rs.getDouble("fixed_price"));
			pro.setDangPrice(rs.getDouble("dang_price"));
			pro.setKeywords(rs.getString("keywords"));
			pro.setProductPic(rs.getString("product_pic"));
			pro.setSaleCount(rs.getInt("num"));
			list.add(pro);
		}
		return list;
	}
	//通过商品id 找到该商品
	public Product findProductById(int productId) throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(
				findProductById);
		prep.setLong(1, productId);
		ResultSet rs = prep.executeQuery();
		Product pro=null;
		while (rs.next()) {
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

	public static void main(String[] args) throws Exception {
		ProductDAOImpl dao = new ProductDAOImpl();
		// List<Book> list = dao.findRecommendProduct(8);
		// SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		// for(Book p : list){
		// long time= p.getPublishtime();
		// System.out.println(p.getId()+"   " +fmt.format(new Date(time)));
		// }
		List<String> list = dao.newHotSaleColumn(2, 120);
		for (String s : list) {
			System.out.println(s);
		}
	}

	
	

}
