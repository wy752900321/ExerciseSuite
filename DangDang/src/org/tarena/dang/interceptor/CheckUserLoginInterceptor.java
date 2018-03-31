package org.tarena.dang.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.Constant;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckUserLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1786258613150583571L;
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.warn(".............CheckUserLoginInterceptor.............");
		Map<String,Object> session = ServletActionContext.getContext().getSession();
		log.warn("session............"+session.get("user"));
		Object obj = session.get(Constant.USER_KEY);
		if(obj == null){
			return "login";
		}
		User user = (User) session.get("user");
		log.warn("session.............."+user.getId());
		
		return invocation.invoke();
	}

}
