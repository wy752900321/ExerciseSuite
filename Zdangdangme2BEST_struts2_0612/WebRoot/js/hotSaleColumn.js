function hotSale(){
	$.post("../main/newHotBooks.action",function(newHotBooks) {
		var books = newHotBooks;
		for ( var i = 0; i < books.length; i++) {
				var newElement1 = document.createElement("a");
				var newElement2 = document.createElement("br");
				var b=books[i].split("**");
				for(var j=0;j<b.length;j++){
					newElement1.href="../main/bookDiscription.action?bookId="+b[0];
					newElement1.innerHTML=b[1]+" 销量："+b[2];
				}
					$("#hotSaleBooks").before(newElement1);
					$("#hotSaleBooks").before(newElement2);
//				var newElement1 = document.createElement("a");
//				var newElement2 = document.createElement("br");
//				newElement1.innerHTML = books[i];		
//				$("#hotSaleBooks").before(newElement1);
//				$("#hotSaleBooks").before(newElement2);
		}
	});
}