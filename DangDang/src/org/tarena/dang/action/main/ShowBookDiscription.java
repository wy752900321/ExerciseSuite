package org.tarena.dang.action.main;

import javax.jms.Session;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.BookDAO;
import org.tarena.dang.dao.impl.BookDAOImpl;
import org.tarena.dang.entity.Book;

public class ShowBookDiscription extends BaseAction{
	private Logger log=Logger.getLogger(this.getClass());
	private int book_id;
	private Book book;
	
	public String execute() throws Exception{
		log.warn("...................ShowBookDiscription.................");
		BookDAO bookDao = new BookDAOImpl();
		book = bookDao.getBookByBookId(book_id);
		log.warn(".......book的值：............"+book+".................");
		session.put("book", book);
		return "success";
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int bookId) {
		book_id = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
