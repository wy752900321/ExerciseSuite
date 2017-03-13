<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@page isELIgnored="false"%>
<html>
	<head>
		<script type="text/javascript" language="javascript" src="js/login.js">
	
</script>
		<script>
	function check_age() {
		//var xhr=getXMLHttpRequest();
		//alert(xhr);
		var check_age = $('age');
		check_age.value = '';
	}
	function $(id) {
		return document.getElementById(id);
	}
	function $F(id) {
		return $(id).value;
	}

	function getXMLHttpRequest() {
		var xhr = null;
		if (window.XMLHttpRequest) {
			//not IE
			xhr = new XMLHttpRequest();
		} else {
			//IE
			xhr = new ActionObject('Microsoft.XMLHttp');
		}
		return xhr;
	}
</script>

	</head>

	<body>

		<form action="<%=response.encodeRedirectURL("fd")%>">
			username:
			<input name="username" id="username" onblur="check_username();" />
			<span id="username_msg"></span>
			<br />
			password:
			<input name="pwd" id="pwd" onblur="check_pwd();" />
			<span id="pwd_msg"></span>
			<br />
			age:
			<input type="text" id="age" name="age" value="请输入年龄"
				onblur="check_age();" />
			<br />
			<input type="submit" value="ok" />
		</form>
	</body>
</html>
