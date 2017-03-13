package com.tarena.entity;

public class Product {
	private int id;
	private String productName;
	private String description;
	private long addTime;
	private double fixedPrice;
	private double dangPrice;
	private String productPic;
	private String keywords;
	private boolean hasDeleted;
	private int saleCount;//销量
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAddTime() {
		return addTime;
	}
	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public boolean isHasDeleted() {
		return hasDeleted;
	}
	public void setHasDeleted(boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}
	
}
