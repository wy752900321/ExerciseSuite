package org.tarena.dang.action.user;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;

public class VerifyEmailAction extends BaseAction {
	private String code;
	private User user;
	private Logger log = Logger.getLogger(this.getClass());

	public String execute() throws Exception {
		log.warn("code->"+code);
		UserDAO dao = new UserDAOImpl();

		int id = Integer.parseInt(code.substring(code.lastIndexOf("_") + 1,
					code.length()));
			String verifyCode = code.substring(0, code.lastIndexOf("_"));
			user = dao.fingUserById(id);

			log.warn("user=>"+user);
			if (user != null && user.getEmailVerifyCode().equals(verifyCode)) {
				log.warn("success..........");
				dao.updateEmailVerify(user);
				session.put(Constant.USER_KEY, user);
				return "success";
			}
			log.warn("fail");
			return "fail";

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
