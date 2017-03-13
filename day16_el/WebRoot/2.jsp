<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el运算符</title>
  </head>
  
  <body>
    
    <% 
    	request.setAttribute("gender","女");
    %>
    
    <input type="radio" name="gender" value="男" ${gender=='男'?'checked':'' }>男
    <input type="radio" name="gender" value="女" ${gender=='女'?'checked':'' }>女
    
    
    
    <% 
    	String pres[] = {"看凤姐","蓝球"};  //"看凤姐,打球"
    	request.setAttribute("pres",pres);
    %>
    
    <input type="checkbox" name="pre" value="看凤姐" ${fn:contains(fn:join(pres,","),'看凤姐')?'checked':'' }>看凤姐
    <input type="checkbox" name="pre" value="足球" ${fn:contains(fn:join(pres,","),'足球')?'checked':'' }>足球
    <input type="checkbox" name="pre" value="蓝球" ${fn:contains(fn:join(pres,","),'蓝球')?'checked':'' }>蓝球
    <input type="checkbox" name="pre" value="棒球" ${fn:contains(fn:join(pres,","),'棒球')?'checked':'' }>棒球
    <input type="checkbox" name="pre" value="打球" ${fn:contains(fn:join(pres,","),'打球')?'checked':'' }>打球
  </body>
</html>
