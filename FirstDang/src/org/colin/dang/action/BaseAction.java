package org.colin.dang.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements
  ServletRequestAware,SessionAware,RequestAware{
  protected  HttpServletRequest httpRequest;
  
  protected Map<String,Object> session;
  protected Map<String,Object> request;
	public void setServletRequest(HttpServletRequest arg0) {
	this.httpRequest=arg0;
		
	}

	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
		
	}

	

}
