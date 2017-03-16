package com.newlecture.web.dao.mysql;

import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

public class TestProgram {

	public static void main(String[] args) {
		
		NoticeDao noticeDao = new MySQLNoticeDao();
		List<NoticeView> list = noticeDao.getList();
		
		for(NoticeView v : list)
			System.out.println(v.getTitle());
		
	}

}
