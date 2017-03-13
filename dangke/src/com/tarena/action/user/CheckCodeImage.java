package com.tarena.action.user;

import com.tarena.action.BaseAction;



public class CheckCodeImage extends BaseAction{
	private boolean ok =false;
	private String code;
	public String execute(){
		System.out.println("CheckCodeImage_function_begin.....................");
		String sessionCode =(String)session.get("code");
		System.out.println("session.code....................."+sessionCode);
		if(sessionCode.equals(code)){
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
