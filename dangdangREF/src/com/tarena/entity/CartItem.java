package com.tarena.entity;

import java.io.Serializable;

import com.tarena.entity.exet.Book;

public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public CartItem() {
	}

	private Book book;
	private int count;
	private boolean flag = false;

	public CartItem(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
