package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.GetUserInfoService;

public class JudgeUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		GetUserInfoService service = new GetUserInfoService();
		String username = req.getParameter("user");
		PrintWriter pw = resp.getWriter();
		if(service.judgeUser(username)) {
			//如果用户存在，返回 SUCCESS 到页面上
			pw.write("SUCCESS");
		}
		else {
			pw.write("ERROR");
		}
		pw.close();
	}
}
