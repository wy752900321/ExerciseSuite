package org.colin.dang.action.user;

import org.colin.dang.action.BaseAction;
import org.colin.dang.common.Constant;
import org.colin.dang.dao.UserDAO;
import org.colin.dang.dao.impl.UserDAOImpl;
import org.colin.dang.pojo.User;
import org.colin.dang.service.UserService;
import org.colin.dang.service.impl.UserServiceImpl;
import org.colin.dang.util.EmailUtil;
import org.colin.dang.util.EncryptUtil;
import org.colin.dang.util.VerifyUtil;

public class RegisterAction extends BaseAction{
  private User user;
  
   public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String execute() throws Exception{
	 String ip=httpRequest.getRemoteAddr();
	   user.setLastLoginIp(ip);
	   UserService service=new UserServiceImpl();
	 service.register(user);
	  session.put("user", user);
	   return "success";
	   
   }
}
