
<%@page import="java.util.ListIterator"%>
<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

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
	<tiles:insertAttribute name="header" />
	<!-- ---------------------------------------------비주얼------------------------------------------------------------ -->
	<tiles:insertAttribute name="visual" />
	<!-- -----------------------------------------------바디---------------------------------------------------------- -->
	<div id="body">
		<!-- 섹션과 메인을 div로 묶어줌 -->
		<div class="content-container clearfix">
			<!-- 사이드 부분 -->
			<tiles:insertAttribute name="aside" />
			
			<!-- 메인 부분 -->
			

		</div>
	</div>

	<!-- -----------------------------------------------푸터---------------------------------------------------------- -->
	<tiles:insertAttribute name="footer" />

</body>
</html>