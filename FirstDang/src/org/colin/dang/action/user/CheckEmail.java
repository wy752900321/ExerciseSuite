package org.colin.dang.action.user;

import org.colin.dang.dao.UserDAO;
import org.colin.dang.dao.impl.UserDAOImpl;
import org.colin.dang.pojo.User;
import org.colin.dang.service.UserService;
import org.colin.dang.service.impl.UserServiceImpl;

public class CheckEmail {
 private boolean ok;
 private String email;
 public String execute() throws Exception{
	 Thread.sleep(1000);
	   UserService service=new UserServiceImpl();
	   ok=service.checkEmail(email);
	 return "success";
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
