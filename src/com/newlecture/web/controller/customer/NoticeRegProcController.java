package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.dao.mysql.MySQLNoticeFileDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.NoticeFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/customer/notice-reg-proc")
public class NoticeRegProcController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버(서블릿)에서 클라이언트가 업로드한 파일 저장하기


		// 서블릿에서 파일 처리하기(html에는 파일 첨부 되나, 서블릿에서는 첨부된 파일을 받아오는 기능 x)
		// 인코딩타입 = multipart 이용

		
	//파일을 저장할 배포 디렉토리 지정
		PrintWriter out = response.getWriter();
	   ServletContext ctx = request.getServletContext();
	   String path = ctx.getRealPath("/customer/upload"); // realPath = 배포디렉토리, 탐색기의 경로 = 가상 디렉토리
	   out.write(path);

	   
//	 	경로가 존재하지 않을 경우, 경로를 만들어주기 위한 File객체
	   File d = new File(path);
	   
	   if(!d.exists()){
		   d.mkdir();
	   }
	   

	    MultipartRequest req = new MultipartRequest(request, path, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
	    
	   String title = req.getParameter("title");
	   String content = req.getParameter("content");
	   
	  
	   out.println(title+"<br/>");
	   out.println(content+"<br/>");
	   
	   
		NoticeDao noticeDao = new MySQLNoticeDao();
		
	   	String noticeCode = noticeDao.lastCode();
		int result = noticeDao.add(title, content, "TJSAL");
	   	int result1 = 0;
		NoticeFileDao noticeFileDao = new MySQLNoticeFileDao();

		Enumeration fnames = req.getFileNames();
		
		while(fnames.hasMoreElements()){
			
			String f = (String)fnames.nextElement();
			String fname = (String)req.getFilesystemName(f);
					
			NoticeFile file = new NoticeFile();
			file.setNoticeCode(noticeCode);
			file.setSrc(fname);
			
			result1 = noticeFileDao.add(file);
			
			out.print("1");
			//noticeFileDao.add(file);
			out.print("<br/>");
			out.println(f);
			out.print("<br/>");
			out.println(fname);
		}
	 	  if(result > 0)
	 	  {
		      response.sendRedirect("notice.jsp");
		    	System.out.println("r:"+result1);  
	 	  }
		  else
		      response.sendRedirect("");
	}

}
