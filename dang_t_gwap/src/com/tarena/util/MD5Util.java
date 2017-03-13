package com.tarena.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 
 * @author soft01
 * 
 */
public class MD5Util implements Serializable {
	private static final long serialVersionUID = -7566683327563313787L;

	public static String md5(String str) throws NoSuchAlgorithmException {
		byte[] buf = str.getBytes();
		// MD5处理
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(buf);
		byte[] data = md.digest();
		// 输出前的处理
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			builder.append(Integer.toHexString(data[i] & 0xff));
			if ((data[i] & 0xff) <= 0xf) {
				builder.append("0");
			}
		}
		return builder.toString();
	}

	// public static void main(String[] args) throws NoSuchAlgorithmException {
	// System.out.println(md5("123456"));
	// }
}
