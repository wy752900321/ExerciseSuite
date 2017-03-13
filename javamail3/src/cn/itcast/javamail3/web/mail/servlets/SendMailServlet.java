package cn.itcast.javamail3.web.mail.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.javamail2.Demo2;

public class SendMailServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//Demo2.main(new String[]{});
			
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			Session session = (Session) envCtx.lookup("mail/Dog");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("itcast_test@sina.com"));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress("itcast_test@sina.com");
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("ha");
			message.setText("test");
			//Transport.send(message);
			Transport transport = session.getTransport();
			transport.connect("smtp.sina.com", "itcast_test", "123456");
			transport.sendMessage(message, to);
			transport.close();
			response.getWriter().print("ok!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(response.getWriter());
		}
	}

}
