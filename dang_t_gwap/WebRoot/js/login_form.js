// login_form.jsp 的javascript代码
var checkFlag = false;
$(function() {
	// 邮箱和密码的验证
	$("#txtUsername,#txtPassword")
			.keyup(
					function() {
						checkFlag = false;
						var username = $("#txtUsername").val();
						var password = $("#txtPassword").val();
						var userPat = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
						var pwdPat = /^([A-Za-z0-9]){6,20}$/;
						$("#errorMsg").html("");
						// 非空检查
						if (username == "" || password == "") {
							checkFlag = false;
							$("#errorMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  用户名或密码为空！")
									.css("color", "red");
							return;
						} else {
							// 格式检查
							if (!userPat.test(username)
									|| !pwdPat.test(password)) {
								checkFlag = false;
								$("#errorMsg")
										.html(
												"<img src='../images/check/wrong.jpg'>  用户名或密码格式有误！")
										.css("color", "red");
								return;
							}

							checkFlag = true;
							$("#errorMsg")
									.html(
											"<img src='../images/check/wait.jpg'>  请稍候......")
									.css("color", "blue");
						}
					});

	// 提交检查
	$("#ctl00")
			.submit(
					function() {
						if (checkFlag) {
							return true;
						} else {
							$("#errorMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  对不起，数据不完整，请您检查。")
									.css("color", "red");
							return false;
						}
					});
});