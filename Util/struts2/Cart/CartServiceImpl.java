package com.wangxin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wangxin.service.CartService;

public class CartServiceImpl implements CartService{
	List<CartItem> items = new ArrayList<CartItem>();
	public CartServiceImpl(){}
	public static CartService getCart(Map<String,Object> session){
		CartService cart = (CartService)session.get("cart");
		if(cart==null){
			cart = new CartServiceImpl();
			session.put("cart", cart);
		}
			return cart;
	}
	/*
	 * 购买商品添加到购物车中，如果购买过，则返回false提示用户不能重复购买
	 */
	public boolean addItem(CartItem item) {
		for(int i=0;i<items.size();i++){
			if(items.get(i).getPro().getId() == item.getPro().getId()){
				return false;
			}
		}
		items.add(item);
		return true;
	}
	/*
	 * 删除购物车中的商品，实际是修改购物车中buy属性的值为false，默认为true
	 */
	public void delete(int id) {
		for(int i=0;i<items.size();i++){
			if(items.get(i).getPro().getId() == id){
				items.get(i).setBuy(false);
				return;
			}
		}
	}
	/*
	 *恢复购物车这中的商品， 实际是修改购物车中buy属性的值为true
	 */
	public void huifu(int id) {
		for(int i=0;i<items.size();i++){
			if(items.get(i).getPro().getId() == id){
				items.get(i).setBuy(true);
				return;
			}
		}
	}
	
	/*
	 * 根据传递的参数返回购物车中的产品，
	 * buy=true,返回的是购买的物品
	 * buy=false,返回的是删除过的产品
	 */
	public List<CartItem> getItem(boolean buy) {
		List<CartItem> list = new ArrayList<CartItem>();
		for(int i=0;i<items.size();i++){
			if(items.get(i).isBuy() == buy){
				list.add(items.get(i));
			}
		}
		return list;
	}
	/*
	 * 计算总共节省了多少钱，（当当价减去定价）* 数量
	 */
	public double salesPrice() {
		double sales = 0.0;
		for(int i=0;i<items.size();i++){
			CartItem ci = items.get(i);
			if(ci.isBuy()==true){
				sales += (ci.getPro().getFixedPrice() - ci.getPro().getDangPrice()) * ci.getQty();
			}
		}
		return sales;
	}
	//要支付的总价
	public double totalPrice() {
		double total = 0.0;
		for(int i=0;i<items.size();i++){
			CartItem ci = items.get(i);
			if(ci.isBuy()==true){
				total += ci.getPro().getDangPrice() * ci.getQty();
			}
		}
		return total;
	}
	/*
	 * 修改购物车中购买的商品的数量
	 */
	public void update(int id, int qty) {
		for(int i=0;i<items.size();i++){
			if(items.get(i).getPro().getId() == id){
				items.get(i).setQty(qty);
				return;
			}
		}
		
	}
	/*
	 * 清空购物车
	 */
	public void clear(){
		items.clear();
	}
}
