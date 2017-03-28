<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


         <main id="main">
      
            <h2 class="main-title">공지사항 내용</h2>
            
            <div class="breadcrumb">
               <h3 class="hidden">현재경로</h3>
               <ul>
                  <li>home</li>
                  <li>고객센터</li>
                  <li>공지사항</li>
               </ul>
            </div>
               
               <form method="post">
	            <table border="1">
	               <tbody>
	                  <tr>
	                     <th>제목</th>
	                     <td colspan="4">
	                     		<input name="title" type="text" value="${n.title }"/>	
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>작성자</th>
	                     <td colspan="4">
	                     		${n.writer }
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>작성일</th>
	                     <td colspan="4">
	                     		${n.regdate }
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>조회수</th>
	                     <td colspan="4">
	                     		${n.hit }
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>내용</th>
	                     <td colspan="4">
	                     		<textarea name="content" rows="20" cols="80">${n.content }</textarea>
	                     </td>
	                  </tr>	                  
	                  
	               </tbody>
	            </table>
	           
            <div>
            	<input type="hidden" name="code" value="${n.code }">
               	<input type="submit" value="저장" />
                <a href="notice-detail?c=${n.code }">취소</a>               
            </div>            
           </form>

         </main>
         

