package com.tarena.action.user;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DAOFactory;

/**
 * 邮箱唯一性检查
 * 
 * @author soft01
 * 
 */
public class ValidEmailAction implements Serializable {
	private static final long serialVersionUID = 4736738956977619998L;
	// 负责获取用户输入的email
	private String email;
	// email检查结果,true可用,false为被占用
	private boolean ok;

	public String execute() {
		// 实例化一个UserDAO对象
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// 动态休眠1500毫秒
			Thread.sleep(1500);
			// 通过用户输入的email到数据库中查找
			User user = userDAO.findByEmail(email);
			// 没找到true可用,
			if (user == null) {
				ok = true;
			} else {
				// 找到false不可用
				ok = false;
			}
			// 返回页面发送的ajax请求的json对象
			return "success";// json
		} catch (Exception e) {
			Logger logger = Logger.getLogger(ValidEmailAction.class);
			logger.error("邮箱唯一性验证出错", e);
			// 链接到error.jsp页面
			return "error";
		}
	}

	// getter and setter
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}
}
