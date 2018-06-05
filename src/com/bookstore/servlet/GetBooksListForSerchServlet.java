package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.GetBooksService;

import net.sf.json.JSONArray;

public class GetBooksListForSerchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String bookname = req.getParameter("bookname");
		GetBooksService service = new GetBooksService();
		PrintWriter pw = resp.getWriter();
		
		List<Map<String , Object>> map = service.getBooksListForSerch(bookname);
		
		if(null != map && map.size() != 0) {
			pw.write(JSONArray.fromObject(map).toString());
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
