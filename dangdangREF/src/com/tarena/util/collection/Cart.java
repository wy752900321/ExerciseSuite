package com.tarena.util.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarena.entity.CartItem;
import com.tarena.entity.exet.Book;

// 购物篮
public class Cart {

	// 创建购物篮
	Map<Integer, CartItem> cart = new HashMap<Integer, CartItem>();

	// 向购物篮中放入商品
	public void addBook(int bookId, Book book) {
		// 判断购物篮中是否有商品
		CartItem cartItem = cart.get(bookId);
		if (cartItem == null) {// 购物篮中没有商品
			cart.put(bookId, new CartItem(book, 1));
			//cart.get(bookId).setFlag(false);
		} else {// 购物篮中有商品
			if(cartItem.isFlag()==true){
				cart.put(bookId, new CartItem(book, 1));
			}else{
			cartItem.setCount(cartItem.getCount() + 1);
			}
			//cart.get(bookId).setFlag(false);
		}
	}

	// 获取购物篮中的商品
	public List<CartItem> findAllCartItem() {
		return new ArrayList<CartItem>(cart.values());
	}

	// 删除商品
	public void deleteCartItemById(int bookId) {
		cart.get(bookId).setFlag(true);
	}

	// 恢复
	public void recover(int bookId) {
		cart.get(bookId).setFlag(false);
	}

	// 修改商品的数量
	public void updateCartItemCount(int bookId, int updateCount) {
		CartItem cartItem = cart.get(bookId);
		cartItem.setCount(updateCount);
	}

	// 计算总价
	public double sumPrice() {
		double sum = 0;
		List<CartItem> cartItems = new ArrayList<CartItem>(cart.values());
		for (CartItem cartItem : cartItems) {
			if(cartItem.getCount()>0){
				if (cartItem.isFlag() == false) {
					sum += cartItem.getBook().getDangPrice() * cartItem.getCount();
				}
			}else{
		    sum=0;
			}
		}
		return sum;
	}

	// 计算差价
	public double save(){
		double sum = 0;
		List<CartItem> cartItems = new ArrayList<CartItem>(cart.values());
		for (CartItem cartItem : cartItems) {
			if(cartItem.getCount()>0){
				if (cartItem.isFlag() == false) {
					sum += cartItem.getBook().getSavePrice()* cartItem.getCount();
				}
			}else{
				sum=0;
			}
		}
		return sum;
	}
	// 清空购物篮
	public void clear() {
		cart.clear();
	}

}
