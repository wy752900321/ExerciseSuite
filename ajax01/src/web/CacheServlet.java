package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			System.out.println("service.......");
			Random rd = new Random();
			int a = rd.nextInt(999);
			out.println("Ëæ»úÊýÊÇ£º"+a);
			out.close();
	}

}
