package com.bookstore.dao;

import java.util.Map;

import com.bookstore.util.JDBCUtil;

public class UpdateUserInfoDao {

	
	private JDBCUtil jdbc = new JDBCUtil();

	/**
	 * 修改用户的accounts表的信息
	 * 
	 * @param objects
	 *            ，account， password， email， image_id， id
	 * @return
	 */
	public boolean updateUserInfoAccounts(Object... objects) {

		String sql = "update accounts" + "   set account = ?, password = ?, email = ?, image_id = ? " + " where id = ?";
		if (jdbc.modify(sql, objects) == 1)
			return true;
		return false;
	}

	/**
	 * 传过来image的url和id，id在后，url在前
	 * 
	 * @param objects
	 *            url， id
	 * @return
	 */
	public boolean updateUserInfoImages(Object... objects) {
		String sql = "";
		// 判断头像是否是初始头像，是则重新创建一个image数据
		if (Integer.parseInt(objects[1].toString()) == 1) {
			sql = "insert into images values(images_seq.nextval,?,'')";
			if (jdbc.add(sql, objects[0]) == 1)
				return true;
		} else {
			sql = "update images img " + "   set img.url = ? " + " where img.id  = ?";
			if (jdbc.modify(sql, objects) == 1)
				return true;
		}
		return false;
	}

	/**
	 * @param objects
	 *            full_name， tel， account_id
	 * @return
	 */
	public boolean updateUserInfoConsignees(Object... objects) {
		String sql = "update consignees con " + "   set con.full_name = ?,con.tel = ? " + " where con.account_id = ? ";
		if (jdbc.modify(sql, objects) == 1)
			return true;
		return false;
	}

	/**
	 * 传过来 image的名，即url，返回imageid
	 * 
	 * @param objects
	 *            Url
	 * @return
	 */
	public int getImageId(Object... objects) {
		String sql = "select img.id imgid from images img where img.url = ?";
		int imageid = 1;
		Map<String, Object> map = jdbc.findByConditionOne(sql, objects);
		if (null != map && map.size() != 0)
			imageid = Integer.parseInt(map.get("IMGID").toString());
		return imageid;
	}

}
