package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.BookDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.util.DBUtil;

public class BookDAOImpl implements BookDAO {

	private Logger log = Logger.getLogger(this.getClass());
	private static final String GetBookByBookId=
		"select *, sum(di.product_num ) num from d_product dp "+
		 "join d_category_product dcp on (dp.id = dcp.product_id)  "+
		"join d_book db on (dp.id = db.id)  "+
		"left outer join d_item di on (dp.id = di.product_id)  "+
		"where db.id = ? and dp.has_deleted=0  group by db.id ";
	private static final String FindBooksIf = 
		"select * from d_category_product dcp " +
		"join d_product dp on (dcp.product_id=dp.id) " +
		"join d_book db on (dp.id=db.id) where dp.has_deleted=0 and dcp.cat_id=? limit ?,? ";
	private static final String FindMaxPage =
		"select count(*) from d_category_product dcp "+
		 "join d_product dp on (dcp.product_id = dp.id )  "+
		 " where dcp.cat_id = ? and dp.has_deleted = 0 ";
	private static final String FindBooksIf_SaleDown=
		"select *, sum(di.product_num ) num from d_product dp "+
		"join d_category_product dcp on (dp.id = dcp.product_id) "+
		"join d_book db on (dp.id = db.id) "+
		"left outer join d_item di on (dp.id = di.product_id) "+
		"where dcp.cat_id = ? and dp.has_deleted=0  "+
		"group by db.id "+
		"order by num desc "+
		"limit ? , ? ";
	private static final String FindBooksIf_SaleUp=
		"select *, sum(di.product_num ) num from d_product dp "+
		"join d_category_product dcp on (dp.id = dcp.product_id) "+
		"join d_book db on (dp.id = db.id) "+
		"left outer join d_item di on (dp.id = di.product_id) "+
		"where dcp.cat_id = ? and dp.has_deleted=0  "+
		"group by db.id "+
		"order by num desc "+
		"limit ? , ? ";
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
	
	/**
	 * 通过book的id找到这本书；
	 */
	@Override
	public Book getBookByBookId(int book_id) throws Exception {
		log.warn("............getBookByBookId(int bookId)...................");
		Book book = null;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(GetBookByBookId);
		log.info(GetBookByBookId);
		pst.setInt(1, book_id);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			book = new Book();
			log.warn("1:  "+book);
			book.setId(rs.getInt("id"));
			log.warn("2");
			book.setProduct_name(rs.getString("product_name"));
			log.warn("3");
			book.setDescription(rs.getString("description"));
			log.warn("4");
			book.setAdd_time(rs.getLong("add_time"));
			log.warn("5");
			book.setFixed_price(rs.getDouble("fixed_price"));
			log.warn("6");
			book.setDang_price(rs.getDouble("dang_price"));
			log.warn("7");
			book.setKeywords(rs.getString("keywords"));
			log.warn("8");
			book.setSaleCount(rs.getInt("num"));
			log.warn("9");
			//book.setHasDeleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			log.warn("10");
			book.setAuthor(rs.getString("author"));
			log.warn("11");
			book.setPublishing(rs.getString("publishing"));
			log.warn("12");
			book.setPublish_time(rs.getLong("publish_time"));
			log.warn("13");
			log.warn("book的出版时间：：：－－－－－"+book.getPublish_time());
			book.setCatalogue(rs.getString("catalogue"));
			log.warn("14");
		}
		return book;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public List<Book> findBooksIf(int id, int page, int size)
			throws Exception {
		log.warn("........findBookIf()...........");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooksIf);
		pst.setInt(1, id);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public int findMaxPage(int id, int size) throws Exception {
		log.warn("........findMaxPage()...........");
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindMaxPage);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		//getInt(int mm)以 Java 编程语言中 int 的形式获取此 ResultSet 对象的当前行中指定列的值。
		//ResultSet返回的是第一列的某些字段，根据某个字段取这一行的数据，这里就是取这一行的记录的总合
		int n =rs.getInt(1);
		log.warn(".............."+n+"..............");
		n = n % size ==0 ? n/size : n/size+1;
		return n;
	}

	@Override
	public List<Book> findBooksIf_TimeUp(int cid, int page, int size)
			throws Exception {
		log.warn("........findBooksIf_TimeUp()...........");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooks_TimeUP);
		pst.setInt(1, cid);
		int begin =(page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<Book> findBooksIf_TimeDown(int cid, int page, int size)
			throws Exception {
		log.warn("........findBooksIf_TimeDown()...........");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooks_TimeDown);
		pst.setInt(1, cid);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<Book> findBooksIf_MoneyDown(int cid, int page, int size)
			throws Exception {
		log.warn(".........findBooksIf_MoneyDown()............");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooksIf_MoneyDown);
		pst.setInt(1, cid);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<Book> findBooksIf_MoneyUp(int cid, int page, int size)
			throws Exception {
		log.warn(".........findBooksIf_MoneyUp()............");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooksIf_MoneyUp);
		pst.setInt(1, cid);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<Book> findBooksIf_SaleDown(int cid, int page, int size)
			throws Exception {
		log.warn(".........findBooksIf_SaleDown()............");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooksIf_SaleDown);
		pst.setInt(1, cid);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

	@Override
	public List<Book> findBooksIf_SaleUp(int cid, int page, int size)
			throws Exception {
		log.warn(".........findBooksIf_SaleUp()............");
		List<Book> booksList = new ArrayList<Book>();
		Book book;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindBooksIf_SaleUp);
		pst.setInt(1, cid);
		int begin = (page-1)*size;
		pst.setInt(2, begin);
		pst.setInt(3, size);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setProduct_name(rs.getString("product_name"));
			book.setDescription(rs.getString("description"));
			book.setAdd_time(rs.getLong("add_time"));
			book.setFixed_price(rs.getDouble("fixed_price"));
			book.setDang_price(rs.getDouble("dang_price"));
			book.setKeywords(rs.getString("keywords"));
			book.setHas_deleted(false);
			book.setProduct_pic(rs.getString("product_pic"));
			book.setAuthor(rs.getString("author"));
			book.setPublishing(rs.getString("publishing"));
			book.setPublish_time(rs.getLong("publish_time"));
			book.setCatalogue(rs.getString("catalogue"));
			booksList.add(book);
		}
		return booksList;
	}

}
