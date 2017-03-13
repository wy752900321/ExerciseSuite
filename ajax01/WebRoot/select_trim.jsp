<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
			function selectAll(){
				var arr = $('c1','c2','c3');
				for(i=0;i<arr.length;i++){
					arr[i].checked=true;
				}
			}
			/*strip()去两端空格*/
			function f1(){
				alert($F('username').strip().length);
			}
		</script>
	</head>
	<body style="font-size: 30px;">
				兴趣爱好:
		cooking<input type="checkbox" name="interest"  id="c1" value="cooking"/>
		swimming<input type="checkbox" name="interest" id="c2" value="swimming"/>
		football<input type="checkbox" name="interest" id="c3" value="football"/>
		<input type="button" value="全选" onclick="selectAll();"/><br/>
		username:<input name="username" id="username"/>
		<input type="button" value="Click" onclick="f1();"/>
	</body>
</html>