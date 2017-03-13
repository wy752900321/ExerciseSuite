<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<style>
			.tips{
				color:red;
				font-style:italic;
			}
		</style>
		<script type="text/javascript" src="js/myjs.js"></script>
		<script type="text/javascript">
			function check_username(){
				//step1 获得XMLHttpRequest对象
				var xhr = getXhr();
				//step2 发送请求
				var url = 'check_username.do?username=' 
				+ $F('username');
				xhr.open('get',encodeURI(url),true);
				//注册监听器
				xhr.onreadystatechange=function(){
					//处理服务器返回的数据
					if(xhr.readyState == 4){
						//xhr的状态值必须是4,才能正确接收
						//到服务器返回的数据。
						if(xhr.status == 200){
							//ok
							var txt = xhr.responseText;
							//dom操作：更新页面
							$('username_msg').innerHTML = txt;
						}else{
							//error
							$('username_msg').innerHTML = '系统出错';
						}
					}else{
						//如果readyState的值不等于4,说明
						//xhr对象正在与服务器进行交互,
						//提示用户正在验证
						$('username_msg').innerHTML='正在验证...';
					}
					
				};
				//发送请求
				xhr.send(null);
			}
			
			function check_code(){
				var xhr = getXhr();
				xhr.open('get','check_number.do?number='
				 + $F('number'),true);
				 xhr.onreadystatechange=function(){
				 	if(xhr.readyState == 4){
				 		var txt = xhr.responseText;
				 		$('check_msg').innerHTML = txt;
				 	}
				 };
				 xhr.send(null);
			}
			
			function check_username2(){
				var xhr = getXhr();
				xhr.open('post','check_username.do',true);
				xhr.setRequestHeader('content-type',
		'application/x-www-form-urlencoded');
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4){
						var txt = xhr.responseText;
						$('username_msg').innerHTML = txt;
					}
				};
				xhr.send('username=' + $F('username'));
			}
		</script>
	</head>
	<body style="font-size:30px;">
		<form action="" method="post">
			用户名:<input id="username" name="username" 
			onblur="check_username2();"/>
			<span id="username_msg" class="tips"></span><br/>
			密码:<input type="password" name="pwd"/><br/>
			验证码:<input type="text" 
			id="number" name="number"
			onblur="check_code();"/>
			<span class="tips" id="check_msg"></span>
			<br/>
			<img src="checkcode" id="img1"/>
			<a href="javascript:;" 
			onclick="document.getElementById('img1').src='checkcode?' + Math.random();">换一个</a><br/>
			
			<input type="submit" value="确定"/>
		</form>
	</body>
</html>