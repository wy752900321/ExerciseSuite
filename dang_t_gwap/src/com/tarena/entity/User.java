package com.tarena.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * d_user
 * 
 * @author soft01
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 7381375681884695300L;

	// property
	private int id;
	private String email;
	private String nickname;
	private String password;
	private int userIntegral = 0;
	private boolean emailVerify;
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;
	// 追加one-to-many关系到d_receive_address
	private Set<ReceiveAddress> receiveAddresses;

	// override Object's toString,equals,hashCode
	@Override
	public String toString() {
		return "User [email=" + email + ", emailVerify=" + emailVerify
				+ ", emailVerifyCode=" + emailVerifyCode + ", id=" + id
				+ ", lastLoginIp=" + lastLoginIp + ", lastLoginTime="
				+ lastLoginTime + ", nickname=" + nickname + ", password="
				+ password + ", userIntegral=" + userIntegral + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof User) {
			User user = (User) obj;
			return user.id == this.id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public void setReceiveAddresses(Set<ReceiveAddress> receiveAddresses) {
		this.receiveAddresses = receiveAddresses;
	}

	public Set<ReceiveAddress> getReceiveAddresses() {
		return receiveAddresses;
	}

}
