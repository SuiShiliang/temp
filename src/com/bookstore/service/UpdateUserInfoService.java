package com.bookstore.service;

import com.bookstore.dao.UpdateUserInfoDao;

public class UpdateUserInfoService {

	private UpdateUserInfoDao dao = new UpdateUserInfoDao();

	/**
	 * 修改用户的accounts表的信息
	 * 
	 * @param objects
	 *            ，account， password， email， image_id， id
	 * @return
	 */
	public boolean updateUserInfoAccounts(Object... objects) {
		return dao.updateUserInfoAccounts(objects);
	}

	/**
	 * 传过来image的url和id，id在后，url在前
	 * 
	 * @param objects
	 *            url， id
	 * @return
	 */
	public boolean updateUserInfoImages(Object... objects) {
		return dao.updateUserInfoImages(objects);
	}

	/**
	 * @param objects
	 *            full_name， tel， account_id
	 * @return
	 */
	public boolean updateUserInfoConsignees(Object... objects) {
		return dao.updateUserInfoConsignees(objects);
	}

	/**
	 * 传过来 image的名，即url，返回imageid
	 * 
	 * @param objects
	 *            Url
	 * @return
	 */
	public int getImageId(Object... objects) {
		return dao.getImageId(objects);
	}

}
