<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix = "s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" 
			src="../js/jquery-1.4.3.js">
		</script>
		<script type="text/javascript">
		var emailpass=false;
		 $(function(){
		 $("#txtUsername").blur(function(){
		   emailpass=false;
		  $("#username\\.info").html("");
		  var usernameTxt=$(this).val();
		  var password=$("#txtPassword").val();
		  if(usernameTxt==""){
		  $("#username\\.info").html("错误");
		  return;
		  }
		   var pattern=/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
		    if(!pattern.test(usernameTxt)) {
		        $("#username\\.info").html("格式错误");
		        return;
		      } else {
		        //$("#username\\.info").html("email格式正确");
		        emailpass=true;
		      }
		      
		 });
		 });
		 	  $(function(){
				  $("#ctl00").submit(
				  function(){
				 if(emailpass){
				 return true;
				 }else{
				 alert("表单数据为通过验证");
				 return false;
				 }
				  }
				  );
				  });
		</script>
		

	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="login" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="email" id="txtUsername" class="textbox" />
									<span id="username.info" style="color:red"></span>
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword"
										class="textbox" />
										<span id="pwd.info" style="color:red"></span>
								</li>
								<li>
								<s:actionerror></s:actionerror>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />


								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

