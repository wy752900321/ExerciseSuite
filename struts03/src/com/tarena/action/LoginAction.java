package com.tarena.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String username;
	private String password;
	

	public String execute(){
		if("root".equals(username) 
				&&"root".equals(password)){
			Map<String,Object> session = 
				ActionContext.getContext().getSession();
			session.put("user", username);
			return "success";
		}
		return "login";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
