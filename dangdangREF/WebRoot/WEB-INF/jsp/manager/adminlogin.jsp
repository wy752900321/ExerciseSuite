<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <table width="900" border="1" cellspacing="0" cellpadding="0" bordercolor="#006699" style="border-collapse:collapse">
    <tr>
      <td height="96">
         <form action="adminServlet?action=login" method="post">
                <table width="40%">             
                   <tr>  
                        <td>用户：</td>
                        <td><input type="text" name="username"/></td>
                   </tr>
                   <tr>  
                        <td>密码：</td>
                        <td><input type="password" name="password" /></td>
                   </tr>
                   <tr>
                      <td colspan="2" ><input type="button" value="登录" ></td>
                   </tr>
             </table>
		  </form>	  
	  </td>
    </tr>
  </table>
     
  </body>
</html>
