package com.tarena.util.string;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Md5 {

	// MD5加密
	public static String encode(String str) {
		String string = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] dest = md.digest(str.getBytes());
			BASE64Encoder base = new BASE64Encoder();
			string = base.encode(dest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return string;
	}

	// 解密
	public static String decode(String str) {
		String string = null;
		try {
			/*MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] dest=md.digest(str.getBytes());*/
			BASE64Decoder base = new BASE64Decoder();
			byte[] dest=base.decodeBuffer(str);
			string=dest.toString();
			//base.decodeBufferToByteBuffer(dest.toString());
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}

	/*public static void main(String[] args) {
		System.out.println(Md5.encode("123"));//ICy5YqxZB1uWSwcVLSNLcA==
		System.out.println(Md5.decode("123"));
		System.out.println(Md5.decode("ICy5YqxZB1uWSwcVLSNLcA=="));
	}*/
}
