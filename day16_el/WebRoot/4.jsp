<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.domain.User"%>
<%@taglib uri="/myel" prefix="flx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el函数</title>
  </head>
  
  <body>
  
  <% 
  	request.getParameter("username");
  	System.out.println("haha");
  %>
  
    ${flx:join("aa","bbb") }
    
    <% 
    	User user = new User();
    	user.setUsername("aaa");
    	session.setAttribute("user",user);
    %>
    
    ${sessionScope.user!=null?flx:join('欢迎您：',user.username):'对不起，您没有登陆' }
    
  </body>
</html>
