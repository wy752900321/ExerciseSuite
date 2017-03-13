package com.tarena.action.user;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DAOFactory;

/**
 * 关联register_form.jsp页面的验证nickname的合法性
 * 
 * @author soft01
 * 
 */
public class ValidNickNameAction implements Serializable {
	private static final long serialVersionUID = 984731460159551471L;
	// 定义一个变量用来接收用户输入的nickname
	private String nickname;
	// 定义一个变量用来确定此nickname是否正确
	private boolean ok;

	public String execute() {
		// 获得UserDAO的实例
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// 动态休眠1500毫秒
			Thread.sleep(1500);
			// 通过此实例通过此nickname到数据库中找用户
			User user = userDAO.findByNickName(nickname);
			// 如果用户为空，代表nickname可用
			if (user == null) {
				ok = true;
			} else {
				// 否则nickname被占用
				ok = false;
			}
			// 返回ajax请求的json对象的值
			return "success";
		} catch (Exception e) {
			Logger log=Logger.getLogger(ValidNickNameAction.class);
			log.error("用户名合法性出错", e);
			// 链接到error.jsp页面
			return "error";
		}
	}

	// getter and setter
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}
}
