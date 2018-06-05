package com.bookstore.dao;

import com.bookstore.util.JDBCUtil;

public class LoginDao {

	public Boolean login(Object...objects) {

		JDBCUtil jdbc = new JDBCUtil();
		String sql = "select * from accounts where ACCOUNT = ? and password = ? ";
		if(null != jdbc.findByConditionOne(sql, objects) && (jdbc.findByConditionOne(sql, objects)).size() != 0) {
			return true;
		}
		return false;
	}
}
