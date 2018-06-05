package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.RegService;

public class RegServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegService regService = new RegService();
		String username = req.getParameter("user");
		String userpassword = req.getParameter("pwd");
		String mail = req.getParameter("mail");
		
		PrintWriter pw = resp.getWriter();
		
		if(regService.reg(username,userpassword,mail)) {
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
