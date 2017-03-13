package com.wangxin.service;

import java.util.List;

import com.wangxin.service.impl.CartItem;



public interface CartService {
	/*
	 * 购买商品
	 */
		public boolean addItem(CartItem item);
		//删除商品
		public void delete(int id);
		//修改数量
		public void update(int id,int qty);
		//计算总价
		public double totalPrice();
		//计算节省了多少钱
		public double salesPrice();
		//返回购物车中的所有产品
		public List<CartItem> getItem(boolean buy);
		/*
		 *恢复购物车这中的商品， 实际是修改购物车中buy属性的值为true
		 */
		public void huifu(int id);
		// 清空购物车
		public void clear();
		public String store();
		public void load(String content);
}
