package com.tarena.entity;

import java.io.Serializable;
/**
 * d_item
 * @author soft01
 *
 */
public class Item implements Serializable {
	private static final long serialVersionUID = 3757308244051278200L;

	// property
	private int id;
	private int orderId;
	private int productId;
	private String productName;
	private double dangPrice;
	private int productNum;
	private double amount;

	// default constructor
	public Item() {
	}
	
	// all args constructor
	public Item(int orderId, int productId, String productName,
			double dangPrice, int productNum, double amount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.dangPrice = dangPrice;
		this.productNum = productNum;
		this.amount = amount;
	}

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "Item [amount=" + amount + ", dangPrice=" + dangPrice + ", id="
				+ id + ", orderId=" + orderId + ", productId=" + productId
				+ ", productName=" + productName + ", productNum=" + productNum
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Item) {
			Item item = (Item) obj;
			return item.id == this.id;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
