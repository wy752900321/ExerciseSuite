package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 封装登录检查
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor{
	//主方法
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截器前期处理");
		//登录检查
		Map<String,Object> session = 
				ActionContext.getContext().getSession();
		if(session.get("user") == null){
			//未登录,定位到login.jsp
			return "login";
		}
//		调用下一个拦截器或者Action-->Result的业务方法
		String result = invocation.invoke();
		//invocation.invokeActionOnly()
		System.out.println("拦截器后期处理");
		return result;
	}

}
