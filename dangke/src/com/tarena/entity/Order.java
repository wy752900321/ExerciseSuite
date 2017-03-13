package com.tarena.entity;

public class Order {
	private int id;
	private int User_id;
	private int status;
	private long order_time;
	private String order_desc;
	private double total_price;
	private String receive_name;
	private String full_address;
	private String postal_code;
	private String mobile;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int userId) {
		User_id = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getOrder_time() {
		return order_time;
	}
	public void setOrder_time(long orderTime) {
		order_time = orderTime;
	}
	public String getOrder_desc() {
		return order_desc;
	}
	public void setOrder_desc(String orderDesc) {
		order_desc = orderDesc;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double totalPrice) {
		total_price = totalPrice;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receiveName) {
		receive_name = receiveName;
	}
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String fullAddress) {
		full_address = fullAddress;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postalCode) {
		postal_code = postalCode;
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
