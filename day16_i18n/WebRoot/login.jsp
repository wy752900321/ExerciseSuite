<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>

  <body>
  	<% 
  		String language = request.getParameter("language");
  		if(language==null){
  			language = "zh";
  		}
  		Locale l = new Locale(language);
  		ResourceBundle rb = ResourceBundle.getBundle("cn.itcast.resource.MyResource",l);
  	%>
  
  	<a href="${pageContext.request.contextPath }/login.jsp?language=zh"><%=Locale.CHINA.getDisplayCountry() %></a>
  	<a href="${pageContext.request.contextPath }/login.jsp?language=en"><%=Locale.US.getDisplayLanguage() %></a>
  
   	<form action="">
   		<%=rb.getString("username") %><input type="text" name="username"><br/>
   		<%=rb.getString("password") %><input type="password" name="password"><br/>
   		<input type="submit" value="<%=rb.getString("submit") %>">
   	</form>
  </body>
</html>
