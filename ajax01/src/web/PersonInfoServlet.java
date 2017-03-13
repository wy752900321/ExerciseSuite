package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.DateProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import bean.Person;

@SuppressWarnings("serial")
public class PersonInfoServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PersonInfoServlet->service.......");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Person p = new Person();
		p.setName("zs");
		p.setBirthday(new Date());
		 	//	step2,注册这个转换器类
		JsonConfig config = new JsonConfig();//创建JsonConfig对象
		DateProcessor processor = new DateProcessor();
		processor.setPattern("yyyy/MM/dd");
		//告诉Json，用什么格式
		config.registerJsonValueProcessor(Date.class, processor);//注册一个转换器
		JSONObject obj = JSONObject.fromObject(p, config);
		String str = obj.toString();
		out.println(str);
		out.close();
		
	}

}
