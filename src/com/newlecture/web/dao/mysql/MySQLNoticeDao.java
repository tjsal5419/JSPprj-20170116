package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public class MySQLNoticeDao implements NoticeDao{

	@Override
	public List<NoticeView> getList() {
		return getList(1,"TITLE","");
	}
	@Override
	public List<NoticeView> getList(int page) {
		return getList(page,"TITLE","");
	}
	

	@Override
	public List<NoticeView> getList(int page, String field, String query) {

		List<NoticeView> list = new ArrayList();
		try {
			String sql = "SELECT * FROM NOTICE_VIEW WHERE BINARY "+field+" LIKE ? LIMIT ?,10";
			// 대소문자 구분 용 : binary 
			// LIMIT : DB select 열 갯수 제한
			  
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,"%"+query+"%");// String은 '"가 같이 옴
			st.setInt(2, 10*(page-1));
			
			ResultSet rs = st.executeQuery();
			
			NoticeView noticeView = null;

			while (rs.next()) {
				noticeView = new NoticeView();
				
				noticeView.setHit(rs.getInt("HIT"));
				noticeView.setCode(rs.getString("CODE"));
				noticeView.setTitle(rs.getString("TITLE"));
				//noticeView.setWriterName(rs.getString("NAME"));
				//noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
				noticeView.setWriter(rs.getString("WRITER"));
				noticeView.setContent(rs.getString("CONTENT"));
				noticeView.setRegdate(rs.getDate("REGDATE"));
				
				// NoticeView Column
				noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
				noticeView.setWriterName(rs.getString("WRITER_NAME"));
				
				list.add(noticeView);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int getSize() {
		return getSize("TITLE","");
	}
	@Override
	public int getSize(String field, String query) {
		List<NoticeView> list = new ArrayList();
		int size = 0;  
		try {
			String sql = "SELECT COUNT(CODE) SIZE FROM NOTICE WHERE BINARY "+field+" LIKE ?";
			// 대소문자 구분 용 : binary 
			// LIMIT : DB select 열 갯수 제한
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,"%"+query+"%");// String은 '"가 같이 옴

			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				size = rs.getInt("SIZE");
			
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return size;
	}
	@Override
	public int add(String title, String content, String writer) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriter(writer);
		add(notice);
		return 1;
	}
	@Override
	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
