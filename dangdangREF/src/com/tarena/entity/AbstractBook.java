package com.tarena.entity;

import java.io.Serializable;
import java.sql.Date;

import com.tarena.entity.exet.Product;

public abstract class AbstractBook extends Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//
	private String author;// 书籍作者
	private String publishing;// 地球出版社
	private Long publishTime;// 出版时间
	private String wordNumber;// 字数
	private String whichEdtion;// 版次
	private String totalPage;// 总页数
	private Long printTime;// 印刷时间
	private String printNumber;// 印次
	private String isbn;// 书籍编号
	private String author_summary;// 作者简介
	private String catalogue;// 目录


	public AbstractBook() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
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

	public Long getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Long printTime) {
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

	public String getAuthor_summary() {
		return author_summary;
	}

	public void setAuthor_summary(String authorSummary) {
		author_summary = authorSummary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

}
