import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      PrintWriter out = response.getWriter();

      int result = 0;

      out.write("<form action=\"add\" method=\"post\">");
      out.write("    <ul>");
      out.write("        <li><label for=\"x\">X :</label><input name=\"x\" /></li>");
      out.write("        <li><label for=\"y\">Y :</label><input name=\"y\" /></li>");
      out.write("    </ul>");
      out.write("    <p>");
      out.printf("    <input type=\"hidden\" name=\"result\" value=\"%d\" />", result);
      out.write("    <input type=\"submit\" name=\"btn\" value=\"덧셈\" />");
      out.write("    <input type=\"submit\" name=\"btn\" value=\"application\" />");
      out.write("    <input type=\"submit\" name=\"btn\" value=\"session\" />");
      out.write("    <input type=\"submit\" name=\"btn\" value=\"cookie\" />");
      out.write("    </p>");
      out.write("    <p><a href=\"data-view\">데이터보기</a></p>");
      out.write("</form>");

   }

   @Override   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      PrintWriter out = response.getWriter();

      String _x = request.getParameter("x");
      String _y = request.getParameter("y");

      // 세션버튼인지 쿠키버튼인지 어플리케이션버튼인지 구분하기 위해 버튼의 값을 가져오고
      String btn = request.getParameter("btn");

      int x = Integer.parseInt(_x);
      int y = Integer.parseInt(_y);

      int result = x + y;

      // 세션에 담을 것인지
      // 세션이라면
      if (btn.equals("session")) {
         request.getSession().setAttribute("result", result);
      }

      // 쿠키에 담을 것인지
      if (btn.equals("cookie")) {
         Cookie cookie = new Cookie("result", String.valueOf(result));
         cookie.setMaxAge(60*60*24);
         response.addCookie(cookie);
      }

      // 어플리케이션에 담을 것인지
      if (btn.equals("application")) {
         request.getServletContext().setAttribute("result", result);
      }

      out.println("<script>alert('"+btn+" 에 저장되었습니다.');location.href='add';</script>");
      // response.sendRedirect("add");
      
      //저장된 데이터는 현재 이 브라우저를 사용하고 있는 사용자라면 어디서 요청하든 쓸 수 있음
      //지금은 저장밖에 안하고 저장을 읽어오는 것이 없음
      //다른페이지에서 저장된 정보를 불러오기 위해 다른 페이지를 추가 >그래서 데이터 보기 링크 추가
      
      
      //쿠키 설정 바꾸기 위해서 web.xml에
      //<session-config>
       //<session-timeout>1</session-timeout>
       //</session-config>
      //이거 복사해둠(서블릿 아래에)
   }
}