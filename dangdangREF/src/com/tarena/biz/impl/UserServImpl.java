package com.tarena.biz.impl;

import com.tarena.biz.IUserServ;
import com.tarena.dao.IUserDao;
import com.tarena.entity.exet.User;
import com.tarena.factory.ObjectFactory;
import com.tarena.util.email.EmailUtil;
import com.tarena.util.string.EmailVerifyCode;
import com.tarena.util.string.Md5;

public class UserServImpl implements IUserServ {

	// 调用数据访问层
	private IUserDao iuserDao = (IUserDao) ObjectFactory
			.createObject("IUserDao");

	@Override
	public int register(User user) {
		// MD5加密
		user.setPassword(Md5.encode(user.getPassword()));
		// 设置最后一次登录的时间
		user.setLastLoginTime(System.currentTimeMillis());
		// 设置email验证码
		String emailVerifyCode = EmailVerifyCode
				.createEmailVerifyCode();
		user.setEmailVerifyCode(emailVerifyCode);
		// 将email验证码发送到用户邮箱
		boolean bool = EmailUtil.sendEmail(user.getEmail(),
				emailVerifyCode);
		/*
		 * if(bool){
		 * 
		 * }
		 */
		return iuserDao.saveUser(user);
	}

	@Override
	public User findUserById(User user) {
		return iuserDao.findUserById(user);
	}

	@Override
	public String findUserByEmail1(User user) {
		if (user != null && user.getEmail() != null) {
			User u = iuserDao.findUserByEmail(user);
			if (user.getEmail().equals(u.getEmail())) {
				return "errorEmail";
			}
		}
		return "successEmail";
	}

	public User findUserByEmail(User user) {
		return iuserDao.findUserByEmail(user);
	}

	@Override
	public boolean updateEmailVerify(User user) {
		return iuserDao.updateEmailVerify(user);
	}

}
