//用户信息页面
function userInfo(){
	$("#UserinfoIframe").attr("src","userInfo1.jsp");
}
//更改用户信息页面
function updateUserInfo(){
	$("#UserinfoIframe").attr("src","updateUserInfo.jsp");
}
//更改用户地址页面
function address(){
	$("#UserinfoIframe").attr("src","address.jsp");
}
//添加或修改书籍
function addBook(){
	$("#UserinfoIframe").attr("src","addBook.jsp");
}
//注销并跳转到注册页面
function loginout(){
	$.post("../SetCookieInvalid",function(data,status){
		if(status == "success")
			window.location.href = "../index";
	});
}
//跳转到注册页面
function goRegJsp(){
	window.location.href = "reg.jsp";
}