package org.colin.dang.action.user;

import org.colin.dang.action.BaseAction;
import org.colin.dang.common.Constant;
import org.colin.dang.pojo.User;

public class ValidImageAction extends BaseAction{
  private boolean ok;
  private String usercode;
  public String execute() throws Exception{
	  Thread.sleep(1000);
	String scode= (String) session.get(Constant.CODE);
	    
	    if(usercode.equalsIgnoreCase(scode)){
	    	ok=true;
	    }else{
	    	ok=false;
	    }
	  return "success";
  }
public boolean isOk() {
	return ok;
}
public void setOk(boolean ok) {
	this.ok = ok;
}
public String getUsercode() {
	return usercode;
}
public void setUsercode(String usercode) {
	this.usercode = usercode;
}




  
}
