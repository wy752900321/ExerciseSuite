package cn.com.webwork.ActionSupport;

import cn.com.webwork.register.User;

import com.opensymphony.xwork.ActionSupport;

public class RegisterActionSupport extends ActionSupport {
	private User user= new User();
	private String verifyPassword;
	
	public User getUser(){
		return this.user;
	}
	
	public String execute(){
		System.out.println("Start execute 。。。。。。。。。。。。。");
		System.out.println("User="+user);
		System.out.println("verifyPassword="+verifyPassword);
		
		//在这里调用用户注册的业务逻辑，比如：将注册信息存储到数据库
		return SUCCESS;
	}

	public String getVerifyPassword(){
		return this.verifyPassword;
	}
	
	public void setVerifyPassword(String verPassword){
		this.verifyPassword = verPassword;
	}

}
