package org.colin.dang.action.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.colin.dang.action.BaseAction;
import org.colin.dang.dao.UserDAO;
import org.colin.dang.dao.impl.UserDAOImpl;
import org.colin.dang.pojo.User;
import org.colin.dang.service.UserService;
import org.colin.dang.service.impl.UserServiceImpl;
import org.colin.dang.util.EncryptUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CheckLogin extends ActionSupport implements ServletRequestAware{
  private String email;
  private String password;
  private HttpServletRequest request;
  
  public String execute() throws Exception {
	  User user=new User();
	 UserService service=new UserServiceImpl();
	 String ip=request.getRemoteAddr();
	 String pwd=service.loginCheckEmail(email,ip);
	  String sr=EncryptUtil.md5(password);
		  if(sr.equals(pwd)){
				 return "success";
			  }else{
				  this.addActionError("用户名或密码错误！");
				  return "error";
			  }
  }
  
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public void setServletRequest(HttpServletRequest arg0) {
	this.request=arg0;
	
}


}
