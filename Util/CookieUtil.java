package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
		//缺省值
		public static int maxAge = 365 * 24 * 3600;
		public static String path = "/friend";
		//添加Cookie
		public static Cookie addCookie(String name,String value,int age,HttpServletResponse response) throws UnsupportedEncodingException{
			Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
			c.setMaxAge(age);
			c.setPath(path);
			return c;
		}
		public static Cookie addCookie(String name,String value,HttpServletResponse response) throws UnsupportedEncodingException{
			return addCookie(name, value, maxAge, response);
		}
		//获得Cookie
		public String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException{
			String value = null;
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for(int i=0;i<cookies.length;i++){
					Cookie curr = cookies[i];
					if(curr.getName().equals(name)){
						value = URLDecoder.decode(curr.getValue(),"utf-8");
					}
				}
			}
			return value;
		}
		//删除Cookie
		public static void deleteCookie(String name,HttpServletResponse response) throws UnsupportedEncodingException{
			Cookie cookie = addCookie(name,"",0,response);
			response.addCookie(cookie);
		}
}
