package com.tarena.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * d_book
 * 
 * @author soft01
 * 
 */
public class Book extends Product implements Serializable {
	private static final long serialVersionUID = 3146272147600007603L;

	// 属性
	private int id;
	private String author;
	private String publishing;
	private long publishTime;
	private String wordNumber;
	private String whichEdtion;
	private String totalPage;
	private int printTime;
	private String printNumber;
	private String isbn;
	private String authorSummary;
	private String catalogue;
	// 追加属性用于格式化publishTime
	private String publishDate;
	private int bookNum;

	// 无参数构造器
	public Book() {
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// d_book表属性定义
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}

	public String getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	public String getWhichEdtion() {
		return whichEdtion;
	}

	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public int getPrintTime() {
		return printTime;
	}

	public void setPrintTime(int printTime) {
		this.printTime = printTime;
	}

	public String getPrintNumber() {
		return printNumber;
	}

	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorSummary() {
		return authorSummary;
	}

	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "Book [author=" + author + ", authorSummary=" + authorSummary
				+ ", catalogue=" + catalogue + ", id=" + id + ", isbn=" + isbn
				+ ", printNumber=" + printNumber + ", printTime=" + printTime
				+ ", publishTime=" + publishTime + ", publishing=" + publishing
				+ ", totalPage=" + totalPage + ", whichEdtion=" + whichEdtion
				+ ", wordNumber=" + wordNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Book) {
			Book book = (Book) obj;
			return book.id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	public String getPublishDate() {
		publishDate = new SimpleDateFormat("yyyy-MM-dd").format(printTime);
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public int getBookNum() {
		return bookNum;
	}

}
