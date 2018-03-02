package org.tarena.dang.action.order;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.dao.impl.OrderDAOImpl;
import org.tarena.dang.entity.Order;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;

public class OrderAction extends BaseAction {
	private Logger log = Logger.getLogger(this.getClass());
	private List<Order> orderList;
	private int address_id;
	private String order;
	
	// 根据下拉列表获取收货人的地址信息
	public String getNewOrder() throws Exception {
		log.warn("..............getNewOrder()..................");
		OrderDAO orderDao = new OrderDAOImpl();
		//log.warn("===address_id====="+address_id+"=======");
		order = orderDao.findOrderByOrderId(address_id);
		return "getNewOrderSuccess";
	}

	// 根据用户的id 获取到用户订单的下拉列表
	public String findOrderByUserId() throws Exception {
		log.warn("..............findOrderByUserId() Begin..................");
		OrderDAO orderDao = new OrderDAOImpl();
		//User user = (User) session.get("user");
		User user = (User)session.get(Constant.USER_KEY);
		log.warn("user.getId(): "+user.getId());
		orderList = orderDao.findOrderByUserId(user.getId());
		log.warn("....orderList.size(): "+orderList.size());
		log.warn("..............findOrderByUserId() End..................");
		return "findOrderSuccess";
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int addressId) {
		address_id = addressId;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
