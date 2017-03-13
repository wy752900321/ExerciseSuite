package com.tarena.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具，实现了cookie的添加、删除、
 * 查找功能。
 * @author tarena
 *
 */
public class CookieUtil {
	//缺省的生存时间
	private static int maxAge = 365 * 24 * 3600;
	private static String path = "/dang";
	
	/**
	 * 添加cookie
	 * @param name
	 * @param value
	 * @param age
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	public static void addCookie(String name,
			String value,int age,
			HttpServletResponse response) 
	throws UnsupportedEncodingException{
		Cookie c = new Cookie(name,
				URLEncoder.encode(value,"utf-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}
	
	public static void addCookie(String name,String value,
			HttpServletResponse response) throws UnsupportedEncodingException{
		addCookie(name,value,maxAge,response);
	}
	
	/**
	 * 依据cookie的名称返回cookie的值，
	 * 如果找不到，返回null。
	 * @param name
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String findCookie(String name,
			HttpServletRequest request) throws UnsupportedEncodingException{
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(int i=0;i<cookies.length;i++){
				Cookie curr = cookies[i];
				if(curr.getName().equals(name)){
					value = URLDecoder
					.decode(curr.getValue(),"utf-8");
					System.out.println("value: " + value);
				}
			}
		}
		return value;
	}
	
	/**
	 * 删除cookie
	 * @param name
	 * @param response
	 */
	public static void deleteCookie(String name,
			HttpServletResponse response){
		Cookie cookie = new Cookie(name,"");
		cookie.setMaxAge(0);
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	
}
