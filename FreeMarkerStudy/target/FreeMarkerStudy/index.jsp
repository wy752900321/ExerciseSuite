<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<html>
<body>
<%
    String mypath = "hello";
    response.sendRedirect(basePath + mypath);
%>
</body>
</html>  