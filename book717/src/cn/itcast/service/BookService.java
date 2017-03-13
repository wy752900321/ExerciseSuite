package cn.itcast.service;

import java.sql.Connection;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.factory.DaoFactory;
import cn.itcast.util.JdbcUtils;

public class BookService {
	private BookDao bookDao =DaoFactory.getBookDao();

	public void saveBook(Book book) {
		Connection conn = null;
		try{
			//获取连接
			conn = JdbcUtils.getConnection();
			bookDao.saveBook(conn, book);
			bookDao.saveBook(conn, book);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
	}
}
