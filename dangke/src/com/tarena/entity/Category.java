package com.tarena.entity;

import java.util.List;

public class Category {
	private int id;
	private String enName;
	private String name;
	private int turn;
	private String discription;
	private int parentId;
	//当前书籍类型中存放的数据数目
	private int bookNum;
	//用于存放当前书集类型的子项；
	private List<Category>subCats;
	
	
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<Category> getSubCats() {
		return subCats;
	}
	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}
	
}
