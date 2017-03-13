public class Struts_token {
	/**
	  <s:token />标签防止重复提交，用法如下： 
	  第一步：在表单中加入
	  <s:token />
	   <s:form action="helloworld_other" method="post" namespace="/test">
	    <s:textfield name="person.name"/>
	    <s:token/><s:submit/> </s:form>
	   第二步：
	    <action name="helloworld_*" class="cn.itcast.action.HelloWorldAction" method="{1}"> 
	    <interceptor-ref name="defaultStack"/> 
	    <!-- 增加令牌拦截器 -->
	  <interceptor-ref name="token"> 
	  <!-- 哪些方法被令牌拦截器拦截 -->
	   <param name=“includeMethods">save</param>          
	    </interceptor-ref>             
	     <!-- 当表单重复提交转向的页面 -->
	  <result name="invalid.token">/WEB-INF/page/message.jsp</result> </action>
	  以上配置加入了“token”  拦截器和“invalid.token”结果，因为“token”拦截器在会话的token与请求的token不一致时，
	  将会直接返回 “invalid.token”结果。
	  在debug状态,控制台出现下面信息,是因为Action中并没有struts.token和struts.token.name属性,
	
	  
	  我们不用关心这个错误：
	   严重: ParametersInterceptor - [setParameters]:
	  Unexpected Exception caught setting 'struts.token' on 'class xxx: Error
	  setting expression 'struts.token' with value '[Ljava.lang.String;@39f16f'
	  严重: ParametersInterceptor - [setParameters]: Unexpected Exception caught
	  setting 'struts.token.name'
	 */
}
