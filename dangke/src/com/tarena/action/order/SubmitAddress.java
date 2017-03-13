package com.tarena.action.order;

import java.util.Random;

import com.tarena.action.BaseAction;
import com.tarena.dao.OrderDAO;
import com.tarena.dao.impl.OrderDAOImpl;
import com.tarena.entity.User;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;

public class SubmitAddress extends BaseAction {
	private int address_id;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String phone;
	private String mobile;

	// 返回order_ok页面的信息
	private int orderId;
	private double totalPrice;

	public String execute() {

		System.out.println("addressId......................." + address_id);
		OrderDAO orderDao = new OrderDAOImpl();
		User user = (User) session.get("user");
		int userId = user.getId();
		try {
			CartService cart = CartServiceImpl.getInstance(session);
			Random random = new Random();
			orderId = random.nextInt(99999999);
			totalPrice = cart.countCost();
			if (address_id == -1) {
				orderDao.addCategoryProduct(1, receiveName, fullAddress,
						postalCode, phone, mobile);
			}
			int orderId = orderDao.addAddress(userId, receiveName, fullAddress,
					postalCode, phone, mobile, totalPrice);
			for (CartItem item : cart.getItems(true)) {
				orderDao.addProduct(orderId, item);
			}
			cart.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int addressId) {
		address_id = addressId;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
