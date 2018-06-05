<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="../bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="../css/bookstore.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bookstore.js"></script>
<script type="text/javascript" src="../js/bookInfo.js"></script>
<link rel="stylesheet" href="../css/bookinfo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详细信息</title>
</head>
<body onload="load()">
	<%
		String bookId = request.getParameter("bookId");
		String UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
	%>
	<span id="bookid" style="display: none;"><%=bookId%></span>

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
				<a href="../html/userinfo.jsp"><span>欢迎登录，<%=UserLoginName%></span></a>
			</div>
			<div class="div_navigation_item">
				<a href="../html/bookstore.jsp"><span>首页</span></a>
			</div>
		</div>

		<!-- 书籍基本信息 -->
		<div class="book_content_div">
			<div class="book_info_div">
				<div class="book_content_title_div">
					<span id="bookname"></span>&nbsp;图书详细信息
				</div>
				<div class="book_info_image">
					<img class="book_info_image" alt="在线书城" id="bookimage">
				</div>
				<div class="book_info_right_div">
					<p ><span id="RECOMMEND"></span></p>
					<br>
					<br>
					<p >单　　价: ￥<span id="SELLING_PRICE"></span></p>
					<p >销售数量: <span id="SALES_QUANTITY"></span></p>
					<p >作　　者: <span id="NAME"></span></p>
					<p >出 版 社: <span id="BOOK_CONCERN"></span></p>
					<p >出版时间: <span id="BOOKDATE"></span></p>
					<p >ＩＳＢＮ: <span id="ISBN"></span></p>
					<br>
					<p style="text-align: right;"><span class="book_shopping_buuton" onclick="shoopingcat()">加入购物车</span></p>
				</div>
			</div>
		</div>
		<!-- 书本内容介绍 -->
		<div class="book_content_div">
			<div class="book_content_title_div">内容介绍</div>
			<div class="book_info_div1">
				<p id="INTRODUCTION"></p>
			</div>
		</div>
		<!-- 作者简介 -->
		<div class="book_content_div">
			<div class="book_content_title_div">作者简介</div>
			<div class="book_info_div1">
				<p id="AUTHORS_INTRODUCTION"></p>
			</div>
		</div>
		<!-- 书籍目录 -->
		<div class="book_content_div">
			<div class="book_content_title_div">章节目录</div>
			<div class="book_info_div1"  id="BOOK_CHAPTERS_NAME">
			</div>
		</div>

		<!-- 版权栏 -->
		<div class="div_copyright">
			<span>Copyright © 2002-2018 All Rights Reserved版权所有 在线书城有限公司</span>
		</div>
	</div>


</body>
</html>