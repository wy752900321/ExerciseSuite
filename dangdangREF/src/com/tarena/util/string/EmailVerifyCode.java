package com.tarena.util.string;

import java.util.UUID;

//生成邮箱验证码
public class EmailVerifyCode {

	public static String createEmailVerifyCode(){
		return UUID.randomUUID().toString();
	}
}
