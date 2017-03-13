package org.tarena.dang.util;

public class EmailUtils {
	public static int sendEmail(String code, String email) {
		System.out.println("给" + email + "发送了邮箱验证码");
		System.out.println("验证码为：" + code);
		// 邮件发送
		return Constant.EXECUTE_OK;
	}
}
