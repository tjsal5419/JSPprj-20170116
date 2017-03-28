package com.newlecture.web.controller.joinus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.view.NoticeView;

@WebServlet("/joinus/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String returnUrl = request.getParameter("return-url");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		
		Member member = new MySQLMemberDao().get(id);
		boolean validate = true;
		HttpSession session = request.getSession();
		
		if(member == null)
			validate = false;
		else if(!member.getPwd().equals(pwd))
		{
			validate = false;
			System.out.println("비번다릅ㅂ니다");
		}
		else
		{
			session.setAttribute("id", id);
			System.out.println(id);
		}
		
		
		if(validate)
			if(returnUrl!=null)
				response.sendRedirect(returnUrl);
			else 
				response.sendRedirect("../index");
		else{
			request.setAttribute("validate", validate);
			request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request, response);
		}
	}	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/joinus/login.jsp").forward(request, response);
	}

}
