$(function() {
	var userName = $("#usernamecookie").text();
	var data = {
		"user" : userName
	};
	$.post("../GetUserInfoAll", data, function(data, status) {
		if (data != "ERROR") {
			
			$("#tempdata").text(data);
			var jsondata = JSON.parse(data);
			$("#URL").attr("src", jsondata[0].URL);
			for ( var vv in jsondata) {
				/* alert(jsondata[vv]); */
				for(var zz in jsondata[vv]){
					var inputid = "#" + zz;
					$(inputid).val(jsondata[vv][zz]);
				}
				
			}
		}
	});
});
// 将刚刚上传的文件显示在页面上
function setImage() {

	$("#imageFlag").text(1);
	/* 显示刚刚上传的图片 */
	// 获取临时文件
	var image = $("#imageInout").get(0).files[0];
	// 获取临时文件的url
	var imageurl = window.URL.createObjectURL(image);
	// 将临时文件的url放如到显示框中
	$("#URL").attr("src", imageurl);

}

function updateInfoOk(imageUrl){

	var data = $("#userInfoForm").serializeArray();
	var imageUrlin = {
		"name" : "fileUrl",
		"value" : imageUrl
	};
	data[6] = imageUrlin;
	var olddata = {
		"name" : "olddata",
		"value" : $("#tempdata").text()
	};
	data[7] = olddata;
	$.post("../UpdateUserInfo", data, function(data, status) {
		if (data != "ERROR") {
			window.location.href = "userInfo1.jsp";
		} else {
			alert("修改信息失败！")
		}
	});
}
// 提交修改后的数据
function updateInfo() {
	var user = $("#ACCOUNT").val();
	var pwd = $("#PASSWORD").val();
	if (user == "") {
		$(".login_lableTip").text("用户名为空！")
		$(".login_lableTip").show();
	} else if (pwd == "") {
		$(".login_lableTip").text("密码为空！")
		$(".login_lableTip").show();
	} else {
		var imageUrl = "";
		if ($("#imageFlag").text() == "1") {
			/* 文件上传 */
			// 获取文件上传表单
			var formData = new FormData($("#uploadFileForm")[0]);
			// 文件上传只能使用ajax ，并且需要设置 cache，processData，contentType 参数
			$.ajax({

				url : "../UploadFile",
				data : formData,
				type : "Post",
				dataType : "json",
				cache : false,// 上传文件无需缓存
				processData : false,// 用于对data参数进行序列化处理 这里必须false
				contentType : false, // 必须
				error : function(data) {
					alert("图片上传失败")
				},
				success : function(data) {
					imageUrl = data.fileUrl;
					updateInfoOk(imageUrl);
				},
			});

		}
		else {
			updateInfoOk(imageUrl);
		}

	}

	// $("#userInfoForm")
}