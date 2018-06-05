package com.bookstore.dao;


import java.util.Map;

import com.bookstore.util.JDBCUtil;


public class RegDao {
	
	public Boolean reg(Object...objects) {
		JDBCUtil jdbc = new JDBCUtil();
		//问号依次为用户名、用户密码、邮箱
		String sql = "insert into accounts values(accounts_seq.nextval,?,?,?,0,1)";
		//查询刚刚创建的账号id
		String sql11 = "select acc.id from accounts acc where acc.account = ?";
		//在consignees表插入账号在consignees表相对应数据
		String sql1 = "insert into consignees " + 
				"values" + 
				"(consignees_seq.nextval,?,'','')";
		//查询刚刚注册的账号所对应的consignees id
		String sql3 = "select con.id from consignees con where con.account_id = ?";
		//在addresses 表插入账号对应的初始数据
		String sql2 = "insert into addresses " + 
				"values" + 
				"(address_extras_seq.nextval,?,0,0,0,0,'')";
		if(jdbc.add(sql, objects) == 1) {
			Map<String , Object> map1 = jdbc.findByConditionOne(sql11,objects[0]);
			int accountid = Integer.parseInt(map1.get("ID").toString());
			if(jdbc.add(sql1, accountid) == 1) {
				Map<String , Object> map2 = jdbc.findByConditionOne(sql3, accountid);
				int consigneesID = Integer.parseInt(map2.get("ID").toString());
				if(jdbc.add(sql2, consigneesID) == 1) {
					return true;
				}
			}
		}
		return false;
	}
}
