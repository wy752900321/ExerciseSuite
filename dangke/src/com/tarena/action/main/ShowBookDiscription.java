package com.tarena.action.main;

import com.tarena.dao.BookDAO;
import com.tarena.dao.impl.BookDAOImpl;
import com.tarena.entity.Book;

public class ShowBookDiscription {
	private int bookId;
	private Book book;

	public String execute() {
		BookDAO bookdao = new BookDAOImpl();
		try {
			System.out.println("bookID................."+bookId);
			book = bookdao.getBookByBookId(bookId);
			System.out.println(book.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


}
