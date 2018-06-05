function load() {
	var id = $("#bookid").text();
	var bookid = {
		"bookid" : id
	};
	$.post("../GetBookInfoById", bookid,
			function(data, status) {
				if (data != "null") {
					var jsondata = JSON.parse(data);
					$("#bookimage").attr("src", jsondata.URL);
					$("#bookname").text(jsondata.NAME);
					$("#RECOMMEND").text(jsondata.RECOMMEND);
					$("#SELLING_PRICE").text(jsondata.SELLING_PRICE);
					$("#SALES_QUANTITY").text(jsondata.SALES_QUANTITY);
					$("#NAME").text(jsondata.NAME);
					$("#BOOK_CONCERN").text(jsondata.BOOK_CONCERN);
					// 将传来的json中的时间对象转换成对应的时间
					var datss = new Date(jsondata.BOOKDATE.time)
					// toLocaleDateString() 函数只输出年月日
					// "/ /"为正则表达式的格式
					$("#BOOKDATE").text(
							datss.toLocaleDateString().replace(/\//g, '-'));
					$("#ISBN").text(jsondata.ISBN);
					
					$("#INTRODUCTION").text(jsondata.INTRODUCTION);
					if(null == jsondata.AUTHORS_INTRODUCTION)
						$("#AUTHORS_INTRODUCTION").text("作者未作任何自我介绍哦");
					else
						$("#AUTHORS_INTRODUCTION").text(jsondata.AUTHORS_INTRODUCTION);
				} else {
					alert("未找到任何书籍")
				}
			});
	$.post("../GetBookChaptersById", bookid, function(data, status) {
		if(data == "NULL"){
			$("#BOOK_CHAPTERS_NAME").append("<p>未找到此书的目录</p>");
		}
		else {
			var jsondata = JSON.parse(data);
			var html = "";
			for(var a in  jsondata){
				html += "<p>"+jsondata[a].BOOK_CHAPTERS_NAME+"</p>";
			}
			$("#BOOK_CHAPTERS_NAME").append(html);
		}
	});
}
