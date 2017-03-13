package com.tarena.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil implements Serializable {
	private static final long serialVersionUID = -8913945245316725643L;
	// 缺省的应用名
	private static String default_path = "/T-GWAP";
	// 缺省的生存时间
	private static int default_age = 365 * 24 * 3600;

	/**
	 * 添加一个cookie
	 * 
	 * @param name
	 * @param value
	 * @param response
	 * @param age
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookie(String name, String value,
			HttpServletResponse response, int age)
			throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setMaxAge(age);
		cookie.setPath(default_path);
		response.addCookie(cookie);
	}

	public static void addCookie(String name, String value,
			HttpServletResponse response) throws UnsupportedEncodingException {
		addCookie(name, value, response, default_age);
	}

	/**
	 * 依据cookie的名字，查找cookie的值，如果找不到，返回null。
	 * 
	 * @param name
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String findCookie(String name, HttpServletRequest request)
			throws UnsupportedEncodingException {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie curr = cookies[i];
				if (curr.getName().equals(name)) {
					value = URLDecoder.decode(curr.getValue(), "utf-8");
				}
			}
		}
		return value;
	}

	/**
	 * 删除cookie
	 * 
	 * @param name
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	public static void deleteCookie(String name, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		cookie.setPath(default_path);
		response.addCookie(cookie);
	}
}
