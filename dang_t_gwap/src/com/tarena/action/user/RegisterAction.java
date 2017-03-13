package com.tarena.action.user;


import com.tarena.action.BaseAction;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * 注册处理
 * 
 *
 * 
 */
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 8694976724357168116L;
	//定义用户对象
	private User user;
	//获取邮箱验证码
	private String emailCode;

	public String execute() {
		// 实例化UserSerivice对象
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// 让用户服务器去处理注册操作
		// 如果返回success，链接到verify_form.jsp页面
		// 如果返回error，链接到error.jsjp页面
		String str = userSerivice.register(user,session, request) == true ? "success"
				: "errror";
		return str;
	}

	// getter and setter
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getEmailCode() {
		return emailCode;
	}
}
