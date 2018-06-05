//页面加载时调用此函数
function load() {
	$(".login_lableTip").hide()
	if ($('input[name="user"]')[0].value != "")
		$("#userlable").hide();
	if ($('input[name="pwd"]')[0].value != "")
		$("#pwdlable").hide();

	if ($("#cookiename").text() != "") {
		window.location.href = "html/bookstore.jsp";
	}

}
function loadreg() {
	$(".login_lableTip").hide()
	if ($('input[name="user"]')[0].value != "")
		$("#userlable").hide();
	if ($('input[name="pwd"]')[0].value != "")
		$("#pwdlable").hide();
}

// 页面加载完后调用此函数
/*
 * $(function() { alert("ddd") });
 */
// ajax方法
/*
 * $.ajax({ type:"post", url:"userInfo", data:datas, success:function(data){
 * if(data != "ERROR"){ $(".login_lableTip").hide();
 * $(".login_lableTip").text("用户名已存在") } } });
 */
// 用户账号表单被选择
function useron() {
	$("#userlable").css("color", "#ddd");
}
// 从用户账号表单离开
function userout() {
	$(".login_lableTip").hide();
	/* $("#pwdlable") */
	if ($('input[name="user"]')[0].value == "")
		$("#userlable").show();
	$("#userlable").css("color", "#aaa");
}

// 注册页面，从用户账号表单离开
function useroutreg() {
	if ($('input[name="user"]')[0].value == "")
		$("#userlable").show();
	else {
		var data1 = $("#reg").serializeArray();
		var user = $("#user").val();
		var data2 = {
			"name" : "method",
			"value" : "getUserBaseInfo"
		};
		data1[2] = data2;
		// 页面跳转之后，需要返回上一个目录，才可使用servlet
		$.post("../JudgeUser", data1, function(data, stuts) {

			if (data != "ERROR") {
				$(".login_lableTip").show();
				$(".login_lableTip").text("用户名已存在")
			} else {
				$(".login_lableTip").hide();
			}
		});
	}
	$("#userlable").css("color", "#aaa");
}
// 用户账号表单输入数据
function useriput() {
	$("#userlable").hide();
}

// 密码表单被选择
function pwdon() {
	$("#pwdlable").css("color", "#ddd");
}
// 从密码表单离开
function pwdout() {
	$(".login_lableTip").hide();
	if ($('input[name="pwd"]')[0].value == "")
		$("#pwdlable").show();
	$("#pwdlable").css("color", "#aaa");
}
// 密码表单输入数据
function pwdiput() {
	$("#pwdlable").hide();
}

// 邮箱表单被选择
function mailon() {
	$("#maillable").css("color", "#ddd");
}
// 从邮箱表单离开
function mailout() {
	var mailvalue = $('input[name="mail"]')[0].value;
	if (mailvalue != "") {
		// 判断邮箱格式的正则表达式
		var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		// 正则验证不通过，格式不对
		if (!reg.test(mailvalue)) {
			$(".login_lableTip").text("邮箱格式不正确");
			$(".login_lableTip").show();
		} else {
			$(".login_lableTip").hide();
		}
	}
	$("#maillable").css("color", "#aaa");
}
// 邮箱表单输入数据
function mailiput() {
	$("#maillable").hide();
}

// 判断复选框check是否被选中
// 主页登录
function login() {
	var user = $('input[name="user"]')[0].value;
	var pwd = $('input[name="pwd"]')[0].value;
	if (user == "") {
		$(".login_lableTip").text("用户名为空！")
	} else if (pwd == "") {
		$(".login_lableTip").text("密码为空！")
	} else {
		var data1 = $("#login").serializeArray();
		var datad;
		var user = $("#user").val();
		/*
		 * var data2 = { "name" : "method", "value" : "getUserBaseInfo" };
		 * data1[2] = data2;
		 */
		// 判断是否选择下次自动登录
		if ($(".input_checked_css")[0].checked == true) {
			var data3 = {
				"name" : "checkFlag",
				"value" : "YES"
			};
			data1[2] = data3;
		} else {
			var data3 = {
				"name" : "checkFlag",
				"value" : "NO"
			};
			data1[2] = data3;
		}
		$.post("login", data1, function(data, stuts) {
			if (data == "ERROR") {
				$(".login_lableTip").show();
				$(".login_lableTip").text("账号或密码错误");
			} else {
				location.href = "html/bookstore.jsp";
			}
		});
	}

}
//主页登录
function login1() {
	var user = $('input[name="user"]')[0].value;
	var pwd = $('input[name="pwd"]')[0].value;
	if (user == "") {
		$(".login_lableTip").text("用户名为空！")
	} else if (pwd == "") {
		$(".login_lableTip").text("密码为空！")
	} else {
		var data1 = $("#login").serializeArray();
		var datad;
		var user = $("#user").val();
		/*
		 * var data2 = { "name" : "method", "value" : "getUserBaseInfo" };
		 * data1[2] = data2;
		 */
		// 判断是否选择下次自动登录
		if ($(".input_checked_css")[0].checked == true) {
			var data3 = {
				"name" : "checkFlag",
				"value" : "YES"
			};
			data1[2] = data3;
		} else {
			var data3 = {
				"name" : "checkFlag",
				"value" : "NO"
			};
			data1[2] = data3;
		}
		$.post("../login", data1, function(data, stuts) {
			if (data == "ERROR") {
				$(".login_lableTip").show();
				$(".login_lableTip").text("账号或密码错误");
			} else {
				location.href = "bookstore.jsp";
			}
		});
	}

}
// 注册
function reg() {
	var user = $('input[name="user"]')[0].value;
	var pwd = $('input[name="pwd"]')[0].value;
	if (user == "") {
		$(".login_lableTip").text("用户名为空！")
		$(".login_lableTip").show();
	} else if (pwd == "") {
		$(".login_lableTip").text("密码为空！")
		$(".login_lableTip").show();
	} else {
		var data1 = $("#reg").serializeArray();
		$.post("../reg", data1, function(data, stuts) {
			if (data == "ERROR") {
				$(".login_lableTip").show();
				$(".login_lableTip").text("注册失败");
			} else {
				window.location.href = "../html/Login.jsp";
			}
		});
	}
}
