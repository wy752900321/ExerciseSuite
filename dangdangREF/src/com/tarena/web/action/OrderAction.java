package com.tarena.web.action;

import java.util.List;

import com.tarena.biz.IOrderServ;
import com.tarena.entity.CartItem;
import com.tarena.entity.exet.Item;
import com.tarena.entity.exet.Order;
import com.tarena.entity.exet.User;
import com.tarena.factory.ObjectFactory;
import com.tarena.util.collection.Cart;

public class OrderAction extends BaseAction {
	private Order order;

	private IOrderServ iorderServ = (IOrderServ) ObjectFactory
			.createObject("IOrderServ");

	// 跳到填写订单信息页面
	public String toAddress() {
		return "address_form";
	}

	// 接收填写订单信息
	@SuppressWarnings("unchecked")
	public String doAddress() {
		User user = (User) session.get("user");
		// 总价
		double sumPrice = (Double) session.get("sumPrice");
		// 产品信息
		List<CartItem> cartItems = (List<CartItem>) session.get("cartItems");
		// 处理Order信息
		order = iorderServ.doOrderInfo(this.order, sumPrice, user);
		// 插入订单信息，并生成订单号
		int orderId = iorderServ.addOrder(order);
		session.put("orderId", orderId);
		// 处理item信息
		List<Item> item = iorderServ.doItemInfo(cartItems, orderId);
		for (Item item2 : item) {
			// 插入订单项
			iorderServ.addOrderItem(item2);
		}
		Cart cart =(Cart)this.session.get("cart");
		cart.clear();
		return "order_ok";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
