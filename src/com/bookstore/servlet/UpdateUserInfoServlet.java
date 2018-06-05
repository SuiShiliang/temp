package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.UpdateUserInfoService;

import net.sf.json.JSONArray;

public class UpdateUserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UpdateUserInfoService service = new UpdateUserInfoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String ACCOUNT_ID = req.getParameter("ACCOUNT_ID");
		String ACCOUNT = req.getParameter("ACCOUNT");
		String PASSWORD = req.getParameter("PASSWORD");
		String FULL_NAME = req.getParameter("FULL_NAME");
		String TEL = req.getParameter("TEL");
		String EMAIL = req.getParameter("EMAIL");
		String fileUrl = req.getParameter("fileUrl");
		String olddata = req.getParameter("olddata");

		JSONArray json = JSONArray.fromObject(olddata);
		int imageid = 1;
		
		PrintWriter pw = resp.getWriter();
		//如果图片没有上传成功，则设置图片id为初始图片的id，即为1
		if (null != fileUrl && !fileUrl.equals("")) {
			if (service.updateUserInfoImages(fileUrl, json.getJSONObject(0).getInt("IMAGE_ID"))) {
				imageid = service.getImageId(fileUrl);
			}
		}
		if (service.updateUserInfoAccounts(ACCOUNT,PASSWORD,EMAIL,imageid,ACCOUNT_ID) && service.updateUserInfoConsignees(FULL_NAME, TEL, ACCOUNT_ID)) {
			pw.write("SUCCESS");
		}
		else {
			pw.write("ERROR");
		}
		pw.close();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
