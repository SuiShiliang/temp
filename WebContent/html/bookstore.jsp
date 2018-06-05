<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="../bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/bookstore.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript"
	src="../bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bookstore.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线书店</title>
</head>
<!-- onload="loadhtml()" -->
<body onload="loadhtml()">
	<%
		String UserLoginName = "";
		if(null != request.getSession().getAttribute("UserLoginName")){
			UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
		}
		else{
			Cookie[] cookies = request.getCookies();
			for(Cookie co : cookies){
				if(co.getName().equals("bookstoreUserLoginName")) {
					UserLoginName = co.getValue();
				}
			}
		}
	%>
	<div class="div_body">
		<!-- 导航栏 -->
		<div class="div_navigation">
			<div class="div_navigation_item">
				<a href="../html/CustomerService.jsp"><span>联系客服</span></a>
			</div>
			<div class="div_navigation_item">
				<a href="../html/ShoppingCart.jsp"><span>购物车</span></a>
			</div>
			<div class="div_navigation_Loginitem">
				<a href="../html/userinfo.jsp"><span>欢迎登录，<%=UserLoginName %></span></a>
			</div>
		</div>
		<!-- 主页图片推荐栏 -->
		<div class="div_recommend">
			<div class="div_recommend_image">
				<img src="../image/online.png" class="div_recommend_image1">
			</div>
		</div>
		<!-- 搜索栏 -->
		<div class="dvi_search">
			<div class="dvi_search_content">
				<input type="text" id="search" class="dvi_search_input"> <input
					type="button" onclick="search()" class="dvi_search_button"
					value="搜索">
			</div>
		</div>
		<!-- 书籍栏 -->
		<div class="div_book">
			<div class="div_booKs" id="books">
				<!-- <div class="div_book_content" id="row1Father">
					<div class="div_book_info">
						传入this，代表传入的是当前元素，可以直接操作
						<img id="img1" src="../image/bookbase.png"
							onmouseover="showItem(this)" onmouseout="hideItem(this)"
							onclick="getBookInfo(this)" class="div_image">
						<div class="div_introduce">
							<span>商品简介</span>
						</div>
						<div class="div_store">
							<span>商品价格</span>
						</div>
						<div class="div_store">
							<span>店家</span>
						</div>
						<div class="div_introduce1" id="img1Introduce">
							<span >商品详细介绍</span>
						</div>

					</div>
				</div> -->
			</div>
			<div class="dvi_ul">
				<ul class="dvi_ul">
					<li class="div_li" onclick="setPageFirst()">首页</li>
					<li class="div_li" onclick="setPagePrevious()">上一页</li>
					<li class="div_li" onclick="setPageNext()">下一页</li>
					<li class="div_li" onclick="setPageLast()">尾页</li>
					<li class="div_li"><input class="div_li_input" id="bookpage" onkeyup="value=value.replace(/[^\d]/g,'')"></li>
					<li class="div_li div_li_button" onclick="getBookOnpage()">跳转</li>
					<li class="div_li">共<span id="pageCount"></span>页</li>
					<li class="div_li">第<span id="page" >1</span>页</li>
				</ul>
				<!-- <p id="page" style="visibility: hidden;">1</p> -->
				<!-- <p id="page">1</p> -->
			</div>
		</div>
		<!-- 版权栏 -->
		<div class="div_copyright">
			<span>Copyright © 2002-2018 All Rights Reserved版权所有 在线书城有限公司</span>
		</div>
	</div>

</body>
</html>