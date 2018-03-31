<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="org.tarena.dang.util.UUIDToken"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../js/address_form.js"></script>
	</head>

	<body>
		<%@include file="../common/head1.jsp"%>
			
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	
		</div>
			
		<div class="fill_message">
		
			<p>
				选择地址：
				<select id="address" onchange="getAddress()" name="address_id">
					<option value="-1">
						填写新地址
					</option>
						<s:iterator value="orderList" var="order">
							<option value='<s:property value="#order.id"/>'>
								<s:property value="#order.receive_name"/>							
							</option>
						</s:iterator>
				</select>
			</p>
			<!-- 
			 < %
			 	String s=UUIDToken.getUuidToken().getUUidAsUniqueStr(request);
			 %>
			  -->
			<form name="ctl00" method="post" action='${pageContext.request.contextPath }/order/orderOk.action' id="form">
				<!-- 表单重复提交处理，第一步加s:token标签 -->
				<s:token></s:token>
				<!-- UUID控制表单重复提交 -->
				<!--
				<input type="hidden" name="html.token" value="< %=s %>"/>
				-->
				<!-- 这个隐藏域是为了给adddress_id赋值，把填写的地址成功保存到数据库中用 -->
				<input type="hidden" name="address_id" id="address_id"></input>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="receive_name"
								id="receive_name" />
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
							<input type="text" name="full_address" class="text_input"
								id="full_address" />
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
							<input type="text" class="text_input" name="postal_code"
								id="postal_code" />
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
							<input type="text" class="text_input" name="phone"
								id="phone" />
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
							<input type="text" class="text_input" name="mobile"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="javascript:;" onclick='location="../cart/ShowOrderInfo!showOrderInfo.action"'><input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

