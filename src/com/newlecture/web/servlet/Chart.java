package com.newlecture.web.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chart
 */
@WebServlet("/tool/chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");
		
		String url = "images/foto/StephansPlatz.bmp";
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(url);

		BufferedImage image = ImageIO.read(new File(path));
		
		Graphics2D g = image.createGraphics();

		
		// x축
		//색 변경(blue)
		g.setColor(Color.blue);
		g.drawLine(34, 413, 792, 413);
		
		// 왼쪽 y축
		g.drawLine(50, 38, 50, 430);
		g.drawString("▲", 45, 38);
		
		// 오른쪽 y축
		
		//색 변경(red)
		g.setColor(Color.red);
		g.drawLine(780, 38, 780, 430);
		g.drawString("▲", 775, 38);
		
		//색 변경(black)
		g.setColor(Color.BLACK);
		g.drawString("누적상대도수(%)", 730, 24);
		g.drawString("인원(명)", 30, 24);
		
		g.drawString("2", 30, 353);
		g.drawString("20", 785, 356);
		dotline(g, 50, 353);
		
		g.drawString("4", 30, 300);
		g.drawString("40", 785, 303);
		dotline(g, 50, 293);
		
		g.drawString("6", 30, 242);
		g.drawString("60", 785, 245);
		dotline(g, 50, 233);
		
		g.drawString("8", 30, 174);
		g.drawString("80", 785, 177);
		dotline(g, 50, 173);
		
		g.drawString("10", 25, 115);
		g.drawString("100", 785, 118);
		dotline(g, 50, 113);
		
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpg",os);

	}
	//점선 그리는 함수
	public static void dotline(Graphics2D g, int x, int y) {
		for(int i=0; i<104; i++) {
			g.drawString("-", x, y);
			x+=7;
		}
	}
}
