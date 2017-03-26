
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String _page = request.getParameter("p");
	String _query = request.getParameter("q");
	String _field = request.getParameter("f");

	int pg=1;
	String query = "";
	String field = "TITLE";
	
	if(_page!=null && !_page.equals(""))
		pg = Integer.parseInt(_page);
	
	if(_query != null && !_query.equals(""))
		query = _query;
	
	if(_field != null && !_field.equals(""))
		field = _field;		

	NoticeDao noticeDao = new MySQLNoticeDao();
	List<NoticeView> list = noticeDao.getList(pg, field, query);
	
	int size = noticeDao.getSize(field, query);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>으갹갹갹</title>
<link href="../css/customer/style.css" type="text/css" rel="stylesheet" />

<script>

	window.addEventListener("load", function() {
		var moreButton = document.querySelector("#more-button");
		var regButton = document.querySelector("#reg-button");
/*  		var notices = [
			{code:"1", title:"오오오"},
			{code:"2", title:"오호오"},
			{code:"3", title:"오히오"}
		];
		
	
 */		
 		regButton.onclick = function(event){
	 		var request = new window.XMLHttpRequest();
			event.preventDefault(); //a태그가 갖는 기본 행위를 금지시킴.

			request.open("GET", "notice-reg-partial.jsp",true);

		    request.onload = function() {
	            //장막 screen 만들기
	            var screen = document.createElement("div");
	            screen.className = "screen";
	            screen.style.width = "100%";
	            screen.style.height = "100%";

	            //스크롤해도 장막 다 쳐지게하는 것 fixed
	            screen.style.position = "fixed";
	            screen.style.left = "0px";
	            screen.style.top = "0px";
	            screen.style.background = "#000";
	            screen.style.opacity = "0.5";

	            document.body.appendChild(screen);

	            var formScreen = document.createElement("div");
	            formScreen.className = "formScreen";
	            formScreen.style.width = "100%";
	            formScreen.style.height = "100%";
	            formScreen.style.position = "fixed";
	            formScreen.style.left = "0px";
	            formScreen.style.top = "0px";

	            document.body.appendChild(formScreen);
	            var formText = request.responseText;
	            //문자열을 받아서 객체화해라 body 전체에 하면 안좋음 (이 건에 대해선 다음시간에)
	            formScreen.innerHTML=formText; // innerHTML은 텍스트가 없어서 대입도 가능함
	            //formScreen.innerHTML+=form;
	            var form = formScreen.querySelector("form");
	            form.style.background ="#fff";
	            form.style.width ="530px";
	            
	            //정중앙(수평)
	            form.style.marginLeft ="auto";
	            form.style.marginRight ="auto";

	            //정중앙(수직)
	            form.style.position="relative";
	            form.style.top="50%";
	            form.style.transform="translateY(-50%)";

	            var script = formScreen.querySelector("script");
	            eval(script.textContent);
	         };

			request.send();
			return false;
			
		};

		moreButton.onclick = function(){
			//var data  = eval('[{code:"1", title:"오오오"},{code:"2", title:"오호오"},{code:"3", title:"오히오"}];'); // eval은 매핑명에 큰 따옴표 안써줘도 된다.
/* 			var data = JSON.parse('[{"code":"1", "title":"오오오"},{"code":"2", "title":"오호오"},{"code":"3", "title":"오히오"}];'); // 제이슨 표기는 매핑 속성에 꼭 큰 따옴표 써줘야함. 多사용
			alert(data[1].code);
 */						
			//var request = new ActiveXObject("Microsoft.XMLHTTP"); // 윈도우에서만 사용 가능
			var request = new window.XMLHttpRequest(); // 모든 브라우저에서 사용할 경우

			
			request.open("GET", "ajax-data.jsp", true);
			
			 // false는 동기방식-데이터도착할때까지기다림

			// 비동기방식 이용할 경우, 데이터 도착 전에 다음 코드가 실행될 수 있음. 
			//이를 방지하기 위해 데이터 받는 넘한테 함수를 위임해줘야함
			

			request.onload = function(){ // readyState의 상태가 변한 경우
			// readyState - (1)unsent (2)opend (3) header rcv (4)data rcv (5) done
			
				//if(request.readyState==4){
				var notices = JSON.parse(request.responseText);
				
		 		var template = document.querySelector("#notice-row");
				
				for(var i in notices){
					var tbody = document.querySelector(".notice-table tbody");	
					var tds = template.content.querySelectorAll("td");
					
					tds[0].innerText = notices[i].code;
					tds[1].innerText = notices[i].title;
					
					var clone = document.importNode(template.content, true);
					tbody.appendChild(clone);
				};
				document.body.removeChild(screen); 		
 				
			};

			request.send();		
			
			var screen = document.createElement("div");
			screen.style.width="100%";
			screen.style.height="100%";
			screen.style.position = "fixed";
			screen.style.left = "0px";
			screen.style.top = "0px";
			screen.style.background = "#000";
			screen.style.opacity = "0.5";
			
			document.body.appendChild(screen);
			
			 };			
});

</script>
 
 
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
			<h2 class="main-title">공지사항<%=size %></h2>
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
							<option value="TITLE"<% if(field.equals("TITLE")){ %> selected <% } %>>제목</option>
							<option value="CONTENT"  <% if(field.equals("CONTENT")){ %> selected <% } %>>내용</option>
						</select> 
						
						<label>검색어</label> <input name="q" type="text" placeholder="검색어를 입력하세요" value=<%=query %>>
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
					
						<%for(NoticeView v : list){ %>
						<tr>
							<td><%= v.getCode() %></td>
							<td><a href="notice-detail.jsp?w=<%= v.getWriter() %>&t=<%=v.getTitle()%>&c=<%=v.getContent()%>&d=<%=v.getRegdate()%>&h=<%=v.getHit()%>"> <%= v.getTitle() %> </a></td>
							<td><%= v.getWriter() %></td>
							<td><%= v.getRegdate() %></td>
							<td><%= v.getHit() %></td>
					    </tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<div class="margin">1/3 pages</div>
			<!-- 제목도, 목록도, 문장도, 폼도, 표도 아니면 모두 div -->

			<div class="margin">
               <div><a href="">이전</a></div>
               <%
               		int last = (size % 10) >0 ?  size/10+1 :  size/10;
               %>
               <ul>
               	<%for(int i =1 ; i<= last ; i++){%>
                 	 <li><a href="?p=<%=i %>&q=<%=query%>&f=<%=field%>"><%=i%></a></li>
                 <%} %>
                  	
               </ul>
               <div><a href="">다음</a></div>
            </div>
 	        	<div>
 	        		<span id="reg-button">글쓰기</span>
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