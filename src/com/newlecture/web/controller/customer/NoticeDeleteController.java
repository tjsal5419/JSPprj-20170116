package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

@WebServlet("/customer/notice-delete")
public class NoticeDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String code = request.getParameter("c");

		   NoticeDao noticeDao = new MySQLNoticeDao();
		   int result = noticeDao.delete(code);
		   
		   System.out.print(result);
		   System.out.print(code);
		   
		   if(result > 0){
				response.sendRedirect("notice");   
		   }

	}
}
