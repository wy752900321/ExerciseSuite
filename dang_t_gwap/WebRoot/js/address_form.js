// address_form.jsp的java script代码
var checkFlag = {
	// 非空和格式检查
	"receiveName" : false,
	"fullAddress" : false,
	"postalCode" : false,
	"phone" : false,
	"mobile" : false
};
$(function() {
	/*收件人验证*/
	$("#receiveName").keyup(
			function() {
				$("#nameValidMsg").html(
						"<img src='../images/check/wrong.jpg'>  请填写有效的收件人姓名")
						.css("color", "red");
				var receiveName = $("#receiveName").val();
				checkFlag.receiveName = false;

				//非空检查
				if (receiveName == "") {
					checkFlag.receiveName = false;
					$("#nameValidMsg").html(
							"<img src='../images/check/wrong.jpg'>  收件人姓名不能为空")
							.css("color", "red");
					return;
				}

				receiveName = receiveName.replace(/[^\x00-\xff]/g, 'xx');
				//格式检查
				var pattern = /^([\u4e00-\u9fa5A-Za-z0-9]){4,20}$/;
				if (!pattern.test(receiveName)) {
					checkFlag.receiveName = false;
					return;
				}
				checkFlag.receiveName = true;
				$("#nameValidMsg").html(
						"<img src='../images/check/right.jpg'>  收件人姓名合法").css(
						"color", "green");
			});

	/*收件人详细地址验证*/
	$("#fullAddress")
			.keyup(
					function() {
						$("#addressValidMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  请填写有效的收件人的详细地址")
								.css("color", "red");
						var fullAddress = $("#fullAddress").val();
						checkFlag.fullAddress = false;

						//非空检查
						if (fullAddress == "") {
							checkFlag.fullAddress = false;
							$("#addressValidMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  收件人的详细地址不能为空")
									.css("color", "red");
							return;
						}

						fullAddress = fullAddress
								.replace(/[^\x00-\xff]/g, 'xx');
						//格式检查
						var pattern = /^([\u4e00-\u9fa5A-Za-z0-9]){4,100}$/;
						if (!pattern.test(fullAddress)) {
							checkFlag.fullAddress = false;
							return;
						}
						checkFlag.fullAddress = true;
						$("#addressValidMsg")
								.html(
										"<img src='../images/check/right.jpg'>  收件人的详细地址合法")
								.css("color", "green");
					});

	/*邮政编码验证*/
	$("#postalCode")
			.keyup(
					function() {
						$("#codeValidMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  请填写有效的收件人的邮政编码")
								.css("color", "red");
						var postalCode = $("#postalCode").val();
						checkFlag.postalCode = false;

						//非空检查
						if (postalCode == "") {
							checkFlag.postalCode = false;
							$("#codeValidMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  收件人的邮政编码不能为空")
									.css("color", "red");
							return;
						}

						//格式检查
						var pattern = /^[0-9]{6}$/;
						if (!pattern.test(postalCode)) {
							checkFlag.postalCode = false;
							return;
						}
						checkFlag.postalCode = true;
						$("#codeValidMsg")
								.html(
										"<img src='../images/check/right.jpg'>  收件人的邮政编码合法")
								.css("color", "green");
					});

	/*电话验证*/
	$("#phone")
			.keyup(
					function() {
						$("#phoneValidMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  请填写有效的收件人的电话")
								.css("color", "red");
						var phone = $("#phone").val();
						checkFlag.phone = false;

						//非空检查
						if (phone == "") {
							checkFlag.phone = false;
							$("#phoneValidMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  收件人的电话不能为空")
									.css("color", "red");
							return;
						}
						//格式检查
						var pattern = /^0(((\d{2,3})-(\d){7,8})|(\d{2,3}(\d){7,8}))$/;
						if (!pattern.test(phone)) {
							checkFlag.phone = false;
							return;
						}
						checkFlag.phone = true;
						$("#phoneValidMsg")
								.html(
										"<img src='../images/check/right.jpg'>  收件人的电话合法")
								.css("color", "green");
					});

	/*手机验证*/
	$("#mobile")
			.keyup(
					function() {
						$("#mobileValidMsg")
								.html(
										"<img src='../images/check/wrong.jpg'>  请填写有效的收件人的手机")
								.css("color", "red");
						var mobile = $("#mobile").val();
						checkFlag.mobile = false;

						//非空检查
						if (mobile == "") {
							checkFlag.mobile = false;
							$("#mobileValidMsg")
									.html(
											"<img src='../images/check/wrong.jpg'>  收件人的手机不能为空")
									.css("color", "red");
							return;
						}
						//格式检查
						var pattern = /^(13|15|18|14|17|16)\d{9}$/;
						if (!pattern.test(mobile)) {
							checkFlag.mobile = false;
							return;
						}
						checkFlag.mobile = true;
						$("#mobileValidMsg")
								.html(
										"<img src='../images/check/right.jpg'>  收件人的手机合法")
								.css("color", "green");
					});
	
	// 鼠标离开时的事件
	$("#btnClientRegister").mouseout(function() {
		$("#verifyAddress").html("");
	});

	// 提交时的事件
	$("#f")
			.submit(
					function() {
						if (checkFlag.receiveName && checkFlag.fullAddress
								&& checkFlag.postalCode && checkFlag.phone
								&& checkFlag.mobile) {
							return true;//允许提交
						} else {
							$("#verifyAddress")
									.html(
											"<img src='../images/check/wrong.jpg'>  对不起，数据不完整，请您检查...")
									.css("color", "red");
							return false;//阻止提交
						}
					});
});

function getMessage() {
	// 表单中的五个textbox的显示逻辑
	var id = $("#address").val();
	// 填写新地址
	if (id == 0) {
		// 全部设成检查失败
		checkFlag.receiveName = false;
		checkFlag.fullAddress = false;
		checkFlag.postalCode = false;
		checkFlag.mobile = false;
		checkFlag.phone = false;
		// 设成初始状态
		$("#nameValidMsg").html("请填写有效的收件人姓名").css("color", "black");
		$("#addressValidMsg").html("请填写有效的收件人的详细地址").css("color", "black");
		$("#codeValidMsg").html("请填写有效的收件人的邮政编码").css("color", "black");
		$("#phoneValidMsg").html("请填写有效的收件人的电话").css("color", "black");
		$("#mobileValidMsg").html("请填写有效的收件人的手机").css("color", "black");
		$("#receiveName").val("");
		$("#fullAddress").val("");
		$("#postalCode").val("");
		$("#mobile").val("");
		$("#phone").val("");
	}
	$.post("addressStr.action", {
		"id" : id
	}, function(msgStr) {
		// 接收返回的msgStr并劈开
			$("#receiveName").val(msgStr.split("-")[0]);
			$("#fullAddress").val(msgStr.split("-")[1]);
			$("#postalCode").val(msgStr.split("-")[2]);
			$("#mobile").val(msgStr.split("-")[3]);
			$("#phone").val(msgStr.split("-")[4]);
			// 全部设成检查通过
			checkFlag.receiveName = true;
			checkFlag.fullAddress = true;
			checkFlag.postalCode = true;
			checkFlag.mobile = true;
			checkFlag.phone = true;
			// 设置样式为通过的样式
			$("#nameValidMsg").html(
					"<img src='../images/check/right.jpg'>  收件人姓名合法").css(
					"color", "green");
			$("#addressValidMsg").html(
					"<img src='../images/check/right.jpg'>  收件人的详细地址合法").css(
					"color", "green");
			$("#codeValidMsg").html(
					"<img src='../images/check/right.jpg'>  收件人的邮政编码合法").css(
					"color", "green");
			$("#phoneValidMsg").html(
					"<img src='../images/check/right.jpg'>  收件人的电话合法").css(
					"color", "green");
			$("#mobileValidMsg").html(
					"<img src='../images/check/right.jpg'>  收件人的手机合法").css(
					"color", "green");
		});

}