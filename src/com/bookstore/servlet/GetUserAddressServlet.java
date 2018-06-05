package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.GetUserInfoService;

import net.sf.json.JSONArray;

public class GetUserAddressServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		GetUserInfoService service = new GetUserInfoService();
		String username = req.getParameter("LoginUsername");
		List<Map<String , Object>> list = service.getUserAddress(username);
		PrintWriter pw = resp.getWriter();
		if(null == list || list.size() == 0)
		{
			pw.write("NULL");
		}
		else {
			String jsontest = JSONArray.fromObject(list).toString();
			pw.write(JSONArray.fromObject(list).toString());
		}
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
