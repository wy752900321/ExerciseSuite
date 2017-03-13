package org.tarena.dang.action.user;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;

public class ValidNickNameAction {
	// 接收 请求传递的nickname
	private String nickname;
	// json响应
	private boolean go;
	private User user;

	public String execute() throws Exception {
		UserDAO userDao = new UserDAOImpl();

		user = userDao.findByNickName(nickname);
			if (user == null) {
				go = true;
			} else {
				go = false;
			}
			return "success";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isGo() {
		return go;
	}

	public void setGo(boolean go) {
		this.go = go;
	}
}
