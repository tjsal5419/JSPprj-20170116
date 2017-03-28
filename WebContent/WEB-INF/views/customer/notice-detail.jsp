
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
               
	            <table border="1">
	               <tbody>
	                  <tr>
	                     <th>제목</th>
	                     <td colspan="4">
	                     		${n.title}%	
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
	                     	${n.regdate} 
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
	                     		${n.content}
	                     </td>
	                  </tr>	                        
	                  <tr>
	                     <th>첨부파일</th>
	                     <td colspan="4">
	                     		<%
	                     			List ns = new ArrayList();
	                     			ns.add("하하1");
	                     			ns.add("하하2");
	                     			ns.add("하하3");
	                     			ns.add("하하4");
	                     			ns.add("하하5");
	                     			ns.add("하하6");
	                     			
	                     			String hbs = "놀기, 먹기, 자기";
	                     			pageContext.setAttribute("ns", ns);
	                     			pageContext.setAttribute("hbs", hbs);
	                     			
	                     		%>
	                     		<c:forTokens var="hb" items="${hbs }" delims=",">
	                     			${hb }<br/>
	                     		</c:forTokens>
	                     		
	                     		<c:forEach var ="i" begin="1" end="3" items="${ns}" varStatus="st">
	                     			${st.index} : 나는 ~${i}<br/>
	                     			
	                     		</c:forEach>
	                     		<c:forEach var="i" begin="1" end="3">
	                     			맥보이~${i}<br/>
	                     		</c:forEach>
	                     		<c:forEach items="${list }" var="f">
	                     		<a href="upload/${f.src }" download>${f.src }</a>
	                     		</c:forEach>
	                     </td>
	                  </tr>
	                 
						<tr>
	                     <td colspan="5">
	                     		${n.content }
	                     		<img src="upload/" />
	                     		
	                     </td>
	                  </tr>	  	             
	                  
	               </tbody>
	            </table>
            <div>           
               <a href="notice-edit?c=${n.code }">수정</a>
                <a href="notice-delete?c=${n.code }">삭제</a>               
               <a href="notice">목록</a>
             </div>
             <div>
             	<ul>
             		<li>
             			<span>이전글</span>
						<c:if test="${ empty prev}"> <!-- empty : null, 빈 문자열 포함 -->
             				<span>이전 글이 존재하지 않습니다.</span>
 						</c:if>
 						<c:if test="${not empty prev }">
							<a href="notice-detail?c=${prev.code }">${prev["title"] }</a>             		
						</c:if>
             		</li>
					<li>
						<c:if test="${empty next}">
             				<span>다음 글이 존재하지 않습니다.</span>
						</c:if>
						<c:if test="${not empty next }">
							<a href="notice-detail?c=${next.code }">${next["title"]}</a>             		
						</c:if>
					</li>          
             	</ul>
             	
             </div>            
         </main>



