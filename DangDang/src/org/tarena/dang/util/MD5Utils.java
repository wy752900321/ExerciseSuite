package org.tarena.dang.util;

import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MD5Utils {
	public static String md5(String str) {
		try {
			// 首先利用MD5算法将密码加密,变成等长字节
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b1 = md.digest(str.getBytes());
			// 将等长字节利用Base64算法转换成字符串
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b1);
		} catch (Exception e) {
			return null;
		}
	}

	// BASE加密和解密
	public static void de(String base) {
		System.out.println(base);
		BASE64Encoder encoder = new BASE64Encoder();
		String bb = encoder.encode(base.getBytes());
		System.out.println(bb);
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b1 = decoder.decodeBuffer(bb);
			System.out.println(new String(b1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(md5("123"));
		System.out.println(md5("123adffdksldfakdjsk"));
	}
}
