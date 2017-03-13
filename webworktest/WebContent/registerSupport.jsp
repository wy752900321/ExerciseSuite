<%@ taglib uri="webwork" prefix="ww" %>
<html>
<head><title>Register Example</title></head>
<body>
<table border=0 width=97%>
<tr><td align="left">
	<ww:form name="'registerSupport'" action="'registerSupport.action'" method="'POST'">
            <ww:textfield label="'Username'" name="'user.username'" required="true"/>
            <ww:textfield label="'Password'" name="'user.password'" required="true"/>
            <ww:textfield label="'VerifyPassword'" name="'verifyPassword'" required="true"/>
            <ww:textfield label="'Email'" name="'user.email'" required="true"/>
            <ww:textfield label="'Age'" name="'user.age'" required="true"/>
            <ww:submit value="'Submit'"/>
         </ww:form>
</td></tr>
</table>
</body>
</html>
