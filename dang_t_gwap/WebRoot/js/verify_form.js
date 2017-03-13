// verify_form.jsp的java script代码
var checkFlag = {
	"code" : false
};
$(function() {
	// 邮箱验证码验证
	$("#validatecode")
			.blur(function() {
				$("#errorMsg").html("");
				var code = $("#validatecode").val();
				checkFlag.code = false;
				// 非空检查
					if (code == "") {
						checkFlag.code = false;
						$("#errorMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  邮箱验证码不允许为空")
								.css("color", "red");
						return;
					}
					// 格式检查
					var pattern = /^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}-[0-9]+$/;
					if (!pattern.test(code)) {
						checkFlag.code = false;
						$("#errorMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  验证码格式有误")
								.css("color", "red");
						return;
					}
					checkFlag.code = true;
					$("#errorMsg").html(
							"<img src='../images/check/right.jpg'>  验证码格式正确")
							.css("color", "green");
				});

	// 提交逻辑
	$("#m")
			.submit(
					function() {
						if (checkFlag.code) {
							return true;
						} else {
							$("#errorMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  对不起，数据不完整，请您检查...")
									.css("color", "red");
							return false;
						}
					});
});