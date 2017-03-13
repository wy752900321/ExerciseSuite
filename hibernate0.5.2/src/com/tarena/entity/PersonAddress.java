package com.tarena.entity;

public class PersonAddress {
	private String phone;
	private String address;
	private String zipcode;
	public PersonAddress(String phone, 
			String address, String zipcode) {
		super();
		this.phone = phone;
		this.address = address;
		this.zipcode = zipcode;
	}
	public PersonAddress() {
		super();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
