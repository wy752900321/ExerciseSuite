// register_form.jsp 的javascript代码
//表单项目是否通过检查的标识
var checkFlag = {
	"email" : false,//非空和格式检查标识
	"emailajax" : false,//ajax检查标识
	"nickname" : false,
	"nicknameajax" : false,
	"password" : false,
	"repassword" : false,
	"code" : false
};

$(function() {
	$("#txtEmail")
			.blur(function() {
				$("#email\\.info").html("");
				var email = $("#txtEmail").val();
				checkFlag.email = false;//未通过检查
					checkFlag.emailajax = false;//未通过检查
					//非空检查
					if (email == "") {
						checkFlag.email = false;//设置成未通过检查
						$("#email\\.info")
								.html(
										"<img src='../images/check/wrong.jpg'>  邮箱不允许为空！")
								.css("color", "red");
						return;
					}
					//格式检查
					var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
					if (!pattern.test(email)) {
						checkFlag.email = false;//设置成未通过检查
						$("#email\\.info")
								.html(
										"<img src='../images/check/wrong.jpg'>  邮箱格式有误！")
								.css("color", "red");
						return;
					}
					checkFlag.email = true;//通过非空格式,设置为true
					$("#email\\.info").html(
							"<img src='../images/check/wait.jpg'>  请稍候……").css(
							"color", "blue");
					$
							.post("validEmail.action",
									{
										"email" : email
									},
									function(ok) {
										if (ok) {
											checkFlag.emailajax = true;//设置成通过检查
									$("#email\\.info")
											.html(
													"<img src='../images/check/right.jpg'>  邮箱可以使用")
											.css("color", "green");
								} else {
									checkFlag.emailajax = false;//设置成未通过检查
									$("#email\\.info")
											.html(
													"<img src='../images/check/wrong.jpg'>  Sorry,邮箱已经被占用")
											.css("color", "red");
								}
							});
				});

	$("#txtNickName")
			.blur(function() {
				$("#name\\.info").html("");
				var nickname = $("#txtNickName").val();
				checkFlag.nickname = false;//未通过检查
					checkFlag.nicknameajax = false;//未通过检查
					//非空检查
					if (nickname == "") {
						checkFlag.nickname = false;//设置成未通过检查
						$("#name\\.info")
								.html(
										"<img src='../images/check/wrong.jpg'>  昵称不允许为空！")
								.css("color", "red");
						return;
					}

					// 双字符检查
					nickname = nickname.replace(/[^\x00-\xff]/g, 'xx');
					//格式检查
					var pattern = /^([\u4e00-\u9fa5A-Za-z0-9]){4,20}$/;
					if (!pattern.test(nickname)) {
						checkFlag.nickname = false;//设置成未通过检查
						$("#name\\.info")
								.html(
										"<img src='../images/check/wrong.jpg'>  昵称格式有误！")
								.css("color", "red");
						return;
					}
					checkFlag.nickname = true;//通过非空格式,设置为true
					$("#name\\.info").html(
							"<img src='../images/check/wait.jpg'>  请稍候……").css(
							"color", "blue");
					$
							.post("validNickName.action",
									{
										"nickname" : nickname
									},
									function(ok) {
										if (ok) {
											checkFlag.nicknameajax = true;//设置成通过检查
									$("#name\\.info")
											.html(
													"<img src='../images/check/right.jpg'>  昵称可以使用")
											.css("color", "green");
								} else {
									checkFlag.nicknameajax = false;//设置成未通过检查
									$("#name\\.info")
											.html(
													"<img src='../images/check/wrong.jpg'>  Sorry,昵称已经被占用")
											.css("color", "red");
								}
							});
				});

	// 密码检查
	$("#txtPassword,#txtRepeatPass")
			.keyup(
					function() {
						$("#password\\.info").html("");
						var password = $("#txtPassword").val();
						var repassword = $("#txtRepeatPass").val();
						checkFlag.password = false;
						checkFlag.repassword = false;
						// 格式检查及非空检查
						var pattern = /^([A-Za-z0-9]){6,20}$/;
						if (password == "" || !pattern.test(password)) {
							if (repassword == "") {
								checkFlag.password = false;
								checkFlag.repassword = false;
								$("#password\\.info").html("");
								return;
							}
							checkFlag.password = false;
							checkFlag.repassword = false;
							$("#password\\.info")
									.html(
											"<img src='../images/check/wrong.jpg'>  初始密码格式有误")
									.css("color", "red");
							return;
						} else {
							// 两次密码不相同
							if (password != repassword) {
								if (repassword == "") {
									checkFlag.password = false;
									checkFlag.repassword = false;
									$("#password\\.info").html("");
									return;
								}
								checkFlag.password = false;
								checkFlag.repassword = false;
								$("#password\\.info")
										.html(
												"<img src='../images/check/wrong.jpg'>  两次密码不一致")
										.css("color", "red");
								return;
							} else {
								checkFlag.password = true;
								checkFlag.repassword = true;
								$("#password\\.info")
										.html(
												"<img src='../images/check/right.jpg'>  密码可以使用")
										.css("color", "green");
							}
						}
					});

	// 验证码验证
	$("#txtVerifyCode")
			.blur(
					function() {
						$("#number\\.info").html("");
						checkFlag.code = false;
						var code = $("#txtVerifyCode").val();
						// 非空验证
						if (code == "") {
							checkFlag.code = false;
							$("#number\\.info")
									.html(
											"<img src='../images/check/wrong.jpg'>  验证码不允许为空！")
									.css("color", "red");
							return;
						}
						$
								.post(
										"validCode.action",
										{
											"code" : code
										},
										function(ok) {
											// 可用性检查
											$("#number\\.info")
													.html(
															"<img src='../images/check/wait.jpg'>  请稍候……")
													.css("color", "blue");
											if (ok) {
												checkFlag.code = true;
												$("#number\\.info")
														.html(
																"<img src='../images/check/right.jpg'>  验证码正确")
														.css("color", "green");
											} else {
												checkFlag.code = false;
												$("#number\\.info")
														.html(
																"<img src='../images/check/wrong.jpg'>  验证码有误，请确认重新输入。")
														.css("color", "red");
											}
										});
					});

	// 点击更换图片
	$("#imgVcode").click(function() {
		$(this).attr("src", "imagecode.action?dt=" + new Date().getTime());
	});

	// 离开时数据消失
	$("#btnClientRegister").mouseout(function() {
		$("#registerMsg").html("");
	});

	// 提交逻辑
	$("#f")
			.submit(
					function() {
						if (checkFlag.email && checkFlag.emailajax
								&& checkFlag.nickname && checkFlag.nicknameajax
								&& checkFlag.password && checkFlag.repassword
								&& checkFlag.code) {
							return true;//允许提交
						} else {
							$("#registerMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  对不起，数据不完整，请您检查......")
									.css("color", "red");
							return false;//阻止提交
						}
					});

});