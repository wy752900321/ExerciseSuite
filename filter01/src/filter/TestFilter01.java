package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 单实例,多线程运行,同servlet相同
 */
public class TestFilter01 implements Filter {

	public TestFilter01(){
		System.out.println("TestFilter01 的构造方法");
	}
	
	/**
	 * 1 初始化方法.该方法在服务器启动时执行,在过滤器的生命周期中执行1次
	 *   * 该方法由servlet容器调用
	 *   * FilterConfig,该接口的对象有servlet容器创建,传递给init方法的形参
	 *     保存过滤器的配置信息
	 */
	public void init(FilterConfig fiterConfig) throws ServletException {
		System.out.println("TestFilter01 init方法");
		/*
		 *   <filter>
			    <!-- 注册的过滤器的名称,在后面配置过滤器的映射中要使用该名称 -->
			    <filter-name>TestFilter01</filter-name>
			    <!-- 配置过滤器的完整的路径名-->
			    <filter-class>cn.itcast.filter.TestFilter01</filter-class>
			  </filter>
		 */
		//获取的是注册的filter名称
		String filterName=fiterConfig.getFilterName();
		System.out.println("filterName "+filterName);
		
		
		/*
		 * <filter>
			    <!-- 注册的过滤器的名称,在后面配置过滤器的映射中要使用该名称 -->
			    <filter-name>TestFilter01</filter-name>
			    <!-- 配置过滤器的完整的路径名-->
			    <filter-class>cn.itcast.filter.TestFilter01</filter-class>
			    <init-param>
			       <param-name>book</param-name>
			       <param-value>笑傲江湖</param-value>
			    </init-param>
			    <init-param>
			       <param-name>image</param-name>
			       <param-value>美女图</param-value>
			    </init-param>
			  </filter>
		 */
		String book=fiterConfig.getInitParameter("book");
     	System.out.println("book  "+book);
     	
     	String image=fiterConfig.getInitParameter("image");
     	System.out.println("image  "+image);	
		
     	
     	java.util.Enumeration<String> em=fiterConfig.getInitParameterNames();
     	while(em.hasMoreElements()){
     		String name=em.nextElement();
     		System.out.println(name+"   "+fiterConfig.getInitParameter(name));
     	}
     	
		/*
		 * <context-param>
		    <param-name>cba</param-name>
		    <param-value>东北虎队</param-value>
		  </context-param>
		 */
     	
     	ServletContext sc=fiterConfig.getServletContext();
     	String cba=sc.getInitParameter("cba");
     	System.out.println("cba  "+cba);
	}
	
	/**
	 * 2 处理请求的方法,在客户端发送请求时执行,在过滤器的生命周期中执行n次
	 *  * 该方法由servlet容器调用
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		    System.out.println("TestFilter01 doFilter方法");
		
		    HttpServletRequest request=(HttpServletRequest)req;
		    HttpServletResponse response=(HttpServletResponse)res;
		    
		    System.out.println(request.getRequestURI());
		    System.out.println(request.getRequestURL());
		    System.out.println("request.getServletPath()  "+request.getServletPath());
		    System.out.println("request.getContextPath()  "+request.getContextPath());

		    /*
		     * FilterChain接口：代表当前 Filter 链的对象。由容器实现，容器将其实例作为参数传入过滤器对象的doFilter()方法中
		     */
		    //放行
		    chain.doFilter(request, response);
		
		
	}
	
	/**
	 * 3 销往的方法  在过滤器的生命周期中执行1次
	 *  * 该方法由servlet容器调用
	 *   
	 */
	public void destroy() {
		System.out.println("TestFilter01 destroy方法");
	}
}
