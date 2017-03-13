package com.tarena.action;

import com.tarena.dao.UserDAO;

public class UserAction2 {

	private UserDAO userDao;//接口类型，实现类不能出现

	//构造方法注入
	public UserAction2(UserDAO userDao){
		this.userDao=userDao;
	}
	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
