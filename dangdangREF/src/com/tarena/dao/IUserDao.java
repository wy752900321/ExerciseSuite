package com.tarena.dao;

import com.tarena.entity.exet.User;

public interface IUserDao {

	// 用户注册
	int saveUser(User user);

	// 通过userId查询用户信息
	User findUserById(User user);

	// 通过email查询用户信息
	User findUserByEmail(User user);

	// 修改用户的邮箱验证状态
	boolean updateEmailVerify(User user);
	
}
