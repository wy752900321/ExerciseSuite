package com.tarena.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarena.dao.OrderDAO;
import com.tarena.entity.OrderListLine;

public class OrderListAction {

	private List<OrderListLine[]> orders;
	private List<OrderListLine> list = 
		new ArrayList<OrderListLine>();
	private OrderDAO orderDao;

	public String execute() {
		
		List<Object[]> list=orderDao.findOrders();
		for(Object[] obj:list){
			OrderListLine line = new OrderListLine();
			line.setId(Integer.valueOf(obj[0].toString()));
			line.setNickname(obj[1].toString());
			long time=Long.valueOf(obj[2].toString());
			line.setOrderTime(new Date(time));
			line.setTotalPrice(new BigDecimal(obj[3].toString()));
			orders.add(line);
		}
	}

	public List<OrderListLine[]> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderListLine[]> orders) {
		this.orders = orders;
	}

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
}
