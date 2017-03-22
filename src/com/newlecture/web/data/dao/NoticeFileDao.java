package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.NoticeFile;

public interface NoticeFileDao {
	
	int add(NoticeFile noticeFile);
	int add(String src, String noticeCode);

	
	List<NoticeFile> getList(String noticeCode);
	
	
}
