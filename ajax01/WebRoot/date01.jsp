<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/myjs.js"></script>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
	function f1() {
		var xhr = getXhr();
		xhr.open('post', 'personInfo', true);
		xhr.setRequestHeader('content-type',
				'application/x-www-form-urlencoded');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var txt = xhr.responseText;
				var person = txt.evalJSON();
				$('d1').innerHTML = ' 姓名:' + person.name + ' 生日:'
						+ person.birthday;
			}
		};
		xhr.send(null);
	}
</script>
	</head>
	<body style="font-size: 30px;">
		<a href="javascript:;" onclick="f1();">点击这儿，显示一个用户的信息</a>
		<div id="d1"></div>
	</body>
</html>