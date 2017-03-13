package com.tarena.web.action;

import org.apache.struts2.ServletActionContext;

import com.tarena.biz.IUserServ;
import com.tarena.entity.exet.User;
import com.tarena.factory.ObjectFactory;
import com.tarena.util.string.Md5;
import com.tarena.util.string.StringFormat;

public class UserAction extends BaseAction {
	private User user;
	// 用户登录输入的邮箱
	private String email;
	// 用户登录输入的密码
	private String password;
	// 用户注册输入的密码
	private String userPassword;
	// 用户登录时邮箱错误提示
	private String msg;
	private String errormsg;
	// 工厂（业务）
	private IUserServ iuserServ = (IUserServ) ObjectFactory
			.createObject("IUserServ");
	// 邮箱未验证
	private String emailVerify;
	// 邮箱验证码错误
	private String errEmailCode;
	// 验证码错误信息
	private String errorEmail;
	
	// 进入注册页面
	public String toRegister() {
		return "register_form";
	}

	// 用户注册
	public String doRegister() {
		user.setLastLoginIp(ServletActionContext.getRequest()
				.getLocalAddr());

		/**
		 * 1.判断再次输入密码和密码是否相同 2. 判断验证码是否正确
		 */
		// 获取正确验证码
		String rightImageCode = (String) session.get("imageCode");
		// 获取用户输入验证码
		String userImageCode = user.getImageCode();
		String s =iuserServ.findUserByEmail1(user);
		if (s.equals("successEmail")) {
			if (rightImageCode.equals(userImageCode)) {
				int userId = iuserServ.register(user);
				if (userId > 0) {
					user.setUserId(userId);
					session.put("user", user);
					return "verify_form";
				} else {
					return "register_form";
				}
			} else {
				errormsg = "验证码有误！";
				return "register_form";
			}
		} else {
			errorEmail = "邮箱已经存在";
			return "register_form";
		}
	}

	// 注册成功
	public String registerOk() {
		// 获取用户输入的邮箱验证码
		String userEmailVerifyCode = user.getUserEmailVerifyCode();
		// 判断是否包含 "－"
		if (userEmailVerifyCode.contains("-")) {
			// 判断最后一位是否为数字
			// 将邮箱验证码拆分为邮箱验证码
			String resultEmailCode = StringFormat
					.isNotNullString(userEmailVerifyCode
							.substring(
									0,
									userEmailVerifyCode
											.lastIndexOf("-")));
			// 将邮箱验证码拆分为用户id
			int resultID = StringFormat
					.isNotNullInteger(userEmailVerifyCode
							.substring(
									userEmailVerifyCode
											.lastIndexOf("-") + 1,
									userEmailVerifyCode
											.length()));
			if (resultID > 0) {
				user.setUserId(resultID);
				user = iuserServ.findUserById(user);
				if (resultEmailCode.equals(user
						.getEmailVerifyCode())) {
					// 将用户邮箱是否验证设置为Y
					user.setIsEmailVerify("Y");
					boolean bool = iuserServ
							.updateEmailVerify(user);
					if (bool) {
						return "register_ok";
					}
				}
			} else {
				errEmailCode = "邮箱验证码错误";
				return "verify_form";
			}
		} else {
			errEmailCode = "邮箱验证码错误";
			return "verify_form";
		}
		return "verify_form";
	}

	// 用户登录
	public String login() {
		return "login_form";
	}

	// 商品展示
	public String showBook() {
		// 查询数据库中是否存在邮箱email
		User u = new User();
		u.setEmail(email);
		// 对用户输入的密码加密
		password = Md5.encode(password);
		user = iuserServ.findUserByEmail(u);
		if (user != null && user.getPassword() != null) {
			if (user.getPassword().equals(password)) {
				if (user.getIsEmailVerify().equals("Y")) {
					session.put("loginOk", true);
					session.put("user", user);
					return "show";
				} else {
					emailVerify = "该邮箱还未激活，请点击激活";
					return "login_form";
				}
			}
		}
		msg = "邮箱不存在";
		return "login_form";
	}

	// 登出
	public String logout() {
		boolean loginOk = (Boolean) session.get("loginOk");
		loginOk = false;
		session.put("loginOk", loginOk);
		return "show";
	}

	// 邮箱激活
	public String emailVerify() {
		user = iuserServ.findUserByEmail(user);
		return "verify_form";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserServ getIuserServ() {
		return iuserServ;
	}

	public void setIuserServ(IUserServ iuserServ) {
		this.iuserServ = iuserServ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(String emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrEmailCode() {
		return errEmailCode;
	}

	public void setErrEmailCode(String errEmailCode) {
		this.errEmailCode = errEmailCode;
	}

	public String getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

}
