package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _page = request.getParameter("p");
		String _query = request.getParameter("q");
		String _field = request.getParameter("f");

		int pg=1;
		String query = "";
		String field = "TITLE";
		
		if(_page!=null && !_page.equals(""))
			pg = Integer.parseInt(_page);
		
		if(_query != null && !_query.equals(""))
			query = _query;
		
		if(_field != null && !_field.equals(""))
			field = _field;
				

		NoticeDao noticeDao = new MySQLNoticeDao();
		List<NoticeView> list = noticeDao.getList(pg, field, query);
		
		int size = noticeDao.getSize(field, query);
		int last = 0;
		if((size%10)>0)
			last = size/10 +1;
		else
			last = size / 10;
		
		request.setAttribute("size", size);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("q", query);
		request.setAttribute("f", field);
		request.setAttribute("last", last);
		
		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);
		
		/*TilesContainer container = TilesAccess.getContainer((ApplicationContext) request.getServletContext());
		
		container.render("customer.notice", request);*/
		
		
	
	}
}
