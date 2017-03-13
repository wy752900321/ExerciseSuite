package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pojo.Picture;
import pojo.User;
import dao.DAOFactory;
import dao.PictureDAO;
import dao.UserDAO;

public class FriendActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FriendActionServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRequestURI();
		String action = path
				.substring(path.lastIndexOf("/"), path.indexOf("."));
		if (action.equals("/regist")) {
			HttpSession session = request.getSession();
			String num1 = request.getParameter("number");
			String num2 = (String) session.getAttribute("number");
			if (num2 != null && num2.equals(num1)) {
				String name = request.getParameter("name");
				String username = request.getParameter("username");
				String password = request.getParameter("pwd");
				String sexStr = request.getParameter("sex");
				String phone = request.getParameter("phone");
				int age = Integer.parseInt(request.getParameter("age"));
				boolean sex = false;
				if (sexStr.equals("m"))
					sex = true;
				User user = new User(username, password, name, age, sex, phone);
				UserDAO dao = (UserDAO) DAOFactory
						.getDAOInstance(UserDAO.class);
				dao.save(user);

				String dir = this.getServletContext().getRealPath("upload");
				File f = new File(dir + "/" +"pic_" + user.getId());
				f.mkdirs();
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("regist.jsp");
			}
			return;
		}

		if (action.equals("/login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			UserDAO dao = (UserDAO) DAOFactory.getDAOInstance(UserDAO.class);
			User u = dao.findByUsername(username);
			if (u != null) {
				if (u.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("id", u.getId());
					response.sendRedirect("listUsers.do");
				} else {
					response.sendRedirect("login.jsp");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
			return;
		}
		if (action.equals("/logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			return;
		}

		if (action.equals("/listUsers")) {
			try {
				UserDAO dao = (UserDAO) DAOFactory
						.getDAOInstance(UserDAO.class);
				List<User> users = dao.list();
				request.setAttribute("users", users);
				request.getRequestDispatcher("userList.jsp").forward(request,
						response);
			} catch (Exception e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("...");
			}
			return;
		}
		
		if(action.equals("/loadUser")){
			long id = Long.parseLong(request.getParameter("id"));
			try {
				UserDAO userDao = (UserDAO) DAOFactory
				.getDAOInstance(UserDAO.class);
				User user = userDao.findById(id);
				request.setAttribute("user", user);
				
				PictureDAO pDao = (PictureDAO) DAOFactory.getDAOInstance(PictureDAO.class);
				List<Picture> pictures = pDao.findByUserId(id);
				request.setAttribute("pictures", pictures);
				
				request.getRequestDispatcher("userDetail.jsp").forward(request, response);
			} catch (Exception e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("...");
			}
			return;
		}
		
		if(action.equals("/addPhoto")){
			long id = Long.parseLong(request.getParameter("id"));
			try{
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(dfif);
				upload.setSizeMax(10 * 1024 * 1024); 
				List list = upload.parseRequest(request); 
				System.out.println(list.size());
				PictureDAO dao = (PictureDAO) DAOFactory.getDAOInstance(PictureDAO.class);
				for(int i=0;i<list.size();i++) {
					FileItem item = (FileItem) list.get(i);
					String name = item.getName();
					System.out.println("name1:" + name);
					name = name.substring(name.lastIndexOf("\\") + 1);
					System.out.println("name2:" + name);
					String path1 = this.getServletContext().getRealPath("upload");
					String path2 = path1 + "/" + "pic_"+id;
					item.write(new File(path2, name));
					dao.save(new Picture(name,id));
				}
				
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
			response.sendRedirect("loadUser.do?id=" + id);
			return;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
