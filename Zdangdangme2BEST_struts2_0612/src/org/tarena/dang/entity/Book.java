package org.tarena.dang.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
	DROP TABLE IF EXISTS d_book;
	CREATE TABLE d_book (
	  id int(12) NOT NULL,
	  author varchar(200) NOT NULL,
	  publishing varchar(200) NOT NULL,
	  publish_time bigint(20) NOT NULL,
	  word_number varchar(15) default NULL,
	  which_edtion varchar(15) default NULL,
	  total_page varchar(15) default NULL,
	  print_time bigint(20) default NULL,
	  print_number varchar(15) default NULL,
	  isbn varchar(25) default NULL,
	  author_summary text NOT NULL,
	  catalogue text NOT NULL,
	  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@SuppressWarnings("serial")
public class Book extends Product implements java.io.Serializable{
	private int id;
	private String author;
	private String publishing;
	private Long publish_time;
	private String word_number;
	private String which_edtion;
	private String total_page;
	private long print_time;
	private String print_number;
	private String isbn;
	private String author_summary;
	private String catalogue;
	private long publishTime;
	//追加格式化publsihTime方法
	public String getPublishTimeFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dtime=new Date(publishTime);
		return sdf.format(dtime);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Long getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Long publishTime) {
		publish_time = publishTime;
	}
	public String getWord_number() {
		return word_number;
	}
	public void setWord_number(String wordNumber) {
		word_number = wordNumber;
	}
	public String getWhich_edtion() {
		return which_edtion;
	}
	public void setWhich_edtion(String whichEdtion) {
		which_edtion = whichEdtion;
	}
	public String getTotal_page() {
		return total_page;
	}
	public void setTotal_page(String totalPage) {
		total_page = totalPage;
	}
	public long getPrint_time() {
		return print_time;
	}
	public void setPrint_time(long printTime) {
		print_time = printTime;
	}
	public String getPrint_number() {
		return print_number;
	}
	public void setPrint_number(String printNumber) {
		print_number = printNumber;
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
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	
}
