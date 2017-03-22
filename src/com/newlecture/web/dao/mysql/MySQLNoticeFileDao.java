package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;

public class MySQLNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getList(String noticeCode) {
		
		List<NoticeFile> list = new ArrayList();
		try {
		      String sql = "select * from NOTICE_FILE WHERE NOTICE_CODE=?";
			// 대소문자 구분 용 : binary 
			// LIMIT : DB select 열 갯수 제한
			  
		         Class.forName("com.mysql.jdbc.Driver");
		         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
		         PreparedStatement st = con.prepareStatement(sql);

		         st.setString(1, noticeCode);

		         ResultSet rs = st.executeQuery();

		         NoticeFile file = null;


			while (rs.next()) {
	            file = new NoticeFile();
	            file.setCode(rs.getString("CODE"));
	            file.setSrc(rs.getString("SRC"));
	            file.setNoticeCode(rs.getString("NOTICE_CODE"));
			
				list.add(file);
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
	public int add(NoticeFile noticeFile) {
		return add(noticeFile.getSrc(), noticeFile.getNoticeCode());
	}

	
	@Override
	   public int add(String src, String noticeCode) {
	      String codeSql = "SELECT IFNULL(max(cast(CODE as unsigned)),0)+1 CODE FROM NOTICE_FILE";
	      String sql = "INSERT INTO NOTICE_FILE(CODE,SRC,NOTICE_CODE) VALUES(?,?,?)";
	      int result = 0;
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         
	         Statement codeSt = con.createStatement();
	         ResultSet rs = codeSt.executeQuery(codeSql);
	         rs.next();
	         String code = rs.getString("CODE");
	         
	         rs.close();
	         codeSt.close();
	         
	         PreparedStatement st = con.prepareStatement(sql);
	         
	         st.setString(1, code);
	         st.setString(2, src);
	         st.setString(3, noticeCode);

	         result = st.executeUpdate();

	         st.close();
	         con.close();

	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return result;
	   }


}
