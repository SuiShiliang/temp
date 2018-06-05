<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet"
	href="../bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="../css/login.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线书店</title>
</head>
<body onload="loadreg()">
	<!-- <div class="div_button"  onclick='location.href="html/userInfo.jsp"'>登录</div> -->
	<!-- <div class="div_button"  onclick='window.open("html/userInfo.jsp")'>登录</div> -->
	<form id="reg">
		<div class="body_div">
			<div class="top_div">账号登录</div>
			<div class="bottom_div">
				<div class="login_lableTip_div">
					<label class="login_lableTip">账号或密码不正确</label>
				</div>
				<!-- 账号 -->
				<div class="content_div">
					<label class="lable_tip" id="userlable" for="user">*账号(1~16个字符，只可使用数字、字母、汉字)</label>
					<!-- onkeyup表示输入的只能是字母数字和汉字 -->
					<input id="user" class="input_base" name="user" onfocus="useron()"
						onblur="useroutreg()" oninput="useriput()"
						onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g, '')">
				</div>
				<!-- 密码 -->
				<div class="content_div">
					<!-- onfocus：表单被选择时操作，  onblur：离开表单时操作，oninput：表单输入时操作 -->
					<label class="lable_tip" id="pwdlable" for="pwd">*密码(1~16个字符，只可使用数字、字母)</label>
					<!-- onkeyup中表示只能输入字母和数字 -->
					<input id="pwd" class="input_base" name="pwd" onfocus="pwdon()"
						onblur="pwdout()" oninput="pwdiput()"
						onkeyup="value=value.replace(/[\W]/g,'')">
				</div>
				<!-- 邮箱 -->
				<div class="content_div">
					<!-- onfocus：表单被选择时操作，  onblur：离开表单时操作，oninput：表单输入时操作 -->
					<label class="lable_tip" id="maillable" for="mail">邮箱地址</label>
					<!-- onkeyup中表示只能输入字母和数字 -->
					<input id="mail" class="input_base" name="mail" onfocus="mailon()"
						onblur="mailout()" oninput="mailiput()">
				</div>
				<div class="content_div">
					<input type="button" class="input_btn" value="注册" onclick="reg()">
				</div>
			</div>
		</div>
	</form>
</body>
</html>