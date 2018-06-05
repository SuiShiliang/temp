function loadhtml() {
	getBooks();
	getBookPageCount();
}
//从后台获取到数据后，进行书籍添加操作
function setBooks(data){
	$("#row1Father").remove();
	var jsondata = JSON.parse(data);
	var html = '<div class="div_book_content" id="row1Father">';
	for (var i = 0; i < jsondata.length; i++) {
		html += '<div class="div_book_info">' + '<img id="img' + jsondata[i].ID
				+ '" src="'+jsondata[i].URL+'"'
				+ 'onmouseover="showItem(this)" onmouseout="hideItem(this)"'
				+ 'onclick="getBookInfo(this)" class="div_image">'
				+ '<div class="div_introduce"><span>' +  jsondata[i].BOOKS_NAME
				+ '</span></div>' + '<div class="div_store"><span>￥' 
				+ jsondata[i].SELLING_PRICE + '元</span></div>' + '<div class="div_store">' + '<span>'
				+ "店家:在线书城" + '</span></div>'
				+ '<div class="div_introduce1" id="img' + jsondata[i].ID + 'Introduce">'
				+ '<span >'  + jsondata[i].INTRODUCTION + '</span></div></div>';
	}
	html += '</div>';
	$("#books").append(html);

}
function getBooks() {
	var pagedata = $("#page").text();
	var page = {"pageNum":pagedata};
	$.post("../GetBookList", page, function(data, status) {
		if(data != "null"){
			setBooks(data);
		}
		else{
			alert("已经是最后一页了！")
		}
	});
}
// 显示书籍介绍
function showItem(item) {
	// $(item)[0].id得到当前组件的id
	var item1 = '#' + $(item)[0].id + 'Introduce';
	$(item1).css("display", "block")
	// 显示当前的块,
	// 使用jQuery应该用$(item).css("visibility","visible")代替$(item).style.visibility="visible";

}
// 隐藏书籍介绍
function hideItem(item) {
	var item1 = '#' + $(item)[0].id + 'Introduce';
	$(item1).css("display", "none")
}
// 点击书籍图片跳转页面
function getBookInfo(item) {
	var id = $(item)[0].id;
	var imgid = id.substring(3);
	window.location.href = "bookInfo.jsp?bookId="+imgid;
}
//获取数据分页数量
function getBookPageCount(){
	$.post("../GetBookPageCount",function(data,status){
		$("#pageCount").text(data);
	});
}
//首页
function setPageFirst(){
	$("#page").text("1");
	getBooks();
}
//上一页
function setPagePrevious(){
	var pagedata = $("#page").text();
	if(pagedata>1){
		var nowpage = parseInt(pagedata) - 1;
		$("#page").text(nowpage);
	}
	getBooks();
}
//下一页
function setPageNext(){
	var pagedata = $("#page").text();
	var pageall = $("#pageCount").text();
	if(pagedata < pageall){
		var nowpage =  parseInt(pagedata) + 1;
		$("#page").text(nowpage);
	}
	getBooks();
}
//最后一页
function setPageLast(){
	var pagedata = $("#pageCount").text();
	$("#page").text(pagedata);
	getBooks();
}
//跳入到指定的页数
function getBookOnpage(){
	var pageall = $("#pageCount").text();
	var pagenow = $("#bookpage").val();
	if(pageall >= pagenow && pagenow != ""){
		$("#page").text(pagenow);
	}
	getBooks();
}
//搜索书籍
function search(){
	var bookvalue = $("#search").val();
	var bookname = {"bookname":bookvalue};
	$.post(
			"../GetBooksListForSerch",bookname,function(data,status){
				if(data  == "NULL"){
					$("#row1Father").remove();
					var html = '<div class="div_book_content" id="row1Father">';
					html += '<span>未找到书籍<span></div>';
					$("#books").append(html);
				}else {
					setBooks(data);
				}
			}
	);
}
