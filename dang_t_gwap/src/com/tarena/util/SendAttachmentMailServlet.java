package com.tarena.util;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.mail.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

/**
 * 发送邮件示例
 * 
 * @author soft01
 * 
 */
public class SendAttachmentMailServlet extends HttpServlet {
	private static final long serialVersionUID = 732051841860692986L;
	private String savePath;
	ServletContext sc;
	private Map<String, String> parameters = new HashMap<String, String>();

	// 初始化
	public void init(ServletConfig config) {
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}

	// post方式发送email
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		File file = doAttachment(request);
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(file.getPath());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(file.getName());
		MultiPartEmail email = new MultiPartEmail();
		email.setCharset("UTF-8");
		email.setHostName("smtp.sina.com");
		email.setAuthentication("T-GWAP", "dangdang");
		try {
			email.addTo(parameters.get("to"));
			email.setFrom(parameters.get("from"));
			email.setSubject(parameters.get("subject"));
			email.setMsg(parameters.get("body"));
			email.attach(attachment);
			email.send();
			request.setAttribute("sendmail.message", "邮件发送成功！");
		} catch (EmailException e) {
			Logger logger = Logger.getLogger(SendAttachmentMailServlet.class);
			logger.error("邮件发送不成功", e);
			request.setAttribute("sendmail.message", "邮件发送不成功！");
		}
		request.getRequestDispatcher("/sendResult.jsp").forward(request,
				response);
	}

	public File doAttachment(HttpServletRequest request)
			throws ServletException, IOException {
		File file = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<?> items = upload.parseRequest(request);
			Iterator<?> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					parameters
							.put(item.getFieldName(), item.getString("UTF-8"));
				} else {
					File tempFile = new File(item.getName());
					file = new File(sc.getRealPath("/") + savePath, tempFile
							.getName());
					item.write(file);
				}
			}
		} catch (Exception e) {
			Logger logger = Logger.getLogger(SendAttachmentMailServlet.class);
			logger.error("邮件发送出了异常", e);
		}
		return file;
	}
}
