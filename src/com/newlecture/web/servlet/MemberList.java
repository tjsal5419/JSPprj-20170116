package com.newlecture.web.servlet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;

@WebServlet("/memberlist")
public class MemberList extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//BufferedImage image = new BufferedImage(900, 600, BufferedImage.TYPE_INT_RGB);
		
	   String query = request.getParameter("query");
	   System.out.println(query);
	   
	   response.setCharacterEncoding("utf-8");
	   response.setContentType("text/html;UTF-8");	  
	   
	   PrintWriter out = response.getWriter();	
	   //S
	   
		MemberDao member = new MySQLMemberDao();
		List<Member> list = new ArrayList<>(); 
		list = member.getList(query);
		
		for(Member m : list)
			out.printf("%s		%s<span style='color:red;'>%s</span>	%s	%s	%s	<br/>", m.getId(), m.getName(), m.getPhone(), m.getGender(),m.getBirthday(),m.getRegDate());


   }

}