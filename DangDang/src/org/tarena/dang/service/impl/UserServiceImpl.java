package org.tarena.dang.service.impl;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.UserService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.EmailUtils;
import org.tarena.dang.util.MD5Utils;
import org.tarena.dang.util.VerifyCodeUtils;

public class UserServiceImpl implements UserService {
	public void register(User user) throws Exception {
		UserDAO userDao = new UserDAOImpl();
		// 将密码加密
		String md5Pwd = MD5Utils.md5(user.getPassword());
		user.setPassword(md5Pwd);
		// 设置系统用户等级为初级
		user.setUserIntegral(Constant.NORMAL_LEVEL);
		// 设置邮箱未通过验证
		user.setEmailVerify(false);
		// 设置最后登录时间
		user.setLastLoginTime(System.currentTimeMillis());
		// 生成邮箱验证码
		String uuid = VerifyCodeUtils.generateCode();
		// 设置user对象的email_verify_code字段
		user.setEmailVerifyCode(uuid);
		userDao.save(user);
		// 将用户id和uuid发送给用户邮箱
		String code = uuid + "_" + user.getId();
		EmailUtils.sendEmail(code, user.getEmail());
	}
}
