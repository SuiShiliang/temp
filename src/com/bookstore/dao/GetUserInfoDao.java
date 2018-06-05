package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import com.bookstore.util.JDBCUtil;

public class GetUserInfoDao {

	private JDBCUtil jdbc = new JDBCUtil();
	
	/**
	 * 根据用户名获取用户的所有信息
	 * @param username
	 * @return
	 */
	public Map<String , Object> getUserInfoAll(String username) {
		 
		 String sql = "select acc.*," + 
		 		"       addr.address_extra     addressExtra," + 
		 		"       ima.*," + 
		 		"       con.*" + 
		 		"  from accounts       acc," + 
		 		"       addresses      addr," + 
		 		"       consignees     con," + 
		 		"       images         ima" + 
		 		" where acc.account = ?" + 
		 		"   and acc.id = con.account_id" + 
		 		"   and acc.image_id = ima.id" + 
		 		"   and con.id = addr.consignee_id";
		 Map<String , Object> map = jdbc.findByConditionOne(sql, username);
		 return map;
	}
	
	/**
	 * 根据用户名，判断用户是否存在数据库中
	 * @param username
	 * @return
	 */
	public boolean judgeUser(String username) {
		String sql = "select * from  accounts acc where acc.account = ?";
		Map<String , Object> map = jdbc.findByConditionOne(sql, username);
		if(null != map && map.size() != 0 )return true;
		return false;
	}
	
	/**
	 * 根据用户名，获取用户的地址信息，用户的地址可能不止一条
	 * @param objects
	 * @return
	 */
	public List<Map<String , Object>> getUserAddress(Object...objects){
		
		String sql = "select addr.id addreess_id," + 
				"       addre1.content country," + 
				"       addre2.content province," + 
				"       addre3.content city," + 
				"       addre4.content street," +
				"		addr.address_extra addextra " +
				"  from accounts       acc," + 
				"       addresses      addr," + 
				"       consignees     con," + 
				"       address_extras addre1," + 
				"       address_extras addre2," + 
				"       address_extras addre3," + 
				"       address_extras addre4" + 
				" where acc.account = ?" + 
				"   and acc.id = con.account_id" + 
				"   and con.id = addr.consignee_id" + 
				"   and addr.country = addre1.id" + 
				"   and addr.province = addre2.id" + 
				"   and addr.city = addre3.id" + 
				"   and addr.street = addre4.id";
		 List<Map<String , Object>> list = jdbc.findByCondition(sql, objects);
		 return list;
	}
	
}
