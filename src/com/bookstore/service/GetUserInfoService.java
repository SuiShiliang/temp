package com.bookstore.service;

import java.util.List;
import java.util.Map;

import com.bookstore.dao.GetUserInfoDao;

public class GetUserInfoService {
	
	private GetUserInfoDao dao = new GetUserInfoDao();
	//获取用户基本信息
	public Map<String , Object> getUserInfoAll(String username) {
		return dao.getUserInfoAll(username);
	}
	//判断用户账号是否存在
	public boolean judgeUser(String username) {
		return dao.judgeUser(username);
	}
	//获取地址信息
	public List<Map<String , Object>> getUserAddress(Object...objects){
		return dao.getUserAddress(objects);
	}
}
