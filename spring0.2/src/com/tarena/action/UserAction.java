package com.tarena.action;

import com.tarena.dao.UserDAO;

public class UserAction {

	private UserDAO userDao;//接口类型，实现类不能出现

	// setter方式注入，自动调用
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
