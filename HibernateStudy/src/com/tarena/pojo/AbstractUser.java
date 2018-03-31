package com.tarena.pojo;

import java.util.HashSet;
import java.util.Set;

import com.tarena.pojo.ext.Address;


public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Integer userIntegral;
	private String isEmailVerify;
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;

	private Set<Address> address = new HashSet<Address>();
	
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public AbstractUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserIntegral() {
		return this.userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public String getIsEmailVerify() {
		return this.isEmailVerify;
	}

	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return this.emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

}