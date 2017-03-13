package cn.itcast.dao;

import java.sql.Connection;
import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.util.QueryResult;

public interface BookDao {
	void saveBook(Connection conn, Book book);

	List<Book> findAllBooks(Connection conn);
	/**
	 * 通过图书id获取 图书信息
	 * @param conn
	 * @param id
	 * @return
	 */
	Book findBookById(Connection conn,String id);
	/**
	 * 修改图书信息
	 * @param conn
	 * @param book
	 */
	void updateBook(Connection conn,Book book);
	
	/**
	 * 能过id删除图书信息
	 * @param conn
	 * @param id
	 */
	void deleteBookById(Connection conn,String id);
	
	/**
	 * 	该方法执行待分页的查询
	 * @param conn
	 * @param beginIndex
	 * @param maxSize
	 * @param category_id
	 * @return
	 */
	QueryResult<Book> findPageBooksByCondition(Connection conn,
			Integer beginIndex,Integer maxSize,String category_id);
	
}
