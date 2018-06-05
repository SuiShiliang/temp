package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.GetBooksService;

import net.sf.json.JSONObject;

public class GetBookInfoByIdServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		GetBooksService service = new GetBooksService();
		Map<String , Object> map = service.getBookInfoById(bookid);
		PrintWriter pw = resp.getWriter();
		if(null != map && map.size() != 0){
			pw.write(JSONObject.fromObject(map).toString());
		}
		else {
			pw.write("NULL");
		}
		pw.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
