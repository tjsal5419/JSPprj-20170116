package com.newlecture.web.data.dao;

import java.util.Date;
import java.util.List;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public interface NoticeDao {
	List<NoticeView> getList();
	List<NoticeView> getList(int page, String field, String query);
	List<NoticeView> getList(int page);
	NoticeView get(String code);
	NoticeView getPrev(String code);
	NoticeView getNext(String code);
	
	int getSize();
	int getSize(String field, String query);
	
	int add(String title, String content, String writer);
	int add(Notice notice);
	
	int delete(String code);
	int update(Notice notice);
	int update(String title, String content, String code);
	
	String lastCode();

}
