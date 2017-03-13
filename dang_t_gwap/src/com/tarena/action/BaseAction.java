package com.tarena.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 此类为监听request,response,application,session的工具类
 * 
 * @author soft01
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletContextAware, ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = -554583609096466206L;
	// session对象，用于绑定对象
	protected Map<String, Object> session;
	protected ServletContext application;
	// request对象，用于监听需求
	protected HttpServletRequest request;
	// response对象，用于监听响应
	protected HttpServletResponse response;

	// setter 设置监听对象的值
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
