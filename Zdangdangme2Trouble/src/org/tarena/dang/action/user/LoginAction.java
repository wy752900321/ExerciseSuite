package org.tarena.dang.action.user;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.MD5Utils;

public class LoginAction extends BaseAction {
	private String email;
	private String password;
	private User user;
	private String login_erro_msg;
	private UserDAO dao = new UserDAOImpl();
	private String uri = "/main/main.jsp";
	private Logger log = Logger.getLogger(this.getClass());
	public String execute() throws Exception {

			user = dao.findByEmail(email);
			String pwd = MD5Utils.md5(password);
			if (user != null && pwd.equals(user.getPassword())) {
				if (user.isEmailVerify()) {
					user.setLastLoginTime(System.currentTimeMillis());
					user.setLastLoginIp(httpRequest.getRemoteAddr());
					dao.updateTimeOrIp(user);
					session.put(Constant.SESSION_USER, user);
					String uri = (String) session.get(Constant.URI);
					log.warn(uri);
					if (uri != null) {
						this.uri = uri.substring(uri.indexOf("/", 1));
						System.out.println(this.uri);
						session.remove("uri");
					}
					return "success";
				} else {
					return "fail";
				}
			}
			login_erro_msg = "登陆失败啦";
			return "failer";
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin_erro_msg() {
		return login_erro_msg;
	}

	public void setLogin_erro_msg(String loginErroMsg) {
		login_erro_msg = loginErroMsg;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Logger getLog() {
		return log;
	}

}
