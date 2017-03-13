package com.tarena.web.action;

import java.io.InputStream;

import com.tarena.util.code.ValidateCode;

public class ImageCodeAction extends BaseAction {
	private InputStream is;

	public String execute() {
		try {
			is=new ValidateCode().getCode(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "imageCode";
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	
}
