package com.bookstore.service;

import com.bookstore.dao.RegDao;

public class RegService {

	private RegDao dao = new RegDao();
	public boolean reg(Object...objects) {
		return dao.reg(objects);
	}
}
