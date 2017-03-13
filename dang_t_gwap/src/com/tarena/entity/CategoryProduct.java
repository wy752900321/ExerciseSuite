package com.tarena.entity;

import java.io.Serializable;

/**
 * d_category_product
 * 
 * @author soft01
 * 
 */
public class CategoryProduct implements Serializable {
	private static final long serialVersionUID = -7222665240697794532L;

	// property
	private int id;
	private int productId;
	private int catId;

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "CategoryProduct [catId=" + catId + ", id=" + id
				+ ", productId=" + productId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof CategoryProduct) {
			CategoryProduct categoryProduct = (CategoryProduct) obj;
			return categoryProduct.id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}
