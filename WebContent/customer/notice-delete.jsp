<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String code = request.getParameter("c");

   NoticeDao noticeDao = new MySQLNoticeDao();
   int result = noticeDao.delete(code);
   
   System.out.print(result);
   System.out.print(code);
   
   if(result > 0){
		response.sendRedirect("notice.jsp");   
   }
   
   
%>
