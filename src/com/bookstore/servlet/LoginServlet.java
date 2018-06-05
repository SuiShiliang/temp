package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.LoginService;


public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LoginService loginService = new LoginService();
		String username = req.getParameter("user");
		String userpassword = req.getParameter("pwd");
//		String method = req.getParameter("method");
		String checked = req.getParameter("checkFlag");
		
		PrintWriter pw = resp.getWriter();
		if(loginService.login(username,userpassword)) {
			if(checked.equals("YES")) {
				Cookie cookie = new Cookie("bookstoreUserLoginName", username);
				cookie.setMaxAge(30*24*60*60);
				resp.addCookie(cookie);
			}
			req.getSession().setAttribute("UserLoginName", username);
			pw.write("SUCCESS");
		}
		else {
			pw.write("ERROR");
		}
		pw.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
