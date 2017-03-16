

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice
 */
@WebServlet("/practice")
public class Practice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		response.setContentType("text/html;UTF-8");
		response.setCharacterEncoding("UTF-8");
		*/
		ServletContext context = request.getServletContext(); // 요청을 보낼 때 보낸 요청의 내용을 가져온다.
		String path = context.getRealPath("images/foto/danyang.jpg");
		System.out.println(path);
		
		/*
		OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os);
		out.print("안녕");*/
		
		/*PrintWriter out = response.getWriter();
		*/
		response.setContentType("image/jpeg;UTF-8");
		BufferedImage image = ImageIO.read(new File(path));
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpg",os);
	}

}
