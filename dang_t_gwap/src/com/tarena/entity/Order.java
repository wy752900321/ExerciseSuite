package com.tarena.entity;

import java.io.Serializable;

/**
 * d_order
 * 
 * @author soft01
 * 
 */
public class Order implements Serializable {
	private static final long serialVersionUID = -6972584002069945911L;
	// property
	private int id;
	private int userId;
	private int status;
	private long orderTime;
	private String orderDesc;
	private double totalPrice;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;

	// default constructor
	public Order() {
	}

	// other constructor
	public Order(int userId, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone, double totalPrice) {
		this.userId = userId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.phone = phone;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.totalPrice = totalPrice;
	}

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "Order [fullAddress=" + fullAddress + ", id=" + id + ", mobile="
				+ mobile + ", orderDesc=" + orderDesc + ", orderTime="
				+ orderTime + ", phone=" + phone + ", postalCode=" + postalCode
				+ ", receiveName=" + receiveName + ", status=" + status
				+ ", totalPrice=" + totalPrice + ", userId=" + userId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof Order) {
			Order order = (Order) obj;
			return order.id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
