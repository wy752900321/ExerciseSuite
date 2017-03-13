package cn.itcast.web.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// 获取要调用方法的名称（反射）
			String methodName = request.getParameter("method");

			// 获取方法的参数类型
			Class parameterTypes[] = { HttpServletRequest.class,
					HttpServletResponse.class };

			// 获取要调用 的方法的封装类型
			Method method = this.getClass().getMethod(methodName,
					parameterTypes);

			// 方法的参数
			Object[] args = { request, response };

			// 调用真正的方法
			method.invoke(this, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
