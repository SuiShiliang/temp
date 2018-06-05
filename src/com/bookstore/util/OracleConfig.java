package com.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConfig {
	
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String PWD = "123456";
	private static final String USER = "test_store";
	private static final String DIRVER_CLASS = "oracle.jdbc.OracleDriver";
	private static Connection conn;

	static {
		try {
			//判断Oracle驱动包是否可以加载或存在项目中
			Class.forName(DIRVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接，使可以操作数据库
	public static Connection getConnect() {
		
		try {
			//进行数据库连接
			conn = DriverManager.getConnection(JDBC_URL, USER, PWD);
			//返回连接至请求的函数
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//如果密码等错误，则返回空值	
		return null;
	}
	
	//关闭数据库连接
	public static void close(ResultSet rs, PreparedStatement st, Connection conn) {
		
		//不为空则关闭，若为空说明没有打开连接，所以不需要关闭，后面的同理
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
