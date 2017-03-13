package com.friend.system.manger.cn.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.util.GenericFilter;

public class Centain extends GenericFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		User user =(User)request.getSession().getAttribute("user");
		if(user!=null){
			filterChain.doFilter(request, response);
		}
		else{
			response.sendRedirect("");
		}
	}

}
