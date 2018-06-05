<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息页面</title>
<style type="text/css">
.div_content{
width: 100%;
height: 35px;
line-height: 35px;
}
.spqn_left {
	width: 100px;
	text-align: right;
	height: 35px;
	line-height: 35px;
	position: relative;
	float: left;
}

.spqn_right {
	width: 200px; 
	height : 35px;
	line-height: 35px;
	position: relative;
	float: left;
	height: 35px;
}

.image_div {
	width: 150px;
	height: 200px;
	padding-left: 40px;
}

.imageStyle {
	width: 150px;
	height: 200px;
}
</style>

</head>
<body>
	<%
		String UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
	%>
	<script type="text/javascript">
		$(function() {
			var userName = $("#usernamecookie").text();
			var data = {
				"user" : userName
			};
			$.post("../GetUserInfoAll", data, function(data, status) {
				if (data != "ERROR") {
					var jsondata = JSON.parse(data);
					$("#URL").attr("src", jsondata[0].URL);
					//src 属性可以使用全地址
					/* $("#URL").attr("src", 'http://localhost:8080/test_stroe/image/base.png'); */
					$("#ACCOUNT_ID").text(jsondata[0].ACCOUNT_ID);
					$("#ACCOUNT").text(jsondata[0].ACCOUNT);
					$("#PASSWORD").text(jsondata[0].PASSWORD);
					$("#FULL_NAME").text(jsondata[0].FULL_NAME);
					$("#TEL").text(jsondata[0].TEL);
					$("#EMAIL").text(jsondata[0].EMAIL);
					$("#COUNTRY").text(jsondata[1].COUNTRY);
					$("#PROVINCE").text(jsondata[1].PROVINCE);
					$("#CITY").text(jsondata[1].CITY);
					$("#STREET").text(jsondata[1].STREET);
					$("#ADDRESSEXTRA").text(jsondata[1].ADDRESSEXTRA);
				}
			});
		})
	</script>
	<p id="usernamecookie" style="display: none;"><%=UserLoginName%></p>
	<div>
		<div class="image_div">
			<img alt="在线书城" id="URL" class="imageStyle">
		</div>
		<div>
			<div class="div_content">
				<div class="spqn_left">
					<span>账号id：</span>
				</div>
				<div class="spqn_right">
					<span id="ACCOUNT_ID"></span>
				</div>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>账号别名：</span>
				</div>
				<span id="ACCOUNT"></span>
			</div>
			<div class="div_content" style="display: none;">
				<div class="spqn_left">
					<span>账号密码：</span>
				</div>
				<span id="PASSWORD"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>真实姓名：</span>
				</div>
				<span id="FULL_NAME"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>电话号码：</span>
				</div>
				<span id="TEL"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>邮箱：</span>
				</div>
				<span id="EMAIL"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>国家：</span>
				</div>
				<span id="COUNTRY"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>省份：</span>
				</div>
				<span id="PROVINCE"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>市级：</span>
				</div>
				<span id="CITY"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>街道：</span>
				</div>
				<span id="STREET"></span>
			</div>
			<div class="div_content">
				<div class="spqn_left">
					<span>详细地址：</span>
				</div>
				<span id="ADDRESSEXTRA"></span>
			</div>
		</div>
	</div>
</body>
</html>