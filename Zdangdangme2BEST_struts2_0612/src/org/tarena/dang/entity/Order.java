package org.tarena.dang.entity;
/**
	DROP TABLE IF EXISTS d_order;
	CREATE TABLE d_order (
	  id int(10) NOT NULL auto_increment,
	  user_id int(10) NOT NULL,
	  status int(10) NOT NULL,
	  order_time bigint(20) NOT NULL,
	  order_desc varchar(100) default NULL,
	  total_price double NOT NULL,
	  receive_name varchar(100) default NULL,
	  full_address varchar(200) default NULL,
	  postal_code varchar(8) default NULL,
	  mobile varchar(20) default NULL,
	  phone varchar(20) default NULL,
	  PRIMARY KEY  (id)
	) ENGINE=InnoDB;	
 */
public class Order {
	private int id;//定单id
	private int user_id;//用户ID
	private int status;//status[ˊsteitәs] n. 状态,情形,地位;
	private long order_time;	//定单时间
	private String order_desc;//定单描述
	private double total_price;//总价
	private String receive_name;//收件人姓名
	private String full_address;//收件人地址
	private String postal_code;//邮编
	private String mobile;//电话
	private String phone;//手机
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
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
