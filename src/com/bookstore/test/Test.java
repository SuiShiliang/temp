package com.bookstore.test;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.iterators.ObjectArrayListIterator;

import com.bookstore.dao.GetBooksDao;
import com.bookstore.dao.GetUserInfoDao;
import com.bookstore.dao.RegDao;
import com.bookstore.pojo.Accounts;
import com.bookstore.pojo.all.AccountsAll;


public class Test {
	
	private void setValue(Object... objects){
		if (objects != null) {
			for (int i = 1; i <= objects.length; i++) {
				System.out.println(i+":"+objects[i - 1]);
				
			}
		}
	}

	public static void main(String[] args) {
		
		/*Test test = new Test();
		Accounts accounts = new Accounts();
		accounts.setACCOUNT("xiaoming");
		accounts.setID(1);
		accounts.setIMAGE_ID(2);
		accounts.setEMAIL("2222@qq.cpm");
		accounts.setPASSWORD("123456");
		
		AccountsAll all = new AccountsAll();
		all.setAccounts(accounts);
		test.setValue(accounts);*/
		
		
		/*GetBooksDao dao = new GetBooksDao();
//		System.out.println(dao.getBooksListForSerch("修聊"));;
		System.out.println(dao.getBookInfoById(1));*/
		
		/*RegDao dao = new RegDao();
		String username = "test005";
		String userpws = "123456";
		String mail = "test001@qq.com";
		if(dao.reg(username,userpws,mail)) {
			System.out.println("成功");
		}
		else {
			System.out.println("失败");
		}*/
		
		
		/*Date date = new Date();
		System.out.println(date.getTime());*/
		String  s = "我们是学生";
		System.out.println(s.hashCode());
 	}
}
