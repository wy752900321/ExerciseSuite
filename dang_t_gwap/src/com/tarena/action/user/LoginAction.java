package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * 此Action为处理用户登陆并把登陆信息显示给用户
 * 
 * @author soft01
 * 
 */
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 377910275586090069L;
	// input 用户输入的email
	private String name;
	// input 用户输入的password
	private String password;
	private User user;
	// output 显示给用户的信息信息
	private String errorMessage;

	public String execute() {
		// 获取用户服务的实例
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// 调用检查用户服务的方法
		String str = userSerivice.checkLogin(name, password, request, session);

		if (str.equals("success")) {
			// 如果成功链接到main.jsp页面
			return "success";
		} else if (str.equals("verify")) {
			// 如果没有进行邮箱验证链接verify_form.jsp页面
			return "verify";
		} else if (str.equals("login")) {
			// 如果登陆失败，即用户名或密码错误，在当前页面
			errorMessage = "用户名或密码错误";
			return "login";
		} else {
			// 如果出错，去error.jsp页面
			return "error";
		}
	}

	// 登出逻辑
	public String logout() {
		// 在session中移出user
		session.remove("user");
		// 链接到main.jsp页面
		return "success";
	}
	
	// getter and setter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
