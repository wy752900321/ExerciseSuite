package com.tarena.service.impl;

import com.tarena.entity.Product;

public class CartItem {
	private Product product;
	private int count;
	private boolean buy;
	public CartItem(){}
	public CartItem(Product product, int count, boolean buy) {
		super();
		this.product = product;
		this.count = count;
		this.buy = buy;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	
}
