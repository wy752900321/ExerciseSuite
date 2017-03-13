package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * 验证邮箱的Action,关联verify_form.jsp,完成此页面的验证逻辑
 * 
 * @author soft01
 * 
 */
public class VerifyEmailAction extends BaseAction {
	private static final long serialVersionUID = 1174957779621635968L;
	// 把用户输入的code读入进来进行解析
	private String code;

	public String execute() {
		// 实例化一个userSerivice对象，
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// 用来进行对code的解析操作
		String str = userSerivice.verifyEmail(code, session);
		if (str.equals("success")) {
			// 链接到register_ok.jsp页面
			return "success";
		} else if (str.equals("verify")) {
			// 链接到verify_form.jsp页面
			return "verify";
		} else if (str.equals("main")) {
			// 链接到main.jsp页面
			return "main";
		} else {
			// 链接到error.jsp页面
			return "error";
		}
	}

	// getter and setter
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
