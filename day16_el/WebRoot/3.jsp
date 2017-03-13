<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>获取常用对象</title>
  </head>
  
  <body>
    ${pageContext.request.contextPath }
    
    
    <% 
    	pageContext.setAttribute("name","xxx");  //map
    %>
    ${pageScope.name }
    ${name }
    ${sessionScope.user==null }
    
    <br/>
    
    ${param.like }
    ${paramValues.like[0] }
    ${paramValues.like[1] }
    
    <br/>
    ${header.Host }
    ${header['Accept-Encoding'] }
    
    <br/>
    ${cookie.JSESSIONID.name }=${cookie.JSESSIONID.value }
    
    <br/>
    ${initParam.root }
    
    <br/>
  </body>
</html>
