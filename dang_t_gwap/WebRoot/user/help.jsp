<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="refresh" content="5;URL=../main/main.jsp" />
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript">
var i = 5;

function load() {
	if (i == 0) {
	} else {
		document.getElementById("show").innerHTML = i+"秒";
		setTimeout('load()', 1000);
		i--;
	}
}
</script>
	</head>
	<body onload="load()">
		<%@include file="../common/head1.jsp"%>
		<div>
			<div>
			<p style="height: 30px;"></p>
			</div>
				<div align="center">
					<h1>
						对不起!本功能尚未开放 !
					</h1>
					<h2>
						请等待
						<span id="show" style="color: red; font-size: 20px;" />
					</h2>
					<h2>
						五秒后将返回&nbsp;&nbsp;
						<a href=../main/main.jsp title="回到首页">首页</a>
						<br />
						如果你对本网站有任何疑问。
						<br />
						请联系管理员，电话：15010895081
					</h2>
				</div>
				<div>
			<p style="height: 120px;"></p>
			</div>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

