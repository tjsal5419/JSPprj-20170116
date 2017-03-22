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
		// ����(����)���� Ŭ���̾�Ʈ�� ���ε��� ���� �����ϱ�


		// �������� ���� ó���ϱ�(html���� ���� ÷�� �ǳ�, ���������� ÷�ε� ������ �޾ƿ��� ��� x)
		// ���ڵ�Ÿ�� = multipart �̿�

		
	//������ ������ ���� ���丮 ����
		PrintWriter out = response.getWriter();
	   ServletContext ctx = request.getServletContext();
	   String path = ctx.getRealPath("/customer/upload"); // realPath = �������丮, Ž������ ��� = ���� ���丮
	   out.write(path);

	   
//	 	��ΰ� �������� ���� ���, ��θ� ������ֱ� ���� File��ü
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
