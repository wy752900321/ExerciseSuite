package com.tarena.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * d_product
 * @author soft01
 *
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 8450949005674403649L;

	// property
	private int id;
	private String productName;
	private String description;
	private long addTime;
	private double fixedPrice;
	private double dangPrice;
	private String keywords;
	private boolean hasDeleted;
	private String productPic;
	@SuppressWarnings("unused")
	//追加属性用于格式化输出addTime
	private Date addDate;

	// default constructor
	public Product() {
	}
	
	// getter and setter
	public Product(int id) {
		this.id=id;
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
	
	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "Product [addTime=" + addTime + ", dangPrice=" + dangPrice
				+ ", description=" + description + ", fixedPrice=" + fixedPrice
				+ ", hasDeleted=" + hasDeleted + ", id=" + id + ", keywords="
				+ keywords + ", productName=" + productName + ", productPic="
				+ productPic + "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Product) {
			Product product = (Product) obj;
			return product.id == this.id;
		} else {
			return false;
		}
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getAddDate() {
		return new Date(addTime);
	}
	
}
