var checkFlag = {
	"email" : false,
	"emailajax" : false,
	"nickname" : false,
	"password" : false,
	"password1" : false,
	"code" : false
};

//判断邮箱格式是否正确
$(function() {
	$("#txtEmail")
			.blur(function() {
				checkFlag.email = false;//初始化邮箱为：未通过
					checkFlag.emailajax = false; //初始化ajax邮箱为：未通过
					var email = $("#txtEmail").val();
					//邮箱非空检查
					if (email == "") {
						$("#email\\.info").html("邮箱不能为空！").css("color", "red");
						return;
					}
					//邮箱格式检查
					var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
					if (!pattern.test(email)) {
						$("#email\\.info").html("邮箱格式不正确！").css("color", "red");
						return;
					}
					checkFlag.email = true;

					$.post("vailEmail.action", {
						"email" : email
					}, function(ok) {
						if (ok) {
							checkFlag.emailajax = true;//设置成通过检查
							$("#email\\.info").html("正确！")
									.css("color", "green");
						} else {
							checkFlag.emailajax = false;//设置成未通过检查
							$("#email\\.info").html("Email已被占用!").css("color",
									"red");
						}

					});
				});
	//判断用户昵称的格式是否正确；//昵称可以由小写英文字母、中文、数字组成 长度4－20个字符，一个汉字为两个字符。 
	$("#txtNickName").blur(function() {
		checkFlag.nickname = false;
		var nickname = $("#txtNickName").val();
		if (nickname == "") {
			$("#name\\.info").html("用户名不能为空！").css("color", "red");
			return;
		}
		var lengthStr = getBytesLength(nickname);
		if (lengthStr < 4||lengthStr > 20) {
			//alert(length);
			$("#name\\.info").html("用户名长度不符合条件！").css("color", "red");
			return;
		}
		var checkNicknameStr = /^([a-z]|[\u4E00-\u9Fa5]|[\d])+$/;
		if (!checkNicknameStr.test(nickname)) {
			$("#name\\.info").html("用户名格式不正确！").css("color", "red");
			return;
		}
		checkFlag.nickname = true;
		$("#name\\.info").html("正确！").css("color", "green");
	});

	//判断用户的密码格式是否正确； --您的密码可以由大小写英文字母、数字组成，长度6－20位。
	$("#txtPassword").blur(function() {
		checkFlag.password = false;
		var pwd = $("#txtPassword").val();
		if (pwd == "") {
			$("#password\\.info").html("密码不能为空！").css("color", "red");
			return;
		}
		var checkPwdStr = /^(\d|[a-zA-Z]){6,20}$/
		if (!checkPwdStr.test(pwd)) {
			$("#password\\.info").html("密码格式不正确！").css("color", "red");
			return;
		}
		var pwd1 = $("#txtRepeatPass").val();
		if (pwd1 == "") {
			checkFlag.password = true;
			$("#password\\.info").html("正确！").css("color", "green");
		} else if (pwd1 == pwd) {
			checkFlag.password = true;
			checkFlag.password1 = true;
			$("#password\\.info").html("正确！ ").css("color", "green");
			$("#password1\\.info").html("正确！").css("color", "green");
		} else {
			checkFlag.password = false;
			checkFlag.password1 = false;
			$("#password1\\.info").html("两次输入的密码不匹配！").css("color", "red");
		}

	});

	//判断第二次输入的密码是否符合于第一次输入的相等；
	$("#txtRepeatPass").blur(function() {
		checkFlag.password1 = false;
		var pass = $("#txtRepeatPass").val();
		if (pass == "") {
			$("#password1\\.info").html("重复密码不能为空！").css("color", "red");
			return;
		}
		var pwd = $("#txtPassword").val();
		if (pwd != pass) {
			$("#password1\\.info").html("两次输入的密码不匹配！").css("color", "red");
			return;
		} else {
			checkFlag.password1 = true;
			$("#password1\\.info").html("正确！").css("color", "green");
		}
	});

	//判断用户输入的验证码是否符合要求；
	$("#txtVerifyCode").blur(function() {
		checkFlag.code = false;
		$("#number\\.info").html("");

		var code = $("#txtVerifyCode").val();
		if (code == "") {
			$("#number\\.info").html("验证码不能为空 ！").css("color", "red");
			return;
		}
		$.post("checkCodeImage.action", {
			"code" : code
		}, function(ok) {
			if (ok) {
				$("#number\\.info").html("正确！").css("color", "green");
				checkFlag.code = true;
			} else {
				$("#number\\.info").html("验证码错误！").css("color", "red");
				checkFlag.code = false;
			}
		});

	});

	//判断是否符合注册要求，，，是否可以提交表单
	$("#f").submit(
			function() {
				var regist = checkFlag.email && checkFlag.code
						&& checkFlag.emailajax && checkFlag.nickname
						&& checkFlag.password && checkFlag.password1;
//				aler("1"+checkFlag.email);
//				aler("2"+checkFlag.code);
//				aler("3"+checkFlag.emailajax);
//				aler("4"+checkFlag.nickname);
//				aler("5"+checkFlag.password);
//				aler("6"+checkFlag.password1);
				if (regist) {
					return true;//允许提交
				} else {
					//alert("系统繁忙，请重试................");
				 alert("表单有错误！请检查...........")
					return false;
				}
			});
});

//如果是汉字那么其长度为2；
function getBytesLength(str) {
	return str.replace(/[^\x00-\xff]/g, 'xx').length;
}