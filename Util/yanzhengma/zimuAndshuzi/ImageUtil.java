package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("image/jpeg");
			int width = 60;
			int height = 20;
			//内存映射图像
			BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Random r = new Random();
			//获取画笔
			Graphics g = image.getGraphics();
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.fillRect(0, 0, width, height);
			g.setColor(new Color(0,0,0));
			//设置字体
			g.setFont(new Font("Arial",22,18));
			StringBuffer checkcode = new StringBuffer();
			String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			int length = code.length();
			for(int i=0;i<4;i++){
				int start = r.nextInt(length);
				checkcode.append(code.substring(start, (start+1)));
			}
			String check = checkcode.toString();
			HttpSession session = request.getSession();
			session.setAttribute("check", check);
			g.drawString(check, 5, 15);
			for(int i=0;i<100;i++){
				g.drawOval(r.nextInt(width), r.nextInt(height), 0, 0);
			}
			//获取字节输出流
			OutputStream os = response.getOutputStream();
			//压缩图像
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(image);
	}

}
