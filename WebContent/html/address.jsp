<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/address.css">
<script type="text/javascript" src="../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/address.js"></script>
<title>地址管理页面</title>
</head>
<body onload="addressOnload()">
	<%
		String UserLoginName = request.getSession().getAttribute("UserLoginName").toString();
	%>
	<p id="UserLoginName" style="display: none;"><%=UserLoginName %></p>
	<table id="userAddressManageTable" class="table_class">
	
	</table>
	<input onblur="temp(this)">
</body>
<script type="text/javascript">
	function temp(id){
			$(id).val();
		}
</script>
</html>