package org.tarena.dang.service;

import org.tarena.dang.entity.Product;

/**
 * 封装购买的产品信息
 * 根据购物车列表信息定义
 * @author soft01
 */
public class CartItem {
	private Product pro;//商品
	private int qty;//购买数量
	private boolean buy = false;//是否购买
	
	public CartItem() {
		super();
	}
	public CartItem(Product pro, int qty, boolean buy) {
		super();
		this.pro = pro;
		this.qty = qty;
		this.buy = buy;
	}
	public Product getPro(){
		return pro;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pro == null) ? 0 : pro.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (pro == null) {
			if (other.pro != null)
				return false;
		} else if (!pro.equals(other.pro))
			return false;
		return true;
	}
	
}
