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

public class GetBookListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		Map<String , String[]> maaa = req.getParameterMap();
		String pagess = req.getParameter("pageNum");
		int page = Integer.parseInt(req.getParameter("pageNum"));
		GetBooksService booksService = new GetBooksService();
		List<Map<String, Object>> list = booksService.getBooksList(page, 6);
		PrintWriter pw = resp.getWriter();
		if(list.size() != 0) {
			JSONArray array = JSONArray.fromObject(list);
			pw.write(array.toString());
		}
		else {
			pw.write("null");
		}
		pw.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
