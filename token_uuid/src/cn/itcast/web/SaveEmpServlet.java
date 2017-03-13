package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.itcast.util.UUIDToken;
import cn.itcast.dao.impl.EmpDaoImpl;

@SuppressWarnings("serial")
public class SaveEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取name
		String name=request.getParameter("name");
		HttpSession session=request.getSession();


		//检测隐藏域的值和session中存放的值是否相等
		boolean flag=UUIDToken.getUuidToken().isValidateToken(request);
        
		//如果相等,保存到数据库
		if(flag){		
			//实例化dao层对象
			EmpDaoImpl empDaoImpl=new EmpDaoImpl();
			//保存
			empDaoImpl.saveEmp(name);
		
			//删除session中存放的信息
			UUIDToken.getUuidToken().resetUUIDToken(request);
       	
           //转发
   		   request.getRequestDispatcher("/success.jsp").forward(request, response);
        }else{
        	System.out.println("表单重复提交了");
        }
	
//		//重定向
//		//response.sendRedirect(request.getContextPath()+"/success.jsp");
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   this.doGet(request, response);
	}

}
