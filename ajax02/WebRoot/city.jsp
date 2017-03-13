<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript"src="js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
			function getXmlHttpReqequest(){
				if((typeof XMLHttpRequest)!='undefined'){
					xhr =new XMLHttpRequest();
				}else{
					xhr = new ActiveXObject('Microsoft.XMLHttp');
				}
				return xhr;
			}
			function change(v1){
				var xhr =getXmlHttpRequest();
				xhr.open('post','/city',true);
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xhr.onreadystatechange=function(){
					//服务器返回yy,岳阳；cs,长沙；hh,怀化
					if(xhr.readyState==4){
						var txt = xhr.responseText;
						var arr =txt.split(';');
						$('s2').innerHTML='';
						for(i=0;i<arr.length;i++){
							var arr1 = arr[i];
							var arr2 =arr1.split(',');
							var op =new Option(arr2[1],arr2[0]);
							$('s2').options[i]=op;
						}
					}
				};
				xhr.send('name='+v1);
			}
		</script>
	</head>
	<body style="font-size: 30px;">	
			<select id="s1" style="width:120px;"onchange="change(this.value);">
				<option value="hn">湖南</option>
				<option value="bj">北京</option>
			</select>
			<select id="s2" style="width:120px;"></select>
	</body>
</html>