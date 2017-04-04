
<%@page import="java.util.ListIterator"%>
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>으갹갹갹</title>
<link href="../css/customer/style.css" type="text/css" rel="stylesheet" />

<script>
/* 	var ar = ["철수","영희","미진","선미"];
	 
	var exam = {
		kor:30,
		eng:40,
		math:50
	};
	
	 for(var i in exam)  /* for-in 문=자바의 for each문, for each는 값을 뽑아내고 for-in은 인덱스를 빼낸다. 꼭!!!!!!지역 변수를 사용할 것 */

	 // var add = new Function("x,y","return x+y;"); // 자바 스크립트는 Java나 C처럼 함수를 정의하고 사용하지 않는다. 
	 
/* 	 var add = function(){ //JSON
	 	var sum = 0 ;
		 
	 	for(var i in arguments) 
		 	sum+=arguments[i];
		
	 	return sum;
	
	 } // 정의x  선언->객체 생성->참조
	 
	 alert(add(3,4,5,8,9));
*/
/* 
 function f1(){
	var a  = 1;
	return function f2(){ // f는 클로저(f2가 f1의 변수를 물고 f1을 f가 물고 있어, 함수가 끝나도 메모리의 변수가 사라지지 않음)
		return a;
	}
}
	
	var f = f1();
	var a = f();
	
	alert(a);
} */

	window.addEventListener("load", function(e) {
		var moreButton = document.querySelector("#more-button");
		var notices = [
			{code:"1", title:"오오오"},
			{code:"2", title:"오호오"},
			{code:"3", title:"오히오"}
		];
		
		moreButton.onclick = function(){
			var template = document.querySelector("#notice-row");
			
			for(var i in notices){
				var tbody = document.querySelector(".notice-table tbody");	
				var tds = template.content.querySelectorAll("td");
				
				
				tds[0].innerText = notices[i].code;
				tds[1].innerText = notices[i].title;
				
				var clone = document.importNode(template.content, true);
				tbody.appendChild(clone);
			}
		}
	});
</script>
 

<!--  <script>
 
 	var a = "안녕하세요";
 	var sum = 0;
 	var b = new Object("안녕하세요");
 	alert("11"-3);
 	
 </script>
 
 
 -->
<!-- <script>
		var student = {}; //[] 는 배열
		student.name = "안농";
		student.age = 20;
		student["취미"] = ["운동", "음악 감상", "멍때리기"];
		student.height = 180;
		alert(32>"4");
		
</script>
 -->
<!--

연산자

 덧셈은 문자열+숫자 => 문자열 뺄셈은 문자열-숫자 => 숫자
 "36">"2" 는 첫째자리 비교(따라서 true)
 -->
 
 
 
 
<!-- 
<script>
	var student = { //set형 array {}로 객체 생성
			name : "홍길동",
			age : 20,
			"취미" : ["코딩", "요리", "수학"]
	}
	alert(student["취미"][1]);
</script>
 -->
 
 </head>
<body>
<!-- <script>
	window.onload = function(){
	var btnResult = document.getElementById("btn-result");
	btnResult.onclick = printResult;
	
	function printResult(){
			var x,y;
			x = prompt("x 값을 입력하세요",0);
			y = prompt("y 값을 입력하세요",0);
			x = parseInt(x);
			y = parseInt(y);
			btnResult.value = x+y;
		}
	}
</script>
 -->
<script src="../js/customer/notice.js">
</script>

	<!-- ---------------------------------------------헤 더------------------------------------------------------------ -->
	<header id="header">
		<div class="content-container">

			<h1 id="logo">
				<img src="../images/logo.png" alt="뉴렉처 온라인">
			</h1>

			<section>
				<h1 class="hidden">header</h1>
				<!-- 		스타일에는  세미콜론 써주기!
 -->
				<nav id="main-menu" class="hr-menu">
					<h1 >메인메뉴
						<input type = "button"  id="btn-result" value="클릭"  />
					</h1>
					<ul>
						<!-- ul,ol,dl -->
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>

				<div id="lecture-search-form">
					<h3 class="hidden">검색 폼</h3>
					<form>
						<fieldset>
							<legend class="hidden">검색 필드</legend>
							<label>과정검색</label> <input type="text" /> <input
								class="lecture-search-btn" type="submit" value="검색" />
						</fieldset>
					</form>
				</div>

				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">계정메뉴</h1>
					<ul>
						<li><a href="../index.html">HOME</a></li>
						<li><a href="../account/login.html">로그인</a></li>
						<li><a href="../join.html">회원가입</a></li>
					</ul>
				</nav>

				<nav id="member-menu" class="hr-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><input type="button" value="마이페이지" /></li>
						<li><input type="button" value="고객 센터" /></li>
					</ul>
				</nav>

			</section>
		</div>
	</header>
	<!-- ---------------------------------------------비주얼------------------------------------------------------------ -->
	<div id="visual">
		<!-- 비ㅇ주얼 영역 -->
		<div class="content-container"></div>
	</div>


	<!-- -----------------------------------------------바디---------------------------------------------------------- -->
	<div id="body">
		<!-- 섹션과 메인을 div로 묶어줌 -->
		<div class="content-container clearfix">
			<aside id="aside">
				<!-- div를 시맨틱하게 태그로 표현 (nav, article, aside) -->
				<!-- 	Section 내에서 헤더 푸터 따로 사용 가능. 메인은 사용 불가능 (문서 내 메인은 단 하나만 존재해야함 ) -->
				<h1 class="aside-title aside-main-title aside-margin">고객센터</h1>
				<nav>
					<h1 class="hidden">고객센터 메뉴</h1>

					<ul class="margin">
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">공지사항</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">1:1고객문의</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">학습안내</a></li>
					</ul>

				</nav>

				<nav>
					<div>
						<h1 class="aside-title margin">추천사이트</h1>
						<ul class="margin">
							<li><a href=""><img src="../images/answeris.png"
									alt="answeris"></a></li>
							<li><a href=""><img src="../images/w3c.png" alt="w3c"></a></li>
							<li><a href=""><img src="../images/microsoft.png"
									alt="마이크로소프트"></a></li>
						</ul>
					</div>
				</nav>
			</aside>


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
	   				
			<div class="margin">${p}/${last} pages</div>
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
 	        		<a href="notice-reg.jsp">글쓰기</a>
 	        		<span id="more-button">더보기</span>
 	        	</div>

			</main>
		</div>
	</div>

	<!-- -----------------------------------------------푸터---------------------------------------------------------- -->
	<footer id="footer">
		<div class="content-container">

			<h2>회사정보</h2>
			푸터당
			<div>주소서울특별시 마포구 토정로35길 11, 인우빌딩 5층
				266호관리자메일admin@newlecture.com사업자 등록번호132-18-46763 통신 판매업 신고제
				2013-서울강동-0969 호 상호뉴렉처대표박용우전화번호070-4206-4084 [죄송합니다. 당분간 문의내용은 고개센터
				메뉴에서 1:1 문의를 이용해주시기 바랍니다] Copyright ⓒ newlecture.com 2012-2014 All
				Right Reserved. Contact admin@newlecture.com for more information</div>
		</div>
	</footer>

</body>
</html>