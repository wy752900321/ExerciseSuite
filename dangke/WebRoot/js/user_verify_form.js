var checkFlag={
	"code":false
};
$(function(){

		$("#validatecode").blur(function(){
			checkFlag.code=false;
			var checkCode = $("#validatecode").val();
			if(checkCode==""){
				  checkFlag.code=false;
				  $("#errorMsg").html("邮箱验证码不能为空！").css("color","red");
				  return;
			}
			var check = /^[a-f|0-9]{8}-[a-f|0-9]{4}-[a-f|0-9]{4}-[a-f|0-9]{4}-[a-f|0-9]{12}-[0-9]+$/;
			if(!check.test(checkCode)){
				   checkFlag.code=false;
				   $("#errorMsg").html("邮箱验证码有误，请重新输入！").css("color","red");
				   return;
			}
			checkFlag.code=true;	
			$("#errorMsg").html("正确").css("color","green");
		});
	
	  $("#form").submit(function(){
		  		if(checkFlag.code){
						return true;		  			
		  		}else{
		  			return false;
		  		}
	  });
});