package com.tarena.interceptor;

import java.util.Map;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tarena.entity.User;

public class CheckUserLoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 5653703906160931535L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("判断用户是否登录开始！");
		Map <String ,Object>  session = ServletActionContext.getContext().getSession();
		System.out.println("session........."+session.get("user"));
		Object obj = session.get("user");
		System.out.println();
		if(obj==null){
			return "login";
		}
		User user = (User)session.get("user");
		System.out.println("session........."+user.getId());
		invocation.invoke();
		return"ss";
	}

}
