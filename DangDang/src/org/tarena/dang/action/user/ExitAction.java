package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.util.Constant;

public class ExitAction extends BaseAction{
	public String execute(){
			session.remove("user");
			session.remove(Constant.CART_KEY);
		return "success";
	}
}
