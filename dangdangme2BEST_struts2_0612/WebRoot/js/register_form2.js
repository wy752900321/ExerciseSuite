//表示表单各项是否通过检查，
		//通过了检查设置为true，否则设置为false
		var checkflag={'email':false,
		'nickname':false,'password':false};
		$(function(){
			$('#txtEmail').blur(function(){
			//checkflag.email=false;
				var email=$('#txtEmail').val();
				$('#email\\.info').html('');
				if(email==""){
				$('#email\\.info').html('邮箱不能为空');
				}else{
					var pattern=/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
					if(!pattern.test(email)){
						$('#email\\.info').html('邮箱格式错误');
					}else{
					$.post('validEmail.action',{'email' : email},
					function(ok){
						if(ok){
						checkflag.email=true;
						$('#email\\.info').html("<img src='../images/label3.gif'/>");
						}else{
						$('#email\\.info').html('邮箱已被占用');
						}
					}); 
					}
				}
			});
		});
		//昵称:		您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符，一个汉字为两个字符。
		$(function(){
			$('#txtNickName').blur(function(){
			//alert('-----');
			checkflag.nickname=false;
				var nickName=$('#txtNickName').val();
				$('#name\\.info').html('');
				if(nickName==""){
				$('#name\\.info').html('昵称不能为空');
				
				}else{
					var pattern=/^([\u4E00-\u9FA5]|[a-z0-9]{2}){2,10}$/;
				
					if(!pattern.test(nickName)){
						$('#name\\.info').html('输入错误');
					}else{
					checkflag.nickname=true;
					$('#name\\.info').html("<img src='../images/label3.gif'/>");
					}
				}
			});
		});
		var pwd=null;
		//设置密码：您的密码可以由大小写英文字母、数字组成，长度6－20位。
			$(function(){
			$('#txtPassword').blur(function(){
			checkflag.password=false;
			//alert('-----');
				var nickName=$('#txtPassword').val();
				$('#password\\.info').html('');
				if(nickName==""){
				$('#password\\.info').html('密码不能为空');
				
				}else{
					var pattern=/^[A-Za-z0-9]{6,20}$/;
				
					if(!pattern.test(nickName)){
						$('#password\\.info').html('密码格式错误');
					}else{
					pwd=$('#txtPassword').val();
					checkflag.password=true;
					$('#password\\.info').html("<img src='../images/label3.gif'/>");
					}
				}
			});
		});
		
	
		//再次设置您的密码：
		$(function(){
			$('#txtRepeatPass').blur(function(){
			var repwd=$('#txtRepeatPass').val();
			$('#password1\\.info').html('');
			if(repwd==""){
			$('#password1\\.info').html('请确认密码从新输入');
			}else{
				if(repwd==pwd){
				$('#password1\\.info').html("<img src='../images/label3.gif'/>");
				}else{
				$('#password1\\.info').html('请确认密码');
				}
			}
			});
		});
		//验证码：
		var yan=false;
	$(function(){
				$("#noSee").click(function(){
				yan=false;
					$("#imgVcode").attr(
						  "src",
				         "image.action?dt="+ new Date().getTime()
						);
						return false;
				});
				//ajax检查
				$("#txtVerifyCode").blur(function(){
				//alert('----');
					$.post(
						"validImage.action",
						{"code":$("#txtVerifyCode").val()},
						function(ok2){
							if(ok2){
							yan=true;
							    $("#number\\.info").html("<img src='../images/label3.gif'/>");
							}else{
								$("#number\\.info").html("验证码错误");
								$("#noSee").click();
							}
						}
					);
				});
				
			});
		
		//表单提交处理
		//form的onsubmit事件，
		//return true允许提交，否则阻止提交
		$(function(){
			$('#f').submit(function(){
			$('#txtEmail').blur();
			$('#txtPassword').blur();
			//alert('确认提交');
			return checkflag.email&&checkflag.nickname&&checkflag.password&&yan;
			});
		});
		/* jquery.validate正确方法
	$(function(){
		$("#f").validate({
			errorPlacement : function(error, element) {
			error.appendTo(element.parent().find("span"));
				},
			rules: {
				'user.email': {
					required : true,
					email :true,
					remote : "validateEmail.action"
				},
				'user.nickname' :{
					required : true,
					minlength :4,
					maxlength :20
				},
				'user.password' :{
					required : true,
					minlength : 4,
					maxlength : 20
				},
				password1 :{
					equalTo : "#repassword"
				},
				number :{
					required :true,
					remote : 'validateImgVcode.action'
				}
			},
			success : function(label) {
			label.html("<img src='../images/label3.gif'/>");
			},
			messages: {
				'user.email': {
					required : 'email不能为空',
					email :'email格式不正确',
					remote : 'emael 已经被注册'
				},
				'user.nickname' :{
					required : '昵称不能为空',
					minlength :'最小长度不能小于2',
					maxlength : '最大长度不能大于15'
				},
				'user.password' :{
					required : '密码不能为空',
					minlength : '密码长度不能小于2',
					maxlength : '密码长度不能大于15'	
				},
				password1 :{
					equalTo : '两次密码输入不一致'
				},
				number :{
					required :'验证码 不能为空',
					remote : '验证码错误'
				}
		}
	});
	});*/