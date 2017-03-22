<%@page import="com.google.gson.Gson"%>
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

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

	Thread.sleep(3000);
	
	Gson gson = new Gson();
	String json = gson.toJson(list);
	
	out.println(json);
%>
