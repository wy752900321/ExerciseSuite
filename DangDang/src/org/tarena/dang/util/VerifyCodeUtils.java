package org.tarena.dang.util;

import java.util.UUID;

/**
 * 邮箱验证码工具类
 * 
 * @author Administrator
 * 
 */
public class VerifyCodeUtils {
	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String generateCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 获取邮箱验证码的UUID部分
	 * 
	 * @param input
	 * @return
	 */
	public static String getUUID(String input) {
		if (input == null)
			return null;
		if (input.lastIndexOf("_") < 0)
			return null;
		return input.substring(0, input.lastIndexOf("_"));
	}

	/**
	 * 获取用户ID
	 * 
	 * @param input
	 * @return
	 */
	public static Integer getUserId(String input) {
		if (input == null)
			return null;
		if (input.lastIndexOf("_") < 0)
			return null;
		return Integer.valueOf(input.substring(input.lastIndexOf("_") + 1));
	}

	public static void main(String[] args) {
		System.out.println(generateCode());
		System.out.println(generateCode());
	}
}
