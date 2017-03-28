package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.dao.mysql.MySQLNoticeFileDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("c");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		NoticeDao noticeDao = new MySQLNoticeDao();
		NoticeView n = noticeDao.get(code);
		
		//로그인이 되지 않은 경우
		if(id==null)
			response.sendRedirect("../joinus/login?return-url=../customer/notice-edit?c="+code);
			/*response.getWriter().println("<script>alert('로그인이 되지 않았습니다.'); location.href='../joinus/login';</script>");*/

		//작성자 & 로그인 id가 다른 경우
		else if(!id.equals(n.getWriter()))
		{
			response.getWriter().println("<script>alert('글쓴이만 수정할 수 있습니다.'); location.href='notice-detail?c="+code+"';</script>");
		}
		else
		{	
			request.setAttribute("n", n);					
			request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);

		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String title = request.getParameter("title");
		   String content = request.getParameter("content");
		   String code = request.getParameter("code");
		   
		   NoticeDao noticeDao = new MySQLNoticeDao();
		   int result = noticeDao.update(title, content, code);
		   
		   System.out.print(result);
		   
		   if(result > 0)
				response.sendRedirect("notice-detail?c="+code); 
	}
		
}
