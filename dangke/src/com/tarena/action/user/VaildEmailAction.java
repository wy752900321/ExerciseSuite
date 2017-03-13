package com.tarena.action.user;

import com.tarena.dao.UserDAO;
import com.tarena.dao.impl.UserDAOImpl;
import com.tarena.entity.User;

public class VaildEmailAction {
	private String email;
	// 检查邮箱是否可用ok=true 可用 ／false不可用
	private boolean ok = false;

	public String execute() {
		UserDAO userDao = new UserDAOImpl();
		try {
			User user = userDao.findUserByEmail(email);
			if (user == null) {
				ok = true;
			} else {
				ok = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
			return "error";
		}
		return "success";// json
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
