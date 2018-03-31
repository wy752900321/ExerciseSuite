<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="bean.*,java.util.*,util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
		<link href="css/main/style.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript">
			//除掉字符串两端的空格
			function strip(str){
				var reg = /(^\s*)|(\s*$)/;
				return str.replace(reg,'');
			}
			function modify(id,qty){
				//非空检测
				if(strip(qty).length ==0){
					alert("数量不能为空");
					return;
				}
				//非数字检测
				var reg = /^[0-9]+$/;
				if(!reg.test(strip(qty))){
					alert('必须为数字');
					return;
				}
				location='update.do?id=' + id + '&qty=' + strip(qty);
			}
			</script>
	</head>

	<body topMargin="10">
		<div id="append_parent"></div>
		<table cellSpacing="6" cellPadding="2" width="100%" border="0">
			<tbody>
				<tr>
					<td>
						<table class="guide" cellSpacing="0" cellPadding="0" width="100%"
							border="0">
							<tbody>
								<tr>
									<td>
										<a href='#'>主页</a>&nbsp;/&nbsp;
										<a href='computer_list.jsp'>笔记本订购(WEB007)</a>&nbsp;/&nbsp;购物车信息
									</td>
								</tr>
							</tbody>
						</table>
						<br />



						<table class="tableborder" cellSpacing="0" cellPadding="0"
							width="100%" border="0">
							<tbody>
								<tr class="header">
									<td class="altbg2" colspan="6">
										购物车信息
									</td>
								</tr>
							<tbody>
								<tr>
									<td class="altbg1" width="20%">
										<b>型号</b>
									</td>
									<td class="altbg1" width="20%">
										<b>价格</b>
									</td>
									<td class="altbg1" width="10%">
										<b>数量</b>
									</td>
									<td class="altbg1" width="30">
										&nbsp;
									</td>
									<td class="altbg1" width="10%">
										&nbsp;
									</td>
									<td class="altbg1">
										&nbsp;
									</td>
								</tr>
							</tbody>
							
							<tbody>
								<%
									//从session当中取出cart
														Cart cart = (Cart)session.getAttribute("cart"); 
														//版本二更改  尝试恢复之前购买过的商品
														if(cart == null)
														{ cart = new Cart(); 
														cart.load(CookieUtil.findCookie("cart",request));
														session.setAttribute("cart",cart);
														} 
														if(cart !=null && cart.list().size() > 0){
															//显示购物车中的商品
															List<CartItem> items = cart.list();
															for(int i=0;i<items.size();
															i++){ CartItem item = items.get(i);
								%>
								<tr>
									<td class="altbg2">
										<%=item.getC().getModel() %>
										<%System.out.println("item->getC()->getModel()"+item.getC().getModel()); %>
									</td>
									<td class="altbg2">
										<%=item.getC().getPrice()%>
										<%System.out.println("item->getC()->getPrice()"+item.getC().getPrice()); %>
									</td>
									<td class="altbg2">
										<%=item.getQty()%>
									</td>
									<td class="altbg2">
										<input type="text" size="3" value=""
											id="num_<%=item.getC().getId()%>" />
											<%System.out.println("item->getC()->getId()"+item.getC().getId()); %>
									</td>
									<td class="altbg2">
										<a href="javascript:;" 
										onclick="modify(<%=item.getC().getId()%>,
													document.getElementById('num_<%=item.getC().getId()%>').value);">更改数量</a>
									</td>
									<td class="altbg2">
										<a href="del.do?id=<%=item.getC().getId()%>">删除</a>
									</td>
								</tr>
								<%
									}
								 %>
								<tr>
									<td class="altbg1" colspan="6">
										<b>总价格：￥<%=cart.sum()%></b>
									</td>
								</tr>
								<%
									}else{
										//显示还没有选购商品
								 %>
							<tr>
								<td class="altbg2" colspan="6">
									<b>还没有选购商品</b>
								</td>
							</tr>
							<%
								}
							 %>
						</table>

						<br />
						<center>
							<input class="button" type="button" value="返回商品列表"
								name="settingsubmit" onclick="location = 'list.do';">
							<input class="button" type="button" value="清空购物车"
								name="settingsubmit"
								onclick="location = 'clear.do';">
						</center>
					</td>
				</tr>
			</tbody>
		</table>

	</body>
</html>



