package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tarena.dao.UserDAO;
@Controller("useraction3")
//@Service
//@Component
public class UserAction3 {
	
	//@Resource(name="hibernateUserDAO")
	@Autowired
	@Qualifier("hibernateUserDAO")
	private UserDAO userDao;//接口类型，实现类不能出现
	//setter方式注入,自动调用
//	public void setUserDao(UserDAO userDao){
//		this.userDao = userDao;
//	}
	

	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
