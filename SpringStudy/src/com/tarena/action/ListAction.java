package com.tarena.action;

import java.util.List;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class ListAction {
	//传出参数
	private List<User> users;
	//注入变量
	private UserDAO userDao;
	//自动调用,注入dao
	public void setUserDao(UserDAO userDao){
		this.userDao=userDao;
	}
	public String execute(){
		users = userDao.findAll();
		return "success";
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UserDAO getUserDao() {
		return userDao;
	}
}
