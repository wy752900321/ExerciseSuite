package com.tarena.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {

	private String pattern;
	private Long time;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public void doTag() throws JspException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Date date=new Date(time);
		String str=sdf.format(date);
		JspContext jspContext=getJspContext();
		JspWriter out=jspContext.getOut();
		out.println(str);
	}
}
