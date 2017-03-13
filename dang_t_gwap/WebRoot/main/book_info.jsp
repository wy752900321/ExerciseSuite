<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>
		<TITLE>图书 - 当当网</TITLE>
		<META http-equiv=Content-Type content="text/html;charset=utf-8">
		<LINK href="../css/dangdang1.css" type=text/css rel=Stylesheet>
		<LINK href="../css/book1.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="../js/jquery-1.4.3.js">
</script>
		<script src="../js/jquery-1.3.2.min.codefans.net.js"
			type="text/javascript">
</script>
		<script src="../js/jqzoom.js" type="text/javascript">
</script>
		<script type="text/javascript">
// 购买
function buy(id) {
	$.post("${pageContext.request.contextPath}/cart/add.action", {
		"id" : id
	}, function(ok) {
		if (ok) {
			$("#cartinfo").html("购买成功").css("color", "green");
		} else {
			$("#cartinfo").html("购买失败").css("color", "red");
		}
	});
}

// 离开购买按钮
function exit() {
	$("#cartinfo").html("");
}

// 放大镜
$(function() {
	$(".jqzoom").jqzoom();
});
</script>
	</HEAD>

	<BODY>
		<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
		<DIV id=div_shield></DIV>
		<DIV id=main></DIV>
		<DIV class=mainsearch></DIV>

		<DIV class=right>
			<DIV class=right_wai>
				<DIV class=shuming>
					<DIV class=shuming_left>
						<SPAN class=black000><A name=top_bk></A> <s:property
								value="book.productName" /> </SPAN>
					</DIV>
					<DIV class=book_case>
						<SPAN class=seriesname>丛书位置：<s:property value="name" />
							&gt;&gt; <s:property value="book.productName" /></SPAN>
					</DIV>
					<DIV class=book_case>
						<SPAN class=seriesname>丛书名：<s:property
								value="book.productName" /> </SPAN>
					</DIV>
					<div>
						<a href="../main/main.jsp" title="回到首页">返回首页</a>
					</div>

					<div>
						<a href="../cart/cart_list.action" title="查看购物车">去购物车查看</a>
					</div>
					<DIV class=empty_box></DIV>
				</DIV>
				<DIV class=book_left>
					<DIV class=book_pic>
						<a href="../productImages/big${book.productPic}" class="jqzoom"
							style="" title="放大后图片"><IMG
								id='<s:property value="book.productPic" />'
								src="../productImages/<s:property value="book.productPic" />" />
						</a>
					</DIV>
					<INPUT id=hid_largepictureurl type=hidden>
				</DIV>
				<DIV class=book_right>
					<DIV id=author_>
						作 者：
						<s:property value="book.author" />
					</DIV>
					<DIV id=publisher_>
						出 版 社：
						<s:property value="book.publishing" />
					</DIV>
					<UL>
						<LI>
							出版时间：
							<s:property value="book.publishDate" />
						</LI>
						<LI>
							字 数：
							<s:property value="book.wordNumber" />
						</LI>
						<LI>
							版 次：
							<s:property value="book.whichEdtion" />
						</LI>
						<LI>
							页 数：
							<s:property value="book.totalPage" />
						</LI>
						<LI>
							印刷时间：
							<s:property value="book.printTime" />
						</LI>
						<LI>
							开 本： 16开
						</LI>
						<LI>
							印 次： ${book.printNumber}
						</LI>
						<LI>
							纸 张： 胶版纸
						</LI>
						<LI>
							I S B N ：
							<s:property value="book.isbn" />
						</LI>
						<LI>
							包 装： 平装
						</LI>
					</UL>
					<DIV class=jiage>
						<SPAN class=gray87>定价：<SPAN class=del id=originalPriceTag>￥
								<s:property value="book.fixedPrice" /> </SPAN> </SPAN>
						<SPAN class=redc30>当当价：￥<B><s:property
									value="book.dangPrice" /> </B> </SPAN> 节省：￥
						<s:property value="book.fixedPrice-book.dangPrice" />
						<DIV class=pd_buy_num>
							<DIV class=clear></DIV>
						</DIV>
						<DIV class=goumai>
							<div style="margin-top: 20px;">
								<div style="float: left;">
									<a id="buyProduct" href="javascript:;" title="添加到购物车"
										onmouseout="exit();"
										onclick="buy(<s:property value="book.id" />)"> <img
											src='../images/buttom_goumai.gif' /> </a>
									<span id="cartinfo_<s:property value="book.id" />"
										style="color: red;"></span>
								</div>

							</div>
							<div style="float: left; padding-left: 10px;">
								<span id="cartinfo"></span>
							</div>
						</DIV>
					</DIV>
					<A title=去购物车查看商品 href="../cart/cartList.action"></A>
				</DIV>
				<DIV id=dvTPUrls></DIV>
				<DIV id=__zhinengbiaozhu_bk>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						编辑推荐
					</H2>
					<DIV class=zhengwen>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！
						<BR>
						――玛丽娅&#8226;蒙台梭利（本书作者）
						<BR>
						<BR>
						今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！
						<BR>
						――塞吉（玛丽娅&#8226;蒙台梭利博士的老师）
						<BR>
						<BR>
						蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。
						<BR>
						――E&#8226;G&#8226;霍尔姆斯（哈佛大学教育学院教授）
					</DIV>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						内容简介
					</H2>
					<DIV class=zhengwen>
						<s:property value="book.description" />
					</DIV>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						作者简介
					</H2>
					<DIV class=zhengwen>
						<s:property value="book.author" />
						<br />
						<s:property value="book.authorSummary" />
					</DIV>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						目录
					</H2>
					<DIV class=zhengwen>
						<s:property value="name" />
						&gt;&gt;
						<s:property value="book.productName" />
					</DIV>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						媒体评论
					</H2>
					<DIV class=zhengwen>
						好，非常畅销!难得的一本好书
					</DIV>
					<DIV class=dashed></DIV>
					<H2 class=black14>
						<IMG src="../images/icon_star.gif" align="middle">
						书摘插图
					</H2>
					<DIV class=zhengwen>
						第2章 对教育方法的历史回顾
						<BR>
						儿童之家使用的教育体系实际上已经向前迈出了一大步。假如人们认为我和正常儿童相处所得的经验相对短暂，那么此经验建立在以往对非正常儿童的教育经验基础之上，因此也代表着一段相当长期的思想。
						<BR>
						假如我们想开发出科学的教育体系，就必须开辟出一条前所未有的新路。教师们必须接受专业培训，同时而学校也必须进行转变。假如教师们都接受了观察与实验的培训，那他们必须在学校里执行这些活动。
						<BR>
						因此，科学教育体系的基本需求是有一个能允许儿童自由发展个性的学校。如果某种教育体系是基于对学生个体的研究，那么其研究方式应该是对行动自由的儿童进行观察和研究，而不是对一个受压制的学生进行观察和研究。
						<BR>
						在人类学和实验心理学的帮助下，在一个人应试教育为主的学校里，开发新型教育方法，是最愚蠢的想法。
						<BR>
						每个领域的实验科学，都是由使用自己独特的方法中发展而来。细菌学起源于分离并培育微生物。犯罪学、医学和教育学也都分别在不同类型的个体上使用过最初的人体测量方法，如在罪犯上、精神病人、医院里的临床病人、学生身上等。实验心理学在开始阶段就要指出执行实验的精确技术。
						<BR>
						……
					</DIV>
				</DIV>
				<A name=review_point></A>
			</DIV>
		</DIV>
		<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
		<DIV id=tag_box_pay
			style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
		<DIV id=div_shield></DIV>
		<!--页尾 开始 -->
		<DIV class=public_footer_add_s></DIV>
		<!--09.3.10new-->
		<!--页尾 end -->
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</BODY>
</HTML>
