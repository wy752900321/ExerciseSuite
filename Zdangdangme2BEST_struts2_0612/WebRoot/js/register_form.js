	//表示表单各项是否通过检查,
	//通过检查设置为true,否则设置为false
	var checkflag = {
		"email" : false,
		"nickname" : false,
		"password" : false
	};

	$(function() {

		//Email检查
		$("#txtEmail")
				.blur(function() {
					checkflag.email = false;
					var email = $("#txtEmail").val();
					$("#email\\.info").html("");
					if (email == "") {//非空检查
							$("#email\\.info").html("邮箱不能为空");
						} else {//email格式检查
							var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
							if (!pattern.test(email)) {
								$("#email\\.info").html("邮箱格式错误");
							} else {//唯一性检查
								//发送ajax请求
								$.post("validEmail.action", {
									"email" : email
								}, function(ok) {
									if (ok) {
										checkflag.email = true;
										$("#email\\.info").html("<img src='../images/right.gif'/>");
									} else {
										$("#email\\.info").html("<img src='../images/wrong.gif'/>");
									}
								});
							}
						}
					});
	});
	//昵称:		您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符，一个汉字为两个字符。
	$(function() {
		$("#txtNickName").blur(function() {
			checkflag.nickname = false;
			var nickname = $("#txtNickName").val();
			$("#name\\.info").html("");//清空
				if (nickname == "") {//非空检查 
					$("#name\\.info").html("妮称不能为空");
				} else {//nickname格式检查
					//alert("VVVV");
					var patt = /^([\u4E00-\u9FA5]|[a-z0-9]{2}){2,10}$/; 
					if (!patt.test(nickname)) {
						$("#name\\.info").html("妮称格式错误");
					} else {//唯一性检查
						//发送ajax请求
						//因为异步方式，在运行慢的情况可能出现function(go)未被执行时，下面的程序已经执行，导致false参
						//数没有改过来。用$.ajac改成同步方式，只有function(ok){}执行后，其它程序才可以运行 
						$.ajax({
							url:"validNickName.action",
							async:false,
							data:{"nickname":nickname},
							success:function(go){
								if (go) {
								checkflag.nickname = true;
								$("#name\\.info").html("<img src='../images/right.gif'/>");
							} else {
								$("#name\\.info").html("<img src='../images/wrong.gif'/>");
							}
							}
						});
						/*$.post("validNickName.action", {
							"nickname" : nickname
						}, function(go) {
							if (go) {
								checkflag.nickname = true;
								$("#name\\.info").html("妮 称可以使用");
							} else {
								$("#name\\.info").html("妮称不可用");
							}
						});*/
					}
				}
			});
	});
		//设置密码：您的密码可以由大小写英文字母、数字组成，长度6－20位。
	$(function() {
		$("#txtPassword").blur(function() {
			checkflag.password = false;
			var password = $("#txtPassword").val();
			$("#password\\.info").html("");//清空
				if (password == "") {//非空检查 
					$("#password\\.info").html("密码不能为空");
				} else {//格式检查
					var pattern2=/^[A-Za-z0-9]{6,20}$/;
					if (!pattern2.test(password)) {
						$("#password\\.info").html("密码格式错误");
					} else {//唯一性检查
						//发送ajax请求
						$.post("validPassword.action", {
							"password" : password
						}, function(se) {
							if (se) {
								checkflag.password = true;
								$("#password\\.info").html("<img src='../images/right.gif'/>");
							} else {
								$("#password\\.info").html("<img src='../images/wrong.gif'/>");
							}
						});
					}
				}
			});
	});
	//再次设置您的密码：
	$(function() {
		$("#txtRepeatPass").blur(function() {
		//alert("password..");
			var password1 = $("#txtRepeatPass").val();
			var password = $("#txtPassword").val();
			$("#password1\\.info").html("");//清空
				if (password1 == "") {//非空检查 
					$("#password1\\.info").html("请确认密码从新输入");
				} else {
						if(password1!=password){
							$("#password1\\.info").html("请确认密码");
						}else{
						$("#password1\\.info").html("<img src='../images/right.gif'/>");
						}
				}
			});
	});

	$(function() {
		$("#noSee").click(
				function() {
					$("#imgVcode").attr(
							"src",
							"${pageContext.request.contextPath}/image.action?dt="
									+ new Date().getTime());
					return false;
				});

		//ajax检查 
		$("#txtVerifyCode").blur(function() {
			var code = $("#txtVerifyCode").val();
			//alert(code);
			$("#number\\.info").html("");//清空
				if(code ==""){
					$("#number\\.info").html("验证码不能为空");
				}else{
					$.post("validImage.action", {
				"code" : code
			}, function(se) {
				if (se) {
					$("#number\\.info").html("验证码正确");
				} else {
					$("#number\\.info").html("验证码错误");
					//$("#noSee").click();
				}
			});			
				}
		});
	});

	//表单提交处理
	//form的onsubmit事件,
	//return true允许提交,否则阻止提交
	$(function() {
		$("#f").submit(function() {
			$("#txtEmail").blur();//触发email检查
				$("#txtNickName").blur();
				$("#txtVerifyCode").blur();			        	
				return 
				checkflag.email
				&&checkflag.nickname
				&&checkflag.password;
				//alert(checkflag.email);
				//return checkflag.email;
			});
	});