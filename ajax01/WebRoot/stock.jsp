<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<style>
			#d1{
				width:400px;
				height:200px;
				border:1px solid red;
				margin:40px auto;
				font-size:24px;
			}
			
		</style>
		<script type="text/javascript" src="js/myjs.js"></script>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
			function f1(){
				setInterval(f2,5000);
			}
			function f2(){
				var xhr = getXhr();
				xhr.open('post','quoto',true);
				xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
				xhr.onreadystatechange=function(){
					if(xhr.readyState==4){
					var txt = xhr.responseText;
					/*evalJSON()：将json字符串转换成一个javascriopt对象*/
					var stock = txt.evalJSON();
					$('d1').innerHTML='股票代码：'+stock.stockCode+'股票价格:'+stock.price;
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size: 30px;" onload="f1();">
			<div id="d1"></div>
	</body>
</html>