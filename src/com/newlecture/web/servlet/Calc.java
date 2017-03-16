package com.newlecture.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(_x!=null && !_x.equals(""))
			x = Integer.parseInt(_x);
		
		if(_y!=null && !_y.equals(""))
			y = Integer.parseInt(_y);
	
		PrintWriter out = response.getWriter();
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<hr />");
		out.write("	<form action = \"calc\" method=\"post\">");
		out.write("	<p>");
		out.write("		<label>x:</label>");
		out.write("		<input type=\"text\" name=\"x\"  id=\"txt-x\" />");
		out.write("		 <label>y:</label>");
		out.write("		 <input type=\"text\" name=\"y\" id=\"txt-y\" />	");
		out.write("	</p>");
		out.write("	<p>");
		out.write("		sum = <input id=\"submit\" type=\"text\" value=\"");
		out.println(x+y);
		out.write(" \" />");
		out.write("	</p>");
		out.write("	<p>");
		out.write("		<input type=\"submit\" id=\"txt-sum\" value=\"submit\" />");
		out.write("	</p>");
		out.write("</form>");
		out.write("</body>");

	}

}
