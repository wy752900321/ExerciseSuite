var checkFlag={
		"receive_name":false,
		"full_address":false,
		"postal_code":false,
		"phone":false,
		"mobile":false,
};
var isRight=false;
function getAddress(){
	var address_id=$("#address").val();
	if(address_id==-1){
		$("#receive_name").val("");
		$("#full_address").val("");
		$("postal_code").val("");
		$("phone").val("");
		$("#mobile").val("");
		wrongMessage();
		return;
	}
	$.post("getNewOrder!getNewOrder.action",{"address_id":address_id},function(order){
		alert("getNewOrder-success");
		isRight=true;
		var orderStr=order.split("**");
		$("#receive_name").val(orderStr[0]);
		$("#full_address").val(orderStr[1]);
		$("#postal_code").val(orderStr[2]);
		$("#phone").val(orderStr[3]);
		$("#mobile").val(orderStr[4]);
	});
		rightMessage();
}

$(function(){
	//收件人姓名
	$("#receive_name").blur(function(){
		checkFlag.receive_name=false;
		isRight = false;
		var recName=$("#receive_name").val();
		//收件人不能为空
		if(recName==""){
			$("#nameValidMsg").html("收件人姓名不能为空").css("color","red");
			return;
		}
		//收件人格式检查
		var pattern= /^([a-z]|[\u4E00-\u9Fa5]|[\d])+$/;
		if(!pattern.test(recName)){
			$("#nameValidMsg").html("收件人格式不正确").css("color","red");
			return;
		}
		checkFlag.receive_name=true;
		$("#nameValidMsg").html("正确").css("color","green");
		});
	
	//收件人的详细信息
	$("#full_address").blur(function(){
		checkFlag.full_address=false;
		isRight=false;
		var addRess = $("#full_address").val();
		if(addRess==""){
			$("#addressValidMsg").html("收件人地址不能为空！").css("color","red");
			return;
		}
		checkFlag.full_address=true;
		$("#addressValidMsg").html("正确！").css("color","green");
	});
	
	//邮编
	$("#postal_code").blur(function(){
		checkFlag.postal_code=false;
		isRight=false;
		var postcode=$("#postal_code").val();
		if(postcode==""){
			$("#codeValidMsg").html("邮政编码不能为空！").css("color", "red");
			return;
		}
		var pattern = /^[0-9]{6}$/;
		if(!pattern.test(postcode)){
			$("#codeValidMsg").html("邮编格式错误  6位数字！").css("color","red");
			return;
		}
		checkFlag.postal_code=true;
		$("#codeValidMsg").html("正确！").css("color","green");
	});
	
	//电话
	$("#phone").blur(function(){
		checkFlag.phone=false;
		isRight=false;
		var phone=$("#phone").val();
		if (phone == "") {
			$("#phoneValidMsg").html("电话号码不能为空！").css("color", "red");
			return;
		}
		var pattern = /[0-9]{3}[\\-]*[0-9]{0,11}/;
		if(!pattern.test(phone)){
			$("#phoneValidMsg").html("电话号码格式错误！").css("color","red");
			return;
		}
		checkFlag.phone=true;
		$("#phoneValidMsg").html("正确").css("color","green");
	});
	
	//手机
	$("#mobile").blur(function(){
		checkFlag.mobile=false;
		isRight=false;
		var mobile=$("#mobile").val();
		if(mobile==""){
			$("#mobileValidMsg").html("手机号不能为空！").css("color","red");
			return;
		}
		var pattern = /[0-9]{11}/;
		if(!pattern.test(mobile)){
			$("#mobileValidMsg").html("手机号格式错误！").css("color","yellow");
			return;
		}
		checkFlag.mobile=true;
		$("#mobileValidMsg").html("正确！").css("color","green");
	});
	
	//判断是否符合注册要求，，，是否可以提交表单
	
	/*$("#form").submit(function(){
		var regist=checkFlag.full_address&&checkFlag.mobile&&checkFlag.phone
									&&checkFlag.postal_code&&checkFlag.receive_name;
		if(regist||isRight){
			$("#address_id").val($("#address").val());
			return true;//允许提交
		}else{
			alert("表单有误！！")
			return false;
		}
	});*/

	//表单提交处理
	//form的onsubmit事件,
	//return true允许提交,否则阻止提交
	$(function(){
		$("#form").submit(function(){
			$("#receive_name").blur();
			$("#full_address").blur();
			$("#postal_code").blur();
			$("#phone").blur();
			$("#mobile").blur();
			
			var regist=checkFlag.full_address&&checkFlag.mobile&&checkFlag.phone
									&&checkFlag.postal_code&&checkFlag.receive_name;
			if(regist||isRight){
				$("#address_id").val($("#address").val());
				return true;//允许提交
			}else{
				alert("请仔细核对表单信息！！")
				return false;
			}
		});
	});
	
});

function wrongMessage(){
	$("#nameValidMsg").html("请填写有效的收件人姓名").css("color","gray");
	$("#addressValidMsg").html("请填写有效的收件人的详细地址").css("color","gray");
	$("#codeValidMsg").html("请填写有效的收件人的邮政编码").css("color","gray");
	$("#phoneValidMsg").html("请填写有效的收件人的电话").css("color","gray");
	$("#mobileValidMsg").html("请填写有效的收件人的手机").css("color","gray");
}
function rightMessage(){
	$("#nameValidMsg").html("正确").css("color","green");
	$("#addressValidMsg").html("正确").css("color","green");
	$("#codeValidMsg").html("正确").css("color","green");
	$("#phoneValidMsg").html("正确").css("color","green");
	$("#mobileValidMsg").html("正确").css("color","green");
}