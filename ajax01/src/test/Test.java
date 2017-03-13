package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {
	/**
	 * 		Êä³ö£º%E5%B0%8F%E5%BC%A0

	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "Ð¡ÕÅ";
		String str2 = URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
	}
}
