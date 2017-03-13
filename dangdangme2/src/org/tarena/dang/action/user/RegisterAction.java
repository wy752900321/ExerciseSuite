package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.UserService;
import org.tarena.dang.service.impl.UserServiceImpl;

public class RegisterAction extends BaseAction {
	private User user;

	public String execute() throws Exception {
		// 设置最后登录IP
		String ip = httpRequest.getRemoteAddr();
		user.setLastLoginIp(ip);
		//调用业务组件UserService完成处理
		UserService userService = new UserServiceImpl();
		userService.register(user);
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
