package com.bookstore.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	/**
	 * @return 返回下一个id，用于新建用户
	 */
	public int getNextId(String sql ) {
		
		Connection conn = OracleConfig.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			if(!rs.isClosed()) {
				return rs.getInt(1)+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleConfig.close(rs, st, conn);
		}
		
		return 0;
	}

	/**
	 * 查询所有数据
	 * 
	 * @param sql
	 *            传过来的sql语句
	 * @return 返回 List<Map<String, Object>> 数据类型
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findByAll(String sql)  {

		List<Map<String, Object>> listMap = new ArrayList<>();

		Connection conn = OracleConfig.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			// 此句不要放在 ResultSet 后面，可能会报错
			ResultSetMetaData rsd = st.getMetaData();
			rs = st.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				for (int i = 1; i <= rsd.getColumnCount(); i++) {
					String colname = rsd.getColumnName(i);
					Object obj = rs.getObject(colname);
					map.put(colname, obj);
				}
				listMap.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			OracleConfig.close(rs, st, conn);
		}
		return listMap;
	}

	/**
	 * 根据条件进行查询数据,单条数据返回
	 * 
	 * @param sql
	 *            传过来的sql语句，若有参数，一般参数用‘？’代替
	 * @param objects
	 *            传过来的参数，可以不传
	 * @return 返回 Map<String, Object> 数据类型
	 * @throws SQLException
	 */
	public Map<String, Object> findByConditionOne(String sql, Object... objects) {

		Map<String, Object> map = new HashMap<>();
		Connection conn = OracleConfig.getConnect();
		// 不安全的连接请求
		// Statement st = conn.createStatement();
		// 安全的连接请求

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			setValue(pst, objects);
			// 请求返回的数据集
			// ResultSet rs = st.executeQuery(sql);
			rs = pst.executeQuery();
			// 请求数据库中的列的名字
			ResultSetMetaData rsd = pst.getMetaData();

			rs.next();
			// 判断是否有数据返回
			if (!rs.isClosed()) {
				// getColumnCount 函数为得到返回数据的列的名字
				for (int i = 1; i <= rsd.getColumnCount(); i++) {
					// 得到第 i 个列的名字
					String colName = rsd.getColumnName(i);
					// 得到 colName 对应的值
					Object obj = rs.getObject(colName);
					map.put(colName, obj);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			OracleConfig.close(rs, pst, conn);
		}
		return map;
	}

	/**
	 * 根据条件进行查询数据,多条数据返回
	 * 
	 * @param sql
	 *            传过来的sql语句，若有参数，一般参数用‘？’代替
	 * @param objects
	 *            传过来的参数，可以不传
	 * @return 返回 List<Map<String, Object>> 数据类型
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findByCondition(String sql, Object... objects) {

		List<Map<String, Object>> listmap = new ArrayList<>();

		Connection conn = OracleConfig.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			setValue(st, objects);
			rs = st.executeQuery();
			ResultSetMetaData rsd = st.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				for (int i = 1; i <= rsd.getColumnCount(); i++) {
					String colName = rsd.getColumnName(i);
					Object obj = rs.getObject(colName);
					map.put(colName, obj);
				}
				listmap.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			OracleConfig.close(rs, st, conn);
		}
		
		return listmap;
	}

	/**
	 * 增加、删除、修改使用同一函数
	 * 
	 * @param sql
	 *            传过来的sql语句，若有参数，一般参数用‘？’代替
	 * @param objects
	 *            传过来的参数，可以不传
	 * @return 返回 int 数据类型
	 * @throws SQLException
	 */
	private int updateData(String sql, Object... objects) {

		Connection conn = OracleConfig.getConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			setValue(st, objects);
			st.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}finally {
			OracleConfig.close(null, st, conn);
		}
		return 1;
	}

	/**
	 * 修改函数
	 * 
	 * @param sql
	 *            传过来的sql语句，若有参数，一般参数用‘？’代替
	 * @param objects
	 *            传过来的参数，可以不传
	 * @return 返回 int 数据类型
	 * @throws SQLException
	 */
	public int modify(String sql, Object... objects){
		return updateData(sql, objects);
	}

	/**
	 * 删除函数
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	public int delete(String sql, Object... objects){
		return updateData(sql, objects);
	}

	/**
	 * 增加函数
	 * 
	 * @param sql
	 *            传过来的sql语句，若有参数，一般参数用‘？’代替
	 * @param objects
	 *            传过来的参数，可以不传
	 * @return 返回 int 数据类型
	 * @throws SQLException
	 */
	public int add(String sql, Object... objects){
		return updateData(sql, objects);
	}

	// 以传过来的Object的值 替换sql语句中的？
	private void setValue(PreparedStatement st, Object... objects){
		if (objects != null) {
			for (int i = 1; i <= objects.length; i++) {
				try {
					st.setObject(i, objects[i - 1]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
