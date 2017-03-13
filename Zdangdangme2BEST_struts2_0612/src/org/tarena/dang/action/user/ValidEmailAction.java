package org.tarena.dang.action.user;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;

public class ValidEmailAction {
	// 接收请求传递的email
	private String email;
	// json响应
	private boolean ok;

	public String execute() throws Exception {
		UserDAO userDao = new UserDAOImpl();
			User user = userDao.findByEmail(email);
			if (user == null) {
				ok = true;
			} else {
				ok = false;
			}
			return "success";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
