package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.EmpDaoImpl;

@SuppressWarnings("serial")
public class SaveEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取name
		String name=request.getParameter("name");
		
		//实例化dao层对象
		EmpDaoImpl empDaoImpl=new EmpDaoImpl();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//保存
		empDaoImpl.saveEmp(name);
		
		//转发
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		
		//重定向
		//response.sendRedirect(request.getContextPath()+"/success.jsp");
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   this.doGet(request, response);
	}

}
