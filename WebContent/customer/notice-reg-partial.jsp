<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	window.addEventListener("load", function(e) {
		var regButton = document.querySelector("#reg-button");

 		regButton.onclick = function(){
 			alert("등록되었습니다.");
 		};
	});
</script>

    <form action="#" method="post">
            <table border="1">
               <tbody>
                  <tr>
                     <th>제목</th>
                     <td><input type="text"  name="title"/></td>
                  </tr>
                  <tr>                  
                     <td colspan="2">
                        <textarea rows="20" cols="80" name="content"></textarea>
                     </td>
                  </tr>   
               </tbody>
            </table>
            <div>      
               <input class="reg-button" type="submit" value="등록" />         
               <a href="notice.jsp">취소</a>
            </div>
	</form>            
</body>
</html>