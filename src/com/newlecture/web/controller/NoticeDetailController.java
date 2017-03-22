package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.dao.mysql.MySQLNoticeFileDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;

@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("c");
		
		NoticeDao noticeDao = new MySQLNoticeDao();
		NoticeFileDao noticeFileDao = new MySQLNoticeFileDao();

		// ��
		NoticeView n = noticeDao.get(code);
		NoticeView prev = noticeDao.getPrev(code);
		NoticeView next = noticeDao.getNext(code);
		
		List<NoticeFile> list = noticeFileDao.getList(n.getCode());

		// ���� ����ϴ� jsp�� ������ ��� 2����
		
		request.setAttribute("n", n);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("notice-detail.jsp").forward(request, response);
		
		// JSP - 2������ ����� ������ 4������ �����
		// ����� - ����(�� �����) ���ø����̼�(��ü) ������Ʈ(�� ����) ������(�� ������)
		
	}

}
