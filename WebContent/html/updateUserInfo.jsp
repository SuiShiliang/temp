<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/uploadInfo.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/updateInfo.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
</head>
<body>
	<%
		String UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
	%>
	<p id="usernamecookie" style="display: none;"><%=UserLoginName%></p>
	<div>
		<div class="image_div">
			<p id="imageFlag" style="display: none;">0</p>
			<img alt="在线书城" id="URL" class="imageStyle">
			<form id="uploadFileForm" enctype="multipart/form-data">
				<input type="file" name="imageFile" accept="image/*"
					onchange="setImage()" id="imageInout">
			</form>
		</div>
		<div>
		<p id="tempdata" style="display: none;"></p>
			<form id="userInfoForm">
				<div class="div_content">
					<div class="spqn_left">
						<span>账号id：</span>
					</div>
					<div class="spqn_right">
						<input id="ACCOUNT_ID" readonly="readonly" name="ACCOUNT_ID"/>
					</div>
				</div>
				<div class="div_content">
					<div class="spqn_left">
						<span>账号别名：</span>
					</div>
					<input id="ACCOUNT" name="ACCOUNT" onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g, '')"/>
				</div>
				<div class="div_content">
					<div class="spqn_left">
						<span>账号密码：</span>
					</div>
					<input id="PASSWORD" name="PASSWORD" onkeyup="value=value.replace(/[\W]/g,'')"/>
				</div>
				<div class="div_content">
					<div class="spqn_left">
						<span>真实姓名：</span>
					</div>
					<input id="FULL_NAME" name="FULL_NAME"/>
				</div>
				<div class="div_content">
					<div class="spqn_left">
						<span>电话号码：</span>
					</div>
					<input id="TEL" name="TEL"/>
				</div>
				<div class="div_content">
					<div class="spqn_left">
						<span>邮箱：</span>
					</div>
					<input id="EMAIL" name="EMAIL"/>
				</div>
				<div>
					<input type="button" value="确定" onclick="updateInfo()">
				</div>
			</form>
		</div>
	</div>
</body>
</html>