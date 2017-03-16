package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;

public class OracleMemberDao implements MemberDao {

	@Override
	public List<Member> getList(){

		  String sql = "SELECT  *  From MEMBER ORDER BY MID DESC";
		  List<Member> list = new ArrayList<>();
		  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Member member = null;
			while (rs.next()) {
				member = new Member();
				member.setMid(rs.getString("MID"));
				member.setPhone(rs.getString("PHONE"));
				member.setName(rs.getString("NAME"));
				member.setPwd(rs.getString("PWD"));
				member.setGender(rs.getString("GENDER"));
				member.setAge(rs.getInt("AGE"));
				member.setMajor(rs.getString("MAJOR"));
				member.setBirthday(rs.getString("BIRTHDAY"));
				member.setRegDate(rs.getDate("REGDATE"));
				
				list.add(member);
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
	public int add(Member member) {
		  String sql = "INSERT INTO MEMBER(MID,PWD,PHONE,NAME,GENDER,AGE, MAJOR, BIRTHDAY,REGDATE) VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getMid());
			st.setString(2, member.getPwd());
			st.setString(3, member.getPhone());
			st.setString(4, member.getName());
			st.setString(5, member.getGender());
			st.setInt(6, member.getAge());
			st.setString(7, member.getMajor());
			st.setString(8, member.getBirthday());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      return 0;
	}

	@Override
	public void delete(String mid) {
     	 String sql = "DELETE MEMBER WHERE MID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mid);
			int result = st.executeUpdate();
			if(result >0)
				System.out.println("삭제되었습니다.");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(Member member) {
    	 String sql = "UPDATE MEMBER SET NAME=?, PHONE=?, PWD=?, GENDER=?, AGE=?, MAJOR=?, BIRTHDAY=? WHERE MID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getName());
			st.setString(2, member.getPhone());
			st.setString(3, member.getPwd());
			st.setString(4, member.getGender());
			st.setInt(5, member.getAge());
			st.setString(6, member.getMajor());
			st.setString(7, member.getBirthday());
			st.setString(8, member.getMid());
			
			int result = st.executeUpdate();
			if(result >0)
				System.out.println("수정되었습니다.");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> getList(String query) {
		// TODO Auto-generated method stub
		return null;
	}



}
