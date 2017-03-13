package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tarena.dao.IBookDao;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.util.datasource.DBConnection;

public class BookDaoImpl implements IBookDao{
private static Log log=LogFactory.getLog(BookDaoImpl.class);
	@Override
	public List<Book> findBookByCategoryId(int categoryId,Page page,String sort) {
		List<Book> books=new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = " select * from d_product ,d_category_product ,d_book where d_product.id=d_category_product.product_id and d_book.id=d_category_product.product_id and d_category_product.cat_id=?";
			//排序
			sql+=" order by "+sort;
			//分页
			sql+=" limit "+page.getBegin()+","+page.getPageSize();
			log.info(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			while(rs.next()){
				Book	book=new Book();
				book.setId(rs.getInt("id"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(rs.getLong("publish_time"));
				book.setWordNumber(rs.getString("word_number"));
				book.setWhichEdtion(rs.getString("which_edtion"));
				book.setTotalPage(rs.getString("total_page"));
				book.setPrintTime(rs.getLong("print_time"));
				book.setPrintNumber(rs.getString("print_number"));
				book.setIsbn(rs.getString("isbn"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setSavePrice(rs.getDouble("fixed_price")-rs.getDouble("dang_price"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(rs.getLong("add_time"));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setKeywords(rs.getString("keywords"));
				book.setHasDeleted(rs.getInt("has_deleted"));
				book.setProductPic(rs.getString("product_pic"));
				books.add(book);
			}
			page.setSumItem(sumCount(categoryId));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return books;
	}
	// 获取数据库中的总条数
	private int sumCount(int categoryId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(*) from d_product ,d_category_product ,d_book where d_product.id=d_category_product.product_id and d_book.id=d_category_product.product_id and d_category_product.cat_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return result;
	}
	@Override
	public Book findBookById(int id) {
		Book book=new Book();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=DBConnection.getConnection();
			String sql="select * from d_book, d_product where d_book.id=d_product.id and d_book.id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				book.setId(rs.getInt("id"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(rs.getLong("publish_time"));
				book.setWordNumber(rs.getString("word_number"));
				book.setWhichEdtion(rs.getString("which_edtion"));
				book.setTotalPage(rs.getString("total_page"));
				book.setPrintTime(rs.getLong("print_time"));
				book.setPrintNumber(rs.getString("print_number"));
				book.setIsbn(rs.getString("isbn"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setSavePrice(rs.getDouble("fixed_price")-rs.getDouble("dang_price"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(rs.getLong("add_time"));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setKeywords(rs.getString("keywords"));
				book.setHasDeleted(rs.getInt("has_deleted"));
				book.setProductPic(rs.getString("product_pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, ps, conn);
		}
		return book;
	}
	
	/**
	 * 根据Book查询类别
	 */
	@Override
	public List<Category> findCategoryByBookId(Book book) {
		List<Category> cates = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_category,d_category_product where d_category.id = d_category_product.cat_id and d_category_product.product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getId());
			rs = ps.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setName(rs.getString("name"));
				category.setId(rs.getInt("id"));
				category.setParentId(rs.getInt("parent_id"));
				cates.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		
		return cates;
	}
	
}
