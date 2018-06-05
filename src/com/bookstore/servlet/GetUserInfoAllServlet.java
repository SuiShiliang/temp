package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.GetUserInfoService;

import net.sf.json.JSONArray;

public class GetUserInfoAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("user");
		GetUserInfoService service = new GetUserInfoService();
		PrintWriter pw = response.getWriter();
		Map<String , Object> map = service.getUserInfoAll(username);
		List<Map<String , Object>> list = service.getUserAddress(username);
		List<Map<String , Object>> listmap = new ArrayList<>();
		listmap.add(map);
		listmap.add(list.get(0));
		if(null != map && map.size() != 0) {
			JSONArray json = JSONArray.fromObject(listmap);
			pw.write(json.toString());
		}
		else {
			pw.write("ERROR");
		}
		pw.close();
	}

}
