package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.dao.UserDAO;
import com.tarena.dao.impl.UserDAOImpl;
import com.tarena.entity.User;
import com.tarena.util.Contant;
import com.tarena.util.EmailUtil;
import com.tarena.util.MD5Util;
import com.tarena.util.VerifyUtil;

public class RegisterAction extends BaseAction {
	private User user;

	public String execute() {
		UserDAO userDao = new UserDAOImpl();
		// 将密码利用MD5加密
		String pwd;
		try {
			pwd = MD5Util.encode(user.getPassword());
			user.setPassword(pwd);
			user.setUserIntegral(Contant.INTEGRAL_NORMAL);
			user.setLastLoginTime(System.currentTimeMillis());
			user.setLastLoginIp(request.getRemoteAddr());
			user.setEmailVerify(false);

			// 生成邮箱验证码
			String verifyCode = VerifyUtil.randomUUID();
			user.setEmailVerifyCode(verifyCode);
			userDao.insert(user);// 保存用户
			// 将邮箱验证码给用户发送
			String emailCode = verifyCode + "-" + user.getId();
			EmailUtil.sendEmail(user.getEmail(), "当当邮箱验证", emailCode);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
