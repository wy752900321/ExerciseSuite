package com.tarena.biz;

import java.util.List;

import com.tarena.entity.CartItem;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Item;
import com.tarena.entity.exet.Order;
import com.tarena.entity.exet.User;

public interface IOrderServ {

	//插入订单信息
	int addOrder(Order order);
	//插入订单项
	int addOrderItem(Item item);
	//处理订单信息
	 Order doOrderInfo(Order order, double sumPrice, User user);
	 //处理订单项信息
	 List<Item> doItemInfo(List<CartItem> cartItems,int orderId);
		List<Book> findBookByCategoryId(Page page);
}
