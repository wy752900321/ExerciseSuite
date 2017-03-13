<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<!-- 数据头右侧 -->
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="../user/help.jsp" title="我的当当" name="mydangdang" class="head_black12a">我的当当</a> | <a
					href="../user/help.jsp" title="需要帮助吗？" name="helpcenter" class="head_black12a">帮助</a>
					| </span><span style="color:green" id="txt"></span></span>
			<div class="cart gray4012">
				<a href="../cart/cart_list.action" title="查看购物车">购物车</a>
			</div>
		</div>
		<!-- 用户状态显示 -->
		<span class="head_toutext" id="logininfo"> <s:if
				test="#session.user!=null">
				<b>您好，欢迎${user.nickname}光临当当网</b>
		[&nbsp;<a href="javascript:;" title="登出" onclick="logout();" class="b">登出</a>&nbsp;]
		</s:if> <s:else>
				<b>您还没有登录当当网,请</b>
		[&nbsp;<a href="../user/login_form.jsp" title="点此登录" class="b">登录</a>|<a
					href="../user/register_form.jsp" title="点此去注册" class="b">注册</a>&nbsp;]
		</s:else></span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="../main/main.jsp" title="回到首页" name="backtobook"><img
						src="../images/booksaleimg/book_logo.gif" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
