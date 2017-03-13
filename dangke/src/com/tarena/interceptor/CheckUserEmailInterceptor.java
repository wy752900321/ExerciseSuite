package com.tarena.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tarena.entity.User;

public class CheckUserEmailInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 28236187941471135L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			Map <String ,Object>  session = ServletActionContext.getContext().getSession();
			User user = (User)session.get("user");
			if(!user.isEmailVerify()){
				return "verify";
			}
			invocation.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

}
