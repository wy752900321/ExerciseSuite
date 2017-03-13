<%@ page language="java" pageEncoding="utf-8"  contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>练习</title>
<style type="text/css">
<!--
body {
	margin-left: 30px;
	margin-top: 15px;
	margin-right: 15px;
	margin-bottom: 15px;
	background-attachment: fixed;
	background-image: url(admin/images/downbg.gif);
	background-repeat: no-repeat;
	background-position: right bottom;
}
-->
</style>
</head>
  <body>
	<!-- 什么情况下回产生表单重复提交
	    * 由于服务器运行缓慢,或者由于网络延迟,连续点击保存按钮,此时也是表单重复提交
	      * 可以使用Thread.sleep(5000);模拟网络延迟.
	
	    * 表单重复提交,在转发过程中能发生
	         * 点击"保存"按钮,保存信息到数据库中,转发到success.jsp页面,再该页面刷新是表单重复提交
	         * 点击"保存"按钮,保存信息到数据库中,转发到success.jsp页面,点击浏览器上的"后退[历史记录]"
                 返回到添加信息的页面,再点击"保存"按钮，此时是表单重复提交	 
             * 点击"保存"按钮,保存信息到数据库中,转发到success.jsp页面,点击浏览器上的"后退[历史记录]"  
                 返回到添加信息的页面,刷新该页面,在保存,此时不是表单重复提交 
	     
	    * 冲定向不会产生表单重复提交。
	
	 -->
	
	<!-- 
	    如果使用javaScript函数提交表单的话
	       * type="button"  button按钮,没有提交功能,必须手动提交
	          这里会提交1次      
	       * type="submit" :submit本身有提交功能,会自动提交表单
	          这里会提交两次          
	
	       
	       * 如何设置type="submit"按钮的自动提交功能失效
	             * onsubmit=" return false" 
	  
	 -->
	
	<form name="form1" action="${pageContext.request.contextPath}/saveEmpServlet" method="post" onsubmit=" return false" >
     		<table width="90%" border="0">
              <tr>
                <td width="100" align="center" >用户名：</td>
		           <td><input name="name" type="text"  value='' />
                </td>
			   </tr>
			   
                <tr>
                <td width="100" >&nbsp;</td>
		           <td><input  type="submit"  value="保存"  onclick="check()"/>
                </td>
				</tr>
				</table>
	</form>
	</body>
	<script type="text/javascript">
	  //如果flag=false,允许提交表单,flag=true不允许提交表单
	  var flag=false;
	  
	  function check(){
	    if(!flag){
	      flag=true;
	      document.forms[0].submit();
	    }else{
	       alert("表单重复提交了");
	    }
	  }	
	</script>
	
</html>
