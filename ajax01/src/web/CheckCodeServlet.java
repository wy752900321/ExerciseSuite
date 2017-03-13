package web;

import java.awt.Color;
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

	/**
	 * Constructor of the object.
	 */
	public CheckCodeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(60, 20,
				BufferedImage.TYPE_INT_RGB);
		Random r = new Random();
		Graphics g = image.getGraphics();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 60, 20);
		g.setColor(new Color(0,0,0));
		String number = String.valueOf(r.nextInt(99999)); 
		session.setAttribute("number", number);
		g.drawString(number, 5, 15);

		OutputStream os = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		encoder.encode(image);
	}

	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
