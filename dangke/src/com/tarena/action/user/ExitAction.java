package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.util.Contant;

public class ExitAction extends BaseAction{
	public String execute(){
		try {
			session.remove("user");
			session.remove(Contant.SESSION_CART);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		 return "success";
	}
}
