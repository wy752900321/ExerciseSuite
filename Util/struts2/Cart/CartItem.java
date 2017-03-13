package com.wangxin.service.impl;

import com.wangxin.entity.Product;

public class CartItem {
		private Product pro;//购买商品
		private int qty;//购买数量
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		private boolean buy = true;//是否删除
		public Product getPro() {
			return pro;
		}
		public void setPro(Product pro) {
			this.pro = pro;
		}
		
		public boolean isBuy() {
			return buy;
		}
		public void setBuy(boolean buy) {
			this.buy = buy;
		}
		
}
