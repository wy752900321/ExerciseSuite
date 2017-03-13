package com.tarena.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.Constant;
import com.tarena.util.DAOFactory;
import com.tarena.util.EmailUtil;
import com.tarena.util.MD5Util;
import com.tarena.util.VerifyUtil;

/**
 * 用户服务器
 * 
 * @author soft01
 * 
 */
public class UserServiceImpl implements UserSerivice {
	private static final long serialVersionUID = -7966927966405304824L;

	/**
	 * 检查用户登陆
	 * 
	 * @param email
	 *            用户输入的邮箱
	 * @param password
	 *            用户输入的密码
	 * @param servletRequest
	 *            监听的request
	 * @param session
	 *            监听的session
	 * @return 返回一个登陆成功或失败的字符串
	 */
	public String checkLogin(String email, String password,
			HttpServletRequest servletRequest, Map<String, Object> session) {

		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// 1.检查email和密码是否正确
			User user = userDAO.findByEmail(email);
			if (user != null
					&& MD5Util.md5(password).equals(user.getPassword())) {
				// 2.检查邮箱是否通过验证
				if (user.isEmailVerify()) {
					// 3.更新d_user中最后登录时间和ip
					user.setLastLoginTime(System.currentTimeMillis());
					user.setLastLoginIp(servletRequest.getRemoteAddr());
					userDAO.updateById(user.getId());
					// 4.将user写入session
					session.put("user", user);
					// 5.跳转到/main/main.jsp
					return "success";
				} else {
					// 未验证跳转到verify_form.jsp
					return "verify";
				}
			} else {
				// 不正确跳转到login_form.jsp
				return "login";
			}
		} catch (Exception e) {
			// 记录日志
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("检查用户登陆时出了异常", e);
			// error.jsp
			return "errror";
		}
	}

	/**
	 * 用户注册逻辑
	 * 
	 * @param user
	 *            用户
	 * @param session
	 *            监听的session
	 * @param servletRequest
	 *            监听的request
	 * @return
	 */
	public boolean register(User user, Map<String, Object> session,
			HttpServletRequest servletRequest) {
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// 将密码利用MD5加密
			String pwd = MD5Util.md5(user.getPassword());
			user.setPassword(pwd);
			user.setUserIntegral(Constant.INTEGRAL_NORMAL);
			// 登陆时间为当前时间
			user.setLastLoginTime(System.currentTimeMillis());
			// 登陆IP
			user.setLastLoginIp(servletRequest.getRemoteAddr());
			user.setEmailVerify(false);
			// 生成邮箱验证码
			String verifyCode = VerifyUtil.randomUUID();
			user.setEmailVerifyCode(verifyCode);
			// 保存用户
			userDAO.insert(user);
			session.put("registerUser", user);
			// 将邮箱验证码给用户发送
			String emailCode = verifyCode + "-" + user.getId();
			EmailUtil.sendEmail(user.getEmail(), "当当邮箱验证", emailCode);
			return true;
		} catch (Exception e) {
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("注册用户时出了异常", e);
			return false;
		}
	}

	/**
	 * 验证邮箱逻辑
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	public String verifyEmail(String code, Map<String, Object> session) {
		// 将接收到的邮箱验证码解析
		// 获取用户ID和UUID
		String uuid = code.substring(0, code.lastIndexOf("-"));
		int id = Integer.parseInt(code.substring(code.lastIndexOf("-") + 1));
		User user = (User) session.get("registerUser");
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			boolean flag = userDAO.findById(user.getId()).isEmailVerify();
			if (flag) {
				// 第二次验证回到main.jsp
				return "main";
			} else if (user.getId() != id) {
				// 不是他的验证码，让他重新验证
				return "verify";
			}
			// 利用ID和UUID去数据库检索
			String dbcode = userDAO.findById(id).getEmailVerifyCode();
			// 判断是否正确
			if (dbcode.equals(uuid)) {
				// 如果正确,更新d_user的is_email_verify
				String str = userDAO.updateVerify(id, true);
				if (str.equals("Y")) {
					flag = true;
				} else {
					flag = false;
				}
				// 验证通过到register_ok.jsp
				return "success";
			} else {
				// 重新验证
				return "verify";
			}
		} catch (Exception e) {
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("验证用户code时出了异常", e);
			return "error";
		}
	}
}
