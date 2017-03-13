package cn.com.webwork;

import com.opensymphony.xwork.Action;

public class HelloWorldAction implements Action {
	
	String geeting;
	
	public String getGeeting() {
		return geeting;
	}

	

	public String execute() throws Exception {
		geeting = "Hello World!";
		return SUCCESS;
	}

}
