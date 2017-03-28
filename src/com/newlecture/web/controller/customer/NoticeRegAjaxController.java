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
		String path = ctx.getRealPath("/customer/upload"); // realPath = 배포디렉토리,
															// 탐색기의 경로 = 가상 디렉토리
		System.out.print("흐아");

		// 경로가 존재하지 않을 경우, 경로를 만들어주기 위한 File객체
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
