
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
    window.addEventListener("load",function()
    {
        var regButton = document.querySelector("#reg-button");
        var moreButton = document.querySelector("#more-button");
    
        regButton.onclick = function(){
			var request = new window.XMLHttpRequest();
			request.open("GET","ajax-data.jsp",true);
			// ture 시, request객체 전송 후에 response객체 도착할 때까지 기다리지 않고
			// 다음 코드를 실행한다.
			
			request.onload = function(){ // readyState 가 rcv 상태인 경우 진행!
				var form = request.responseText;
				document.body.innerHTML += form;
				alert(form);
			};
			
			request.send();
        	
        };

        moreButton.onclick = function(){
            //ajax - 비동기식 요청
            var request = new window.XMLHttpRequest();
            request.open("GET","ajax-data.jsp",true);

            request.onload = function(){
               var notices = JSON.parse(request.responseText);
               var template = document.querySelector("#notice-row");

               for(var i in notices){
                   var tbody = document.querySelector(".notice-table tbody");
                   var tds = template.content.querySelectorAll("td"); // 템플릿의 한 행의 rows들을 가져옴
                   
                   tds[0].innerText = notices[i].code; // 각 열에 요소 추가 
                   tds[1].innerText = notices[i].title;
                   
                   //템플릿 한 행 완성!!!
                   
                   var clone = document.importNode(template.content, true); //템플릿 복제
                   tbody.appendChild(clone);  //템플릿 추가
                   
               }
               document.body.removeChild(screen); // 스크린을 제거해야함
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
			
			document.body.appendChild(screen); // 스크린을 추가
        };

    });
</script>

	<!-- ---------------------------------------------헤 더------------------------------------------------------------ -->
<body>
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

          	<div>
 	        		<a id="reg-button" href="">등록</a>
 	        		<span id="more-button">더보기</span>
	        </div>
</body>
</html>