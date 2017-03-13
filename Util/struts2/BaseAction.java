package control;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements SessionAware,RequestAware,ApplicationAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
	protected Map<String,Object> session;
	protected Map<String,Object> request;
	protected Map<String,Object> application;
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse response;
	protected ServletContext httpApplication;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setRequest(Map<String, Object> request) {
			this.request = request;
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}
	public void setServletRequest(HttpServletRequest httpRequest) {
			this.httpRequest = httpRequest;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	public void setServletContext(ServletContext httpApplication) {
		this.httpApplication = httpApplication;
		
	}

}
