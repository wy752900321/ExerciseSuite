<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.itcast.domain.Person"%>
<%@page import="cn.itcast.domain.Address"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>使用el获取数据</title>
  </head>
  
  <body>
    
    <% 
    	String data = "aaaa";
    	request.setAttribute("data",data);
    %>
    ${data }   
    
    <br/>
    
    <% 
    	Person p = new Person();
    	p.setName("xxx");
    	request.setAttribute("person",p);
    %>
    ${person.name }
    
    <br/>
    
    <% 
    	p = new Person();
    	Address a = new Address();
    	a.setCity("bj");
    	p.setAddress(a);
    	request.setAttribute("person",p);
    %>
    ${person.address.city }
    
    <br/>
    
    <% 
    	List list = new ArrayList();
    	list.add(new Person("aaa"));
    	list.add(new Person("bbb"));
    	list.add(new Person("ccc"));
    	request.setAttribute("list",list);
    %>
    ${list[1].name }
    
    <br/>
    
    <% 
    	Map map = new LinkedHashMap();
    	map.put("111",new Person("aaa"));
    	map.put("222",new Person("bbb1"));
    	map.put("333",new Person("ccc"));
    	request.setAttribute("map",map);
    %>
    
    ${map['222'].name }<br/>
    
    <c:forEach var="entry" items="${map}">
    	${entry.key }=${entry.value.name }<br/>
    </c:forEach>
		
	<ww:if></ww:if>

	
  </body>
</html>
