import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data-view")
public class DataView extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("charset=UTF-8; text/html");
      
      PrintWriter out = response.getWriter();      
      
      String _s = String.valueOf(request.getSession().getAttribute("result"));
      String _a = String.valueOf(request.getServletContext().getAttribute("result"));
      //쿠키는 무조건 for문 돌려서 있는지 없는지 찾아서 가져와야함      
      Cookie[] cookies = request.getCookies();
      String _c = "";      
      if(cookies != null)
         for(Cookie cookie : cookies)
            if(cookie.getName().equals("result"))
               _c=cookie.getValue();
      
      String s="";
      String c="";
      String a="";
      
      if(_s!=null){
         s=_s;
      }

      c=_c;
      
      if(_a!=null){
         a=_a;
      }
      //어플리케이션 데이터는 크롬에 저장하고 익스플로어에서 봐도 데이터가 여전히 살아있음 어플리케이션은 모든 사용자가 사용 가능한 데이터
      
      out.write("<html>");
      out.printf("session data : %s</br>", s);
      out.printf("cookie data : %s</br>", c);
      out.printf("application data : %s</br>", a);
      out.println("<a href=\"add\">데이터편집</a>");
      out.write("</html>");
   }

}