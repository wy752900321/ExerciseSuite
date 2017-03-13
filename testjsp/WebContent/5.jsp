<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>sun的el函数</title>
  </head>
  
  <body>
    
    ${fn:toLowerCase("AAA") }
    
    <br/>
    
    <% 
    	List list = new ArrayList();
    	list.add("aaa");
    	list.add("bbb");
    	list.add("ccc");
    	request.setAttribute("list",list);
    %>
    <c:forEach var="i" begin="0" end="${fn:length(list) }">
    	${list[i] }
    </c:forEach>
    
    <br/>
    
    ${fn:join(fn:split("www,sina,com",","),".")}
    
    <br/>

	${fn:escapeXml("<a href=''>点点</a>") }   
  </body>
</html>
