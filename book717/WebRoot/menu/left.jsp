<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
 <title>菜单</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}//menu/css/jquery.treeview.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/menu/css/screen.css" />
 <script src="${pageContext.request.contextPath}/menu/js/jquery-1.4.2.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/menu/js/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
	$( function() {
		$("#tree").treeview( {
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});
	})
</script>

</head>
<body  ondblclick="ToggleNav();">
<div id="main">
<div id="sidetree">
<div class="treeheader">操作菜单</div>
  
	<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
		<ul id="tree">
				    <li><img src="${pageContext.request.contextPath}//menu/images/spzl.png" width="17" height="17">
				    <strong>分类管理</strong>
					<ul>
						           <li><img src="${pageContext.request.contextPath}//menu/images/splb.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/category/add.jsp" target="rightFrame">添加分类</a></li>
						           <li><img src="${pageContext.request.contextPath}//menu/images/lxrlb.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/categoryServlet?method=list" target="rightFrame">查看分类</a></li>
					</ul>
				 </li>
				    <li><img src="${pageContext.request.contextPath}//menu/images/xtsz.png" width="17" height="17">
				    <strong>图书管理</strong>
					<ul>     
						           <li><img src="${pageContext.request.contextPath}//menu/images/bmsz.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/bookServlet?method=add" target="rightFrame">添加图书</a></li>
						           <li><img src="${pageContext.request.contextPath}//menu/images/rsgl.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/bookServlet?method=list" target="rightFrame">查看图书</a></li>
					</ul>
				 </li>

				    <li><img src="${pageContext.request.contextPath}/menu/images/xsgl.png" width="17" height="17">
				    <strong>订单管理</strong>					
					<ul>
						           <li><img src="${pageContext.request.contextPath}//menu/images/khflfx.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/order/listorder.jsp" target="rightFrame">待处理订单</a></li>
						           <li><img src="${pageContext.request.contextPath}/menu/images/khgjfx.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/manager/order/listorder.jsp" target="rightFrame">以发货订单</a></li>
					</ul>
				 </li>
				 
				  <li><img src="${pageContext.request.contextPath}//menu/images/xtsz.png" width="17" height="17">
				    <strong>数据库管理</strong>					
					<ul>
						           <li><img src="${pageContext.request.contextPath}//menu/images/sjbf.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/report/khflfx.jsp" target="rightFrame">数据库的备份</a></li>
						           <li><img src="${pageContext.request.contextPath}//menu/images/sjhy.png" width="17" height="17">
						           <a href="${pageContext.request.contextPath}/report/khflfx.jsp" target="rightFrame">数据库的还原</a></li>
					</ul>
				 </li>
		</ul>
	</div>
</div>
<div id="divCollapsedNav" class="navTocColor" style="display:none;width:100%;height:100%;"> 
  <a href="javascript:ToggleNav();" title="展开导航框架" id="linkNavClosed">
      <img src="${pageContext.request.contextPath}//menu/images/toc2.gif" alt="展开导航框架" border="3"></img>
  </a>
</div>
<script src="${pageContext.request.contextPath}//menu/js/left.js"></script>
</body>
</html>

