package org.colin.dang.action.user;

import org.colin.dang.action.BaseAction;
import org.colin.dang.service.UserService;
import org.colin.dang.service.impl.UserServiceImpl;

public class EmailVerifyCode extends BaseAction{
    private String errorTxt;
   private String email;
     private boolean ok;
    
    public String execute()throws Exception{
    	 UserService service=new UserServiceImpl();
    	 ok=service.emailVerifyCode(errorTxt,email);
    	return "success";
    }
    
	public String getErrorTxt() {
		return errorTxt;
	}
	public void setErrorTxt(String errorTxt) {
		this.errorTxt = errorTxt;
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
