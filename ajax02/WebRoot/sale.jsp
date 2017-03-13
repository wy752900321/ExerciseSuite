<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<style>
			#d1{
				width:500px;
				height:180px;
				background-color:#fff8dc;
				border:1px solid red;
				margin-left:350px;
				margin-top:50px;
			}
		</style>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
			function getXmlHttpRequest()	{
				var xhr = null;
				if((typeof XMLHttpRequest)!='undefined'){
					xhr = new XMLHttpRequest();
				}else{
					xhr = new ActiveObject('Microsoft.XMLHttp');
				}
				return xhr;
			}
			function f1(){
				setInterval(f2,5000);
			}
			function f2(){
				var xhr = getXmlHttpRequest();
				xhr.open('post','saleinfo.do',true);
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xhr.onreadystatechange=function(){
					if(xhr.readyState==4){
						var txt = xhr.responseText;
						var sales = txt.evalJSON();
						var saleInfo = '当前销量最好的商品是：<br>';
						for(i=0;i<sales.length;i++){
							saleInfo +='商品名称:'+sales[i].name+'销量：'+sales[i].qty+'<br/>';
						}
						$('d1').innerHTML=saleInfo;
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size: 30px;" onload="f1();">
			<div id = "d1"></div>
	</body>
</html>