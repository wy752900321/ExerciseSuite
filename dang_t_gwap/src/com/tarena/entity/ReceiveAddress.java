package com.tarena.entity;

import java.io.Serializable;

/**
 * d_receive_address
 * 
 * @author soft01
 * 
 */
public class ReceiveAddress implements Serializable {
	private static final long serialVersionUID = 3510153160605281815L;

	// property
	private int id;
	private int userId;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
	// 追加many-to-one关系到d_user
	private User user;

	// default constructor
	public ReceiveAddress() {
	}

	// all property constructor
	public ReceiveAddress(int userId, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone) {
		super();
		this.userId = userId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
	}

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return receiveName + "-" + fullAddress + "-" + postalCode + "-"
				+ mobile + "-" + phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof ReceiveAddress) {
			ReceiveAddress receiveAddress = (ReceiveAddress) obj;
			return receiveAddress.id == this.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	// setter and getter
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

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
