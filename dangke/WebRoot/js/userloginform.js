var checkFlag = {
	"email" : false,
	"password":false
};
 $(function() {
        //判断邮箱格式是否正确
	  $("#txtUsername")
			.blur(function() {
				$("#loginMessage").html("").css("color","red");
				checkFlag.email=false;
				$("#emailMsg").html("");
				var email = $("#txtUsername").val();
					//邮箱非空检查
					if (email == "") {
						$("#emailMsg").html("邮箱不能为空！").css("color","red");
						return;
					}
					//邮箱格式检查
					var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
					if (!pattern.test(email)) {
						$("#emailMsg").html("邮箱格式不正确！").css("color","red");
						return;
					}
					checkFlag.email=true;
       });
 
 		$("#txtPassword").blur(function(){
 				$("#loginMessage").html("");
 			 $("#passwordMsg").html("");
 				checkFlag.password=false;
 			  var pwd = $("#txtPassword").val();
 			  if(pwd==""){
 				  	$("#passwordMsg").html("密码不能为空！").css("color","red");
 				  	return;
 			  }
 			  checkFlag.password=true;
 		});
 		
 		$("#ctl00").submit(function(){
 			var b = checkFlag.email&&checkFlag.password;
 			if(b==false){
 				return false;
 			}else{
 				return true;
 			}
 		});
 });