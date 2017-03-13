package com.tarena.entity;

import java.io.Serializable;

public abstract class AbstractUser implements Serializable {

	private static final long serialVersionUID = 1L;

	public AbstractUser() {
	}

	private Integer userId;
	private String email;// 邮箱
	private String nickName;// 昵称
	private String password;// 密码
	private Integer userIntegral = 1;// 用户等级
	private String isEmailVerify = "N";// 邮箱是否验证
	private String emailVerifyCode;// 邮箱验证码
	private Long lastLoginTime;// 最后一次登录时间
	private String lastLoginIp;// 登录IP

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	
	public String getIsEmailVerify() {
		return isEmailVerify;
	}

	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

}
