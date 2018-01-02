package org.tarena.dang.entity;
/**
	DROP TABLE IF EXISTS d_receive_address;
	CREATE TABLE d_receive_address (
	  id int(12) NOT NULL auto_increment,
	  user_id int(11) NOT NULL,
	  receive_name varchar(20) NOT NULL,
	  full_address varchar(200) NOT NULL,
	  postal_code varchar(8) NOT NULL,
	  mobile varchar(15) default NULL,
	  phone varchar(20) default NULL,
	  PRIMARY KEY  (id)
	) ENGINE=InnoDB;
 */
public class Address {
	private int id;	//地址ID
	private int user_id;//用户ID
	private String receive_name;//收货人姓名
	private String full_address;//收货地址
	private String postal_code;//邮编
	private String mobile;//手机
	private String phone;//电话
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
