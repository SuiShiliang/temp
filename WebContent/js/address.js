function addressOnload() {
	var LoginName = {
		"LoginUsername" : $("#UserLoginName").text()
	};
	var html = "<caption class=''>用户地址管理</caption>";
	// “ \' ” “ ' ”的转移字符
	html += "<tr>" +
			"<th>序号</th>" +
			"<th>国家</th>" +
			"<th>省份</th>" +
			"<th>城市</th>" +
			"<th>街道</th>" +
			"<th>详细地址</th>" +
			"<th colspan='2'>" +
			'<button onclick="addAddress(\''+LoginName.LoginUsername+'\')">添加地址</button>' +
			"</th>" +
			"</tr>"
	$.post("../GetUserAddress", LoginName, function(data, status) {
		debugger
		var json = JSON.parse(data);
		var i = 1;
		for ( var c in json) {
			html += '<tr>';
			html += '<td>' + i + '</td>';
			i++;
			html += '<td>' + json[c].COUNTRY + '</td>';
			html += '<td>' + json[c].PROVINCE + '</td>';
			html += '<td>' + json[c].STREET + '</td>';
			html += '<td>' + json[c].CITY + '</td>';
			html += '<td>' + json[c].ADDEXTRA + '</td>';
			html += '<td><button onclick="updateAddress(' + json[c].ADDREESS_ID
					+ ')">修改</button></td>';
			html += '<td><button onclick="deleteAddress(' + json[c].ADDREESS_ID
					+ ')">删除</button></td>';
			// 使用for in函数，如果后台数据打乱，会使得显示时数据紊乱
			/*
			 * for ( var d in json[c]) { if (d != 'ADDREESS_ID') html += '<td>' +
			 * json[c][d] + '</td>'; else { html += '<td><button
			 * onclick="updateAddress('+json[c][d] +')">修改</button></td>' ;
			 * html += '<td><button onclick="deleteAddress('+json[c][d]+')">删除</button></td>'; } }
			 */
			html += '</tr>';
		}
		debugger
		$("#userAddressManageTable").append(html);
	});

}
function updateAddress(addressId) {
	var dhhddhdhhdj = "dsdsds";
	alert(addressId)
}
function deleteAddress(addressId) {
	alert(addressId)
}
function addAddress(accountName){
	debugger
	alert(accountName)
}