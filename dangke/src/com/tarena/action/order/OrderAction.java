package com.tarena.action.order;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.OrderDAO;
import com.tarena.dao.impl.OrderDAOImpl;
import com.tarena.entity.Order;
import com.tarena.entity.User;

public class OrderAction extends BaseAction {
	private List<Order> orderList;
	private String order;
	private int addressId;

	// 根据下拉列表获取收货人的地址信息
	public String getNewOrder() {
		try {
			System.out.println("getNewOrder......................" + addressId);
			OrderDAO orderDao = new OrderDAOImpl();
			order = orderDao.findOrderByOrderId(addressId);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	// 根据用户的id 获取到用户订单的下拉列表
	public String findOrderByUserId() {
		try {
			OrderDAO orderDao = new OrderDAOImpl();
			User user = (User) session.get("user");
			orderList = orderDao.findOrderByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
