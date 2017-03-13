package com.friend.system.manger.cn.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.system.manger.cn.util.CheckUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 3318158435045110121L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String check = CheckUtil.getCheckCode();
		BufferedImage image = CheckUtil.getCheckImage(check);
		request.getSession().setAttribute("check", check);
		JPEGCodec.createJPEGEncoder(response.getOutputStream()).encode(image);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
