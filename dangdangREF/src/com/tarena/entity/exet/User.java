package com.tarena.entity.exet;

import com.tarena.entity.AbstractUser;

public class User extends AbstractUser {
	public User(){}

	public boolean isLoginOk() {
		return loginOk;
	}

	public void setLoginOk(boolean loginOk) {
		this.loginOk = loginOk;
	}

	private String userEmailVerifyCode;// 需要用户输入的邮箱验证码
	private String imageCode;// 验证码
	private boolean loginOk=false;//是否登录成功
	

	public String getUserEmailVerifyCode() {
		return userEmailVerifyCode;
	}

	public void setUserEmailVerifyCode(String userEmailVerifyCode) {
		this.userEmailVerifyCode = userEmailVerifyCode;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

}
