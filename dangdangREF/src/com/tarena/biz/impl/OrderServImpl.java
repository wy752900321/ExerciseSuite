package com.tarena.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.biz.IOrderServ;
import com.tarena.dao.IOrderDao;
import com.tarena.entity.CartItem;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Item;
import com.tarena.entity.exet.Order;
import com.tarena.entity.exet.User;
import com.tarena.factory.ObjectFactory;

public class OrderServImpl implements IOrderServ {
	private IOrderDao iorderDao = (IOrderDao) ObjectFactory
			.createObject("IOrderDao");

	@Override
	public int addOrder(Order order) {

		return iorderDao.addOrder(order);
	}

	// 处理订单信息
	public Order doOrderInfo(Order order, double sumPrice, User user) {

		// 用户id
		order.setUserId(user.getUserId());
		// 订单状态
		order.setStatus(1);
		// 订购时间
		order.setOrderTime(System.currentTimeMillis());
		// 订单描述
		order.setOrderDesc("good");
		//邮编
		order.setPostalCode("713456");
		// 计算总价
		order.setTotalPrice(sumPrice);
		return order;
	}

	@Override
	public int addOrderItem(Item item) {
		return iorderDao.addOrderItem(item);
	}

	// 处理订单项信息
	@Override
	public List<Item> doItemInfo(List<CartItem> cartItems, int orderId) {
		List<Item> items=new ArrayList<Item>();
		for (CartItem cartItem : cartItems) {
			Item item = new Item();
			// 订单号
			item.setOrderId(orderId);
			// 小计
			item.setAmount(cartItem.getBook().getDangPrice()
					* cartItem.getCount());
			// 当当价格
			item.setDangPrice(cartItem.getBook().getDangPrice());
			// 产品id
			item.setProductId(cartItem.getBook().getId());
			// 产品名字
			item.setProductName(cartItem.getBook().getProductName());
			// 产品的数量
			item.setProductNum(cartItem.getCount());
			items.add(item);
		}
		return items;
	}

	@Override
	public List<Book> findBookByCategoryId(Page page) {
		return iorderDao.findBookByCategoryId(page);
	}

}
