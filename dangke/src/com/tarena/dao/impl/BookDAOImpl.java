package com.tarena.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;

public class BookDAOImpl extends GetConnection implements BookDAO {
	private static final String FindBooksIf = 
		      "select * from d_category_product  dcp "
			+ " join d_product dp on ( dcp.product_id = dp.id ) "
			+ " join d_book db on (dp.id = db.id ) where dp.has_deleted = 0 and dcp.cat_id = ? limit ? ,? ";
	private static final String FindMaxPage =
		"select count(*) from d_category_product dcp "+
		 "join d_product dp on (dcp.product_id = dp.id )  "+
		 " where dcp.cat_id = ? and dp.has_deleted = 0 ";
	private static final String GetBookByBookId = 
		"select *, sum(di.product_num ) num from d_product dp "+
		 "join d_category_product dcp on (dp.id = dcp.product_id)  "+
		"join d_book db on (dp.id = db.id)  "+
		"left outer join d_item di on (dp.id = di.product_id)  "+
		"where db.id = ? and dp.has_deleted=0  group by db.id ";
	private static final String  FindBooks_TimeUP=
		"select *, sum(di.product_num ) num from d_product dp "+
		"join d_category_product dcp on (dp.id = dcp.product_id)  "+
		"join d_book db on (dp.id = db.id)  "+
		"left outer join d_item di on (dp.id = di.product_id)  "+
		"where dcp.cat_id = ? and dp.has_deleted=0 "+
		"group by db.id "+
		"order by dp.add_time "+
		"limit ?,? ";

	private static final String FindBooks_TimeDown =
		"select *, sum(di.product_num ) num from d_product dp "+
		"join d_category_product dcp on (dp.id = dcp.product_id) "+
		"join d_book db on (dp.id = db.id) "+
		"left outer join d_item di on (dp.id = di.product_id) "+
		"where dcp.cat_id = ? and dp.has_deleted=0  "+
		"group by db.id "+
		"order by dp.add_time  desc "+
		"limit ? , ? ";
	private static final String FindBooksIf_SaleCount=
		"select *, sum(di.product_num ) num from d_product dp "+
		"join d_category_product dcp on (dp.id = dcp.product_id) "+
		"join d_book db on (dp.id = db.id) "+
		"left outer join d_item di on (dp.id = di.product_id) "+
		"where dcp.cat_id = ? and dp.has_deleted=0  "+
		"group by db.id "+
		"order by num desc "+
		"limit ? , ? ";
	private static final String FindBooksIf_MoneyUp=
	"	select * from d_product dp "+
	"	join d_category_product dcp on (dcp.product_id = dp.id) "+
	"	join d_book db on (dp.id=db.id) where dcp.cat_id = ? and dp.has_deleted = 0 "+
	"	order by dp.dang_price limit ?,? ";
	private static final String FindBooksIf_MoneyDown=
		"	select * from d_product dp "+
		"	join d_category_product dcp on (dcp.product_id = dp.id) "+
		"	join d_book db on (dp.id=db.id) where dcp.cat_id = ? and dp.has_deleted = 0 "+
		"	order by dp.dang_price desc limit ?,? ";
	public List<Book> findBooksIf(Integer id, int page, int size)
			throws Exception {
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooksIf);
		prep.setInt(1, id);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			// System.out.println("book的出版时间：：：－－－－－"+book.getPublishtime());
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	public int findMaxPage(Integer id, int size) throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(FindMaxPage);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		rs.next();
		int n = rs.getInt(1);
		n = n % size == 0 ? n / size : n / size + 1;
		return n;
	}

	/**
	 * 通过book的id找到这本书；
	 */
	public Book getBookByBookId(int bookId) throws Exception {
		System.out.println("getBookByBookId");
		Book book = null;
		PreparedStatement prep = getConnection().prepareStatement(
				GetBookByBookId);
		prep.setInt(1, bookId);
		ResultSet rs = prep.executeQuery();
		if(rs.next()) {
			book = new Book();
			System.out.println(1);
			book.setId(rs.getInt("id"));
			System.out.println(2);
			book.setProductName(rs.getString("product_name"));
			System.out.println(3);
			book.setDescription(rs.getString("description"));
			System.out.println(4);
			book.setAddTime(rs.getLong("add_time"));
			System.out.println(5);
			book.setFixedPrice(rs.getDouble("fixed_price"));
			System.out.println(6);
			book.setDangPrice(rs.getDouble("dang_price"));
			System.out.println(7);
			book.setKeywords(rs.getString("keywords"));
			System.out.println(8);
			book.setSaleCount(rs.getInt("num"));
			System.out.println(9);
			//book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			System.out.println(10);
			book.setAuthor(rs.getString("author"));
			System.out.println(11);
			book.setPublishing(rs.getString("publishing"));
			System.out.println(12);
			book.setPublishtime(rs.getLong("publish_time"));
			System.out.println(13);
			// System.out.println("book的出版时间：：：－－－－－"+book.getPublishtime());
			book.setCatalogue(rs.getString("catalogue"));
		}
		return book;
	}

	public List<Book> findBooksIf_TimeUp(Integer cid, int page, int size)
			throws Exception {
		System.out.println("timeUp");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooks_TimeUP);
		prep.setInt(1, cid);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			// System.out.println("book的出版时间：：：－－－－－"+book.getPublishtime());
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	public List<Book> findBooksIf_TimeDown(Integer cid, int page, int size)
	throws Exception {
		System.out.println("timeDown");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooks_TimeDown);
		prep.setInt(1, cid);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			// System.out.println("book的出版时间：：：－－－－－"+book.getPublishtime());
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
    }  
	
	public List<Book> findBooksIf_SaleDown(Integer cid, int page, int size)
	throws Exception {
		System.out.println("SaleCount");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooksIf_SaleCount);
		prep.setInt(1, cid);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setSaleCount(rs.getInt("num"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			// System.out.println("book的出版时间：：：－－－－－"+book.getPublishtime());
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		//for(Book b: booksList){
		///	System.out.println(b.toString());
		//}
		return booksList;
	}


	public List<Book> findBooksIf_MoneyDown(int cid, int page, int size)
			throws Exception {
		System.out.println("MoneyDown");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooksIf_MoneyDown);
		prep.setInt(1, cid);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	public List<Book> findBooksIf_MoneyUp(int cid, int page, int size)
			throws Exception {
		System.out.println("MoneyUp");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement prep = getConnection().prepareStatement(FindBooksIf_MoneyUp);
		prep.setInt(1, cid);
		int begin = (page - 1) * size;
		prep.setInt(2, begin);
		prep.setInt(3, size);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProductName(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAddTime(rs.getLong("add_time"));
			book.setFixedPrice(rs.getDouble("fixed_price"));
			book.setDangPrice(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHasDeleted(false);
			book.setProductPic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublishtime(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}


	
	public static void main(String[] args) throws Exception {
		BookDAO dao = new BookDAOImpl();
		List<Book> list = dao.findBooksIf(1, 1, 5);
		for (Book p : list) {
			System.out.println(p.getId() + "   " + p.getProductPic());
		}
	}

}
