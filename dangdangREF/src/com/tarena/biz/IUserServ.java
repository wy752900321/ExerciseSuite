package com.tarena.biz;

import com.tarena.entity.exet.User;

public interface IUserServ {

	//用户注册
	int register(User user);
	//通过userId查询用户信息
	User findUserById(User user);
	//通过email查询用户信息
	String findUserByEmail1(User user);
	
	User findUserByEmail(User user);
	//修改用户的邮箱验证状态
	boolean updateEmailVerify(User user);
}
