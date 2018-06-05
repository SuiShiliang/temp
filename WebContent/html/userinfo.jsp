<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/userinfo.css">
<link rel="stylesheet"
	href="../bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="../css/bookstore.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/userinfo.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	<%
		String UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
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
				<a href="../html/userinfo.jsp"><span>欢迎登录，<%=UserLoginName%></span></a>
			</div>
			<div class="div_navigation_item">
				<a href="../html/bookstore.jsp"><span>首页</span></a>
			</div>
		</div>
		<div class="book_content_div">
			<div class="userInfo_left">
				<div class="userInfo_left1">
					<p class="userInfo_leftP">个人信息管理</p>
					<p onclick="userInfo()"><span class="userInfo_left_span btn btn-success">查看个人信息</span></p>
					<p onclick="updateUserInfo()"><span class="userInfo_left_span btn btn-success">修改个人信息</span></p>
					<p onclick="address()"><span class="userInfo_left_span btn btn-success">地址管理及用户管理</span></p>
					<p onclick="addBook()"><span class="userInfo_left_span btn btn-success">修改或添加书籍</span></p>
					<p onclick="loginout()"><span class="userInfo_left_span btn btn-success">注销登录</span></p>
					<p onclick="goRegJsp()"><span class="userInfo_left_span btn btn-success">注册</span></p>
				</div>
			</div>
			<div class="userInfo_right">
				<iframe id="UserinfoIframe" class="userInfo_Iframe" frameborder="0" src="userInfo1.jsp">
					
				</iframe>
			</div>
		</div>
		<!-- 版权栏 -->
		<div class="div_copyright1">
			<span>Copyright © 2002-2018 All Rights Reserved版权所有 在线书城有限公司</span>
		</div>
	</div>
</body>
</html>