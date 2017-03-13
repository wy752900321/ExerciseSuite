var checkFlag = {
	"receiveName" : false,
	"fullAddress" : false,
	"postalCode" : false,
	"phone" : false,
	"mobile" : false
};
var isRight=false;
function getAddress() {
	var addressId = $("#address").val();
	if (addressId == -1) {
		$("#receiveName").val("");
		$("#fullAddress").val("");
		$("#postalCode").val("");
		$("#phone").val("");
		$("#mobile").val("");
		wrongMessage();
		return;
	}
	$.post("../order/getNewOrder.action", {
		"addressId" : addressId
	}, function(order) {
		isRight=true;
		var orderStr = order.split("**");
		$("#receiveName").val(orderStr[0]);
		$("#fullAddress").val(orderStr[1]);
		$("#postalCode").val(orderStr[2]);
		$("#phone").val(orderStr[3]);
		$("#mobile").val(orderStr[4]);
	});
	rightMessage();
}


$(function() {
	//收件人姓名
	$("#receiveName").blur(function() {
		checkFlag.receiveName = false;isRight=false;
		var recName = $("#receiveName").val();
		//收件人不能为空
			if (recName == "") {
				$("#nameValidMsg").html("收件人姓名不能为空！").css("color", "red");
				return;
			}
			//收件人格式检查
			var pattern = /^([a-z]|[\u4E00-\u9Fa5]|[\d])+$/;
			if (!pattern.test(recName)) {
				$("#nameValidMsg").html("收件人格式不正确！").css("color", "red");
				return;
			}
			checkFlag.receiveName = true;
			$("#nameValidMsg").html("正确！").css("color", "green");
		});

	//收件人的详细信息
	$("#fullAddress").blur(function() {
		checkFlag.fullAddress = false;isRight=false;
		var addRess = $("#fullAddress").val();
		if (addRess == "") {
			$("#addressValidMsg").html("收件人的地址不能为空！").css("color", "red");
			return;
		}
		checkFlag.fullAddress = true;
		$("#addressValidMsg").html("正确！").css("color", "green");
	});
	//邮编
	$("#postalCode").blur(function() {
		checkFlag.postalCode = false;isRight=false;
		var postcode = $("#postalCode").val();
		if (postcode == "") {
			$("#codeValidMsg").html("邮政编码不能为空！").css("color", "red");
			return;
		}
		var pattern = /^[0-9]{6}$/;
		if (!pattern.test(postcode)) {
			$("#codeValidMsg").html("邮政编码格式错误！").css("color", "red");
			return;
		}
		checkFlag.postalCode = true;
		$("#codeValidMsg").html("正确！").css("color", "green");
	});

	//电话
	$("#phone").blur(function() {
		checkFlag.phone = false;isRight=false;
		var phone = $("#phone").val();
		if (phone == "") {
			$("#phoneValidMsg").html("电话号码不能为空！").css("color", "red");
			return;
		}
		var pattern = /[0-9]{3}[\\-]*[0-9]{0,11}/;
		if (!pattern.test(phone)) {
			$("#phoneValidMsg").html("电话号码格式错误！").css("color", "red");
			return;
		}
		checkFlag.phone = true;
		$("#phoneValidMsg").html("正确！").css("color", "green");
	});
	//手机
	$("#mobile").blur(function() {
		checkFlag.mobile = false;isRight=false;
		var mobile = $("#mobile").val();
		if (mobile == "") {
			$("#mobileValidMsg").html("手机号码不能为空！").css("color", "red");
			return;
		}
		var pattern = /[0-9]{11}/;
		if (!pattern.test(mobile)) {
			$("#mobileValidMsg").html("手机号码格式错误！").css("color", "yellow");
			return;
		}
		checkFlag.mobile = true;
		$("#mobileValidMsg").html("正确！").css("color", "green");
	});

	//判断是否符合注册要求，，，是否可以提交表单
	$("#form").submit(
			function() {
				var regist = checkFlag.fullAddress && checkFlag.mobile
						&& checkFlag.phone && checkFlag.postalCode
						&& checkFlag.receiveName;
				if (regist||isRight) {
					$("#address_id").val($("#address").val());
					return true;//允许提交
				} else {
					alert("亲！表单填写有误，请检测填写内容.........")
					return false;
				}
	});
});




function rightMessage(){
	$("#nameValidMsg").html("正确！").css("color", "green");
	$("#addressValidMsg").html("正确！").css("color", "green");
	$("#codeValidMsg").html("正确！").css("color", "green");
	$("#phoneValidMsg").html("正确！").css("color", "green");
	$("#mobileValidMsg").html("正确！").css("color", "green");
}
function wrongMessage(){
	$("#nameValidMsg").html("请填写有效的收件人姓名").css("color", "gray");
	$("#addressValidMsg").html("请填写有效的收件人的详细地址").css("color", "gray");
	$("#codeValidMsg").html("请填写有效的收件人的邮政编码").css("color", "gray");
	$("#phoneValidMsg").html("请填写有效的收件人的电话").css("color", "gray");
	$("#mobileValidMsg").html("请填写有效的收件人的手机").css("color", "gray");
}
