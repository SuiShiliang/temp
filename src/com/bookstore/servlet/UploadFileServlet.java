package com.bookstore.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

public class UploadFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		String filepath = this.getServletContext().getRealPath("/image");
		File file = new File(filepath);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("目录不存在，创建目录");
			file.mkdir();
		}

		String message = "";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		if (!ServletFileUpload.isMultipartContent(req)) {
			// 按照传统方式获取数据
			return;
		}

		try {
			List<FileItem> list = upload.parseRequest(req);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name + ":" + value);
				} else {
					String filename = item.getFieldName();
					if (filename == null || filename.trim().equals("")) {
						continue;
					}

					filename = filename.substring(filename.indexOf("\\") + 1);
//					获取上传的文件的文件名，并为其添加上当前日期，用于防止文件重名
					Date date = new Date();
					String uploadFIleName ="" + date.getTime()+ item.getName();
//					System.out.println(uploadFIleName);
					InputStream in = item.getInputStream();
					String filepathAndName = filepath + "\\" + uploadFIleName;
					FileOutputStream out = new FileOutputStream(filepathAndName);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					message = "../image/" + uploadFIleName;
//					System.out.println(message);
				}
			}
		} catch (FileUploadException e) {

			message = "NULL";
			e.printStackTrace();
		}
		//返回数据必须是json数据，否则不会返回到"SUCCESS"函数中
		String kk = "{'fileUrl':'"+message+"'}";
		message = JSONObject.fromObject(kk).toString();
		resp.getWriter().write(message);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
