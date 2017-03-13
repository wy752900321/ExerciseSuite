<%@page contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
	<script>
	  function updateButton(bookId,updateCount){
				  var reg=/^\d+$/;
				  if(!reg.test(updateCount)){
			    	alert("修改数量必须是正数！");
		             }
		  window.location='${pageContext.request.contextPath}/cart/cartAction!update?book.id='+bookId+'&updateCount='+updateCount;
		}
	</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath}/images/pic_myshopping.gif" />
		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div>
			</div>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
<s:iterator value="cartItems" var="cartItem">
  <s:if test="#cartItem.flag==false">
						<tr class='td_no_bord'>
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#">
								  <s:property value="#cartItem.book.productName"/>
								</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">
								  <s:property value="#cartItem.book.fixedPrice"/>
								</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>
								￥<s:property value="#cartItem.book.dangPrice"/>
								</span>
							</td>
						
							<td>
								<input class="del_num" type="text" size="3" maxlength="4" value="<s:property value="#cartItem.count"/>" id="<s:property value="#cartItem.book.id"/>"/>
									<a href="#" onclick="updateButton(<s:property value="#cartItem.book.id"/>,
											document.getElementById('<s:property value="#cartItem.book.id"/>').value)">变更</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart/cartAction!delete?book.id=<s:property value="#cartItem.book.id"/>">删除</a>
							</td>
						</tr>
  </s:if>
</s:iterator>						
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
					
						<a href='${pageContext.request.contextPath}/mainAction'> 继续挑选商品&gt;&gt;</a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> 
							￥<span id="total_economy">
							<s:property value="#session.save"/>
							
							
							</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> 
							   ￥<span id='total_account'>
							       <s:property value="#session.sumPrice"/>
							    </span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${pageContext.request.contextPath}/cart/cartAction!toOrder' > 
								<img src="${pageContext.request.contextPath}/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
					
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->
<span style="color: red;">
						<s:property value="errorMsg"/>
						</span>

		<div id="divCartItemsRemoved" class="del_merch">
		
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			
			<table class=tabl_del id=del_table>
				<tbody>
<s:iterator value="cartItems" var="cartItem">
  <s:if test="#cartItem.flag==true">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">
             <s:property value="#cartItem.book.productName"/>
          </a>
						</td>
						<td width="106" class=buy_td_5>
							￥<s:property value="#cartItem.book.fixedPrice"/>
						</td>
						<td width="134" class=buy_td_4>
							<span>￥<s:property value="#cartItem.book.dangPrice"/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/cartAction!recover?book.id=<s:property value="#cartItem.book.id"/>&b=true">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
					</s:if>
</s:iterator>
				</tbody>
			</table>
			
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



