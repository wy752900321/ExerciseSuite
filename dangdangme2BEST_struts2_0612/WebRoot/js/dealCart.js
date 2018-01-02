		function update(id){
			var pnum =$("#pNum_"+id).val();
			//alert($("#pNum_"+id).val());
			if(pnum==""){
					alert("更新不能为空");
					return;
				}
			var testPnum = /^[0-9]+$/;
			if(!testPnum.test(strip(pnum))){
					alert("格式错误，请输入一个数字!");
					return;
				}
			if(pnum==0){
				alert("不能输入0");
				return;
				}
//			$.post("../cart/UpdateCart.action",{
//				"id":id,"pnum":pnum});
			location = 'UpdateCart.action?id='+id+'&pnum='+pnum;
	//		window.location.href="../cart/ShowCart.action";
			}
		function strip(str){
			return str = str.replace(/(^\s*)|(\s*)/, '');
		}