<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<main id="main"> <!-- 				<section id="quick-menu">
					<h2>퀵메뉴</h2>
				</section> -->
			<h2 class="main-title">공지사항[${size}]</h2>
			<div class="breadcrumb">
				<h3 class="hidden">breadcrumb</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>

			<div class="main-margin">
				<h3 class="hidden">과정 검색 폼</h3>
				<form>
					<fieldset>
						<legend class="hidden">검색필드</legend>
						<label>검색분류</label> 
						
						<select name="f">
							<c:if test="${param.f =='TITLE'}"> <!-- url로 받을 때, request에 파라미터로 넣어줌 -->
								<c:set var="selTitle" value="selected" scope="page"/> <!-- scope default는 page -->
							</c:if>

							<c:if test="${param.f == 'CONTENT'}">
								<c:set var="selContent" value="selected" scope="page"/> <!-- scope default는 page -->
							</c:if>

							<option value="TITLE"  ${selTitle} >
								제목
							</option>

							<option value="CONTENT"  ${selContent} >
								내용
							</option>
							
						</select> 
						
						<label>검색어</label> <input name="q" type="text" placeholder="검색어를 입력하세요" value=${query }>
						<input class="btn btn-search" type="submit" value="검색" />
						<input class="hidden" name="p" value="1" />
					</fieldset>
				</form>

			</div>

			<div class="notice margin">
				<h3 class="hidden">공지목록</h3>
				<table class="table notice-table">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>

					<tbody>
						<template id="notice-row">
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</template>
					
						<c:forEach items="${list}" var="v">
						<tr>
							<td>${v.getCode() }</td>
							<td><a href="notice-detail?c=${v.getCode()}">${v.getTitle()}</a></td>
							<td>${v.getWriter() }</td>
							<td>${ v.getRegdate() }</td>
							<td>${ v.getHit() }</td>
					    </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	   				
			<div class="margin">${pg}/${last} pages</div>
			<!-- 제목도, 목록도, 문장도, 폼도, 표도 아니면 모두 div -->

			<div class="margin">
               <div><a href="">이전</a></div>  
        	
             	
					<ul>
 						<c:forEach var="i" begin="1" end="${last}">
 						 	<li><a href="?p=${i}&q=${param.q}&f=${param.f}">${i}</a></li>
             			</c:forEach>
               		</ul>
               
               <div><a href="">다음</a></div>
            </div>
 	        	<div>
 	        		<a href="notice-reg">글쓰기</a>
 	        		<span id="more-button">더보기</span>
 	        		
 	        		<c:set var="id" value="${sessionScope.id}"></c:set>
 	        		<c:if test="${not empty id}">
 	        			<a href="../joinus/logout">로그아웃</a>
 	        		</c:if>
 	        		
 	        		<c:if test="${empty id}">
 	        			<a href="../joinus/login">로그인</a>
 	        		</c:if>
 	        		
 	        	</div>

			</main>