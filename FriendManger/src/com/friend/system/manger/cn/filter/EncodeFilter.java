package com.friend.system.manger.cn.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.system.manger.cn.util.GenericFilter;

public class EncodeFilter extends GenericFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding(getFilterConfig().getInitParameter("request"));
		filterChain.doFilter(request, response);
	}

}
