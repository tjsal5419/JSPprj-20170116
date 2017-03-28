package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/customer/notice-reg-ajax")
public class NoticeRegAjaxController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content");
		 * 
		 * System.out.println(title);
		 */
		PrintWriter out = response.getWriter(); 

		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/customer/upload"); // realPath = �������丮,
															// Ž������ ��� = ���� ���丮
		System.out.print("���");

		// ��ΰ� �������� ���� ���, ��θ� ������ֱ� ���� File��ü
/*		File d = new File(path);

		if (!d.exists()) {
			d.mkdir();
		}*/

		MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());

		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		System.out.print(title);
		
		out.println("1");
	}
}
