<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'upload.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/UploadServlet2">
    	用户名：<input type="text" name="username"><br/>
    	上传文件1：<input type="file" name="file1"><br/>
    	上传文件2：<input type="file" name="file2"><br/>
    	<input type="submit" value="上传">
    </form>
    
  </body>
</html>
