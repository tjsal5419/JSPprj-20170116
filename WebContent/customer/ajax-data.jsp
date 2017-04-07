<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   String _field = request.getParameter("f");
   String _query = request.getParameter("q");
   String _page = request.getParameter("p");

   int pg = 1;
   String field = "TITLE";
   String query = "";
   
   if (_page != null && !_page.equals("")) // 전달된 page값이 있다면
      pg = Integer.parseInt(_page);

   if (_field != null && !_field.equals(""))
      field = _field;

   if (_query != null && !_query.equals(""))
      query = _query; 

   NoticeDao noticedao = new MySQLNoticeDao();
   List<NoticeView> list = noticedao.getList(pg, field, query);
   
   //3초동안 자다 꺠는 것
   //Thread.sleep(3000);
   
   //Gson 은 Java 객체를 JSON 표현식으로 변환할 수 있게 하는 Java 라이브러리
   //gson추가
   Gson gson = new Gson();
   String json = gson.toJson(list);
   out.println(json);
%>