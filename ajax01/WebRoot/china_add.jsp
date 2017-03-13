<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body style="font-size: 30px;">
		 <!-- 
		 	如果连接地址包含了中文，如何处理？
			浏览器都 会对连接地址中的中文进行编码（一定会采用utf-8进行编码）				
			解决方式:可以通过修改tomcat_home/conf/server.xml文件，添加"URIEncoding="utf-8"
			如下：
				<Connector port="8080" protocol="HTTP/1.1" 
               connectionTimeout="20000" 
         redirectPort="8443" URIEncoding="utf-8"/>
		  -->
			<a href="你好.jsp">连接到中文的地址</a>
	</body>
</html>