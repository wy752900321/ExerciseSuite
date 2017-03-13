package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import bean.Stock;

public class QuotoServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("service...");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//模拟生成一支股票的信息
		Stock s = new Stock();
		Random r  = new Random();
		String stockCode = "深发展"+r.nextInt(99);
		double price = r.nextInt(999);
		s.setStockCode(stockCode);
		s.setPrice(price);
		//将stock对象转换成json字符串
		JSONObject obj = JSONObject.fromObject(s);
		String str = obj.toString();
		System.out.println(str);
		out.println(str);
		out.close();
	
	}

}
