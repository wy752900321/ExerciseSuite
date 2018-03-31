package org.tarena.dang.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * /** 2)Action如何使用request,session,application
 * a.利用工具类ActionContext,ServletActionContext
 * b.要Action实现以下Aware接口,利用接口约定的方法注入.(推荐)
 * 原因:减少了Struts2框架API对Action类的侵入,提高Action的灵活性. RequestAware SessionAware
 * ApplicationAware ServletRequestAware ServletResponseAware ServletContextAware
 */

public abstract class BaseAction implements RequestAware, SessionAware,
		ApplicationAware, ServletRequestAware,ServletResponseAware,ServletContextAware {
	public Map<String, Object> request;
	public Map<String, Object> session;
	public Map<String, Object> application;
	public HttpServletRequest httpRequest;//同上边的request只是封装类型不一样，上边用的是Map
	public HttpServletResponse response;
	public HttpSession httpSession;
	public ServletContext httpApplication;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {

		this.application = application;
	}

	public void setServletRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
		httpSession = httpRequest.getSession();
	}

	public void setServletContext(ServletContext httpApplication) {
		this.httpApplication = httpApplication;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

}
