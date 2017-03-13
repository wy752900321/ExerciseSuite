package com.tarena.web.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
//ServletContextAware
public class BaseAction extends ActionSupport implements SessionAware
		 {

	protected Map<String, Object> session;

	//protected ServletContext application;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/*public void setServletContext(ServletContext application) {
		this.application = application;
	}
	
	public void getReal(){
		this.application.getRealPath(arg0)
	}*/

}
