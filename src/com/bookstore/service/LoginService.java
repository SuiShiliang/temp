package com.bookstore.service;

import com.bookstore.dao.LoginDao;

public class LoginService {

	private LoginDao dao = new LoginDao();
	public boolean login(Object...objects) {
		return dao.login(objects);
	}
}
