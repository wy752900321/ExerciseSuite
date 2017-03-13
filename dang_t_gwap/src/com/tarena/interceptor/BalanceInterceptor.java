package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 结算是否登录拦截器
 * @author soft01
 *
 */
public class BalanceInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2547451996639196789L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 如果session为空
		if (session.get("user") == null) {
			// 链接到login_from.jsp
			return "login";
		}
		invocation.invoke();
		// 链接到order_info.jsp
		return "success";
	}

}
