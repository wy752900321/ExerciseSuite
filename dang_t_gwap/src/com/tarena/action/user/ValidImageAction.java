package com.tarena.action.user;

/**
 * 关联register_form.jsp的验证码
 * 
 * @author soft01
 * 
 */
public class ValidImageAction extends ImageAction {
	private static final long serialVersionUID = 4032029373319826486L;
	// 负责获取用户输入的验证码
	private String code;
	// 检查此验证码是否可用
	private boolean ok = false;

	public String execute() {
		// 从session中读取验证码
		String scode = (String) session.get("code");
		// 如果用户输入的code和从session中读取的scode相同,则返回true
		if (code.equalsIgnoreCase(scode)) {
			ok = true;
		} else {
			// 如果不同，返回false
			ok = false;
		}
		// 返回ajax请求的json对象的值
		return "success";
	}

	// getter and setter
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

}
