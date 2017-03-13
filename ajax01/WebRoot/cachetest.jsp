<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<script type="text/javascript" src="js/myjs.js">
		</script>
		<script type="text/javascript">
			function f1(){
				var xhr = getXhr();
				xhr.open('get','cache?' + Math.random(),true);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4){
						var txt = xhr.responseText;
						$('d1').innerHTML = txt;
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size:30px;">
		<a href="javascript:;" 
		onclick="f1();">点击这儿生成一个随机数</a>
		<div id="d1"></div>
	</body>
</html>