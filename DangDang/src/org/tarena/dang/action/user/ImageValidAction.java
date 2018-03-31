package org.tarena.dang.action.user;

import java.util.Map;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionContext;
public class ImageValidAction {
	private Logger log = Logger.getLogger(this.getClass());
	private String code;// 接收用户输入的code
	private boolean se = false;// 用于json输出

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String scode = (String) session.get("code");
		log.warn("ImageValidAction中，验证码与输入的验证对比用户输入的－>" + code);
		log.warn("生成的输入的->:" + scode);

		if (code.equals(scode)) {
			se = true;
		} else {
			se = false;
		}
		return "success";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSe() {
		return se;
	}

	public void setSe(boolean se) {
		this.se = se;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

}
