<%@page contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
<style>
.name {
	width:170px; height:17px; padding:3px 2px 0 1px; border:solid 1px #a8a6ab; margin-left:20px; float:left
}

.error {
	color: red;
	font-style: italic;
}
</style>
<script language="javascript" src="../js/prototype-1.6.0.3.js"></script>
<script>
    //收件人姓名
	function checkReciveName() {
		//获取收件人姓名
		var receiveName = $("receiveName");
		//获取错误消息
		var name = $("name_error");
		name.innerHTML = "";
		receiveName.className = "";
		//定义正则表达式
		//var reg = /^$/;//正则不要带引号
		if (receiveName.value.strip().length==0) {
			name.innerHTML = "收件人不能为空！";
			receiveName.className = "name";
			return false;
		}
		return true;
	}
	 //收件人详细地址
	function checkFullAddress() {
		//获取收件人详细地址
		var fullAddress = $("fullAddress");
		//获取错误消息
		var address_error = $("address_error");
		address_error.innerHTML = "";
		fullAddress.className = "";
		if (fullAddress.value.strip().length==0) {
			address_error.innerHTML = "收件人地址不能为空！";
			fullAddress.className = "name";
			return false;
		}
		return true;
	}
	 //邮政编码
	function checkPostCode() {
		//获取邮政编码
		var postalCode = $("postalCode");
		//获取错误消息
		var post_error = $("post_error");
		post_error.innerHTML = "";
		postalCode.className = "";
		//定义正则表达式
		var reg = /^\d{6}$/;
		if (!reg.test(postalCode.value.strip())) {
			post_error.innerHTML = "邮政编码是6位的数字！";
			postalCode.className = "name";
			return false;
		}
		return true;
	}
	
	 //电话号码
	function checkPhone() {
		//获取电话号码
		var phone = $("phone");
		//获取错误消息
		var phone_error = $("phone_error");
		phone_error.innerHTML = "";
		phone.className = "";
		//定义正则表达式
		var reg = /^\d{7}$/;
		if (!reg.test(phone.value.strip())) {
			phone_error.innerHTML = "电话号码必须是7位的数字！";
			phone.className = "name";
			return false;
		}
		return true;
	}
	
	//手机号码
	function checkMobile() {
		//获取手机号码
		var mobile = $("mobile");
		//获取错误消息
		var mobile_error = $("mobile_error");
		mobile_error.innerHTML = "";
		mobile.className = "";
		//定义正则表达式
		var reg = /^(1)\d{10}$/;
		if (!reg.test(mobile.value.strip())) {
			mobile_error.innerHTML = "手机号必须是首位是1的11位的数字！";
			mobile.className = "name";
			return false;
		}
		return true;
	}
	
	function fun(){
	   return checkReciveName()&&checkFullAddress()&&checkPostCode()&&checkPhone()&&checkMobile();
	}
</script>

	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option>
						填写新地址
					</option>
				</select>
			</p>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/order/orderAction!doAddress" id="f" onsubmit="return fun();">
				<input type="hidden" name="id" id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
								<s:textfield cssClass="text_input" name="order.receiveName" id="receiveName" onblur="javascript:checkReciveName();"/>
								<span id="name_error" class="error"></span>
						</td>
						<td>
						  <div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
								<s:textfield name="order.fullAddress" cssClass="text_input" id="fullAddress" onblur="javascript:checkFullAddress();"/>
					   	<span id="address_error" class="error"></span>
						</td>
						<td>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
								<s:textfield cssClass="text_input" name="postalCode" id="postalCode" onblur="javascript:checkPostCode();"/>
						  	<span id="post_error" class="error"></span>
						</td>
						<td>
						 <div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
								<s:textfield cssClass="text_input" name="order.phone" id="phone" onblur="javascript:checkPhone();"/>
								<span id="phone_error" class="error"></span>
						</td>
						<td>
						  <div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
								<s:textfield cssClass="text_input" name="order.mobile" id="mobile" onblur="javascript:checkMobile();"/>
					   	<span id="mobile_error" class="error"></span>
						</td>
						<td>
					   	<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="/dangdang/cart/cartAction!toOrder"><input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submitButton"
					type="submit" value="下一步"   />
				</div>
			</form>
		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

