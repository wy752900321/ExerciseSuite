package com.friend.system.manger.cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.FriendDao;
import com.friend.system.manger.cn.dao.PhotoDao;
import com.friend.system.manger.cn.dao.TeamDao;
import com.friend.system.manger.cn.dao.UserDao;
import com.friend.system.manger.cn.service.FriendService;
import com.friend.system.manger.cn.service.UserService;
import com.friend.system.manger.cn.service.impl.FriendServiceImpl;
import com.friend.system.manger.cn.service.impl.UserServiceImpl;
import com.friend.system.manger.cn.util.FactoryUtil;

public class FriendAction extends HttpServlet {

	private static final long serialVersionUID = 2587566214420184771L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println(url);
		String path = url.substring(url.lastIndexOf("/") + 1, url
				.lastIndexOf("."));
		System.out.println(path);
		geometry(request, response, path);
	}

	private void geometry(HttpServletRequest request,
			HttpServletResponse response, String path) throws ServletException,
			IOException {
		if (path.equals("list")) {
			list(request, response);
		} else if (path.equals("show")) {
			show(request, response);
		} else if (path.equals("regist")) {
			regist(request, response);
		} else if (path.equals("checkNum")) {
			checkNum(request, response);
		}
	}

	private void checkNum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out =response.getWriter();
		String userNum = request.getParameter("userCheck");
		System.out.println("写入的验证码－＞"+userNum);
		String num = (String) request.getSession().getAttribute("check");
		System.out.println("实际生成的验证－＞"+	num);
		System.out.println(userNum);
		if (!num.equals(userNum)) {
			out.println("验证码输入错误 !!!!!");
			return;
		}
	}

	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		UserService userService = createUserService();
		User user = userService.findUserByUserName(userName);
		if (user != null) {
			fail(request, response, "userNameMessage", "用户名已经存在", "regist.jsp");
			return;
		}
		String password = request.getParameter("password");
		String pwd = request.getParameter("pwd");
		if (!password.equals(pwd)) {
			fail(request, response, "passwordMessage", "两次输入的密码不一致!!!!",
					"regist.jsp");
			return;
		}
		String name = request.getParameter("name");
		Date brithday = Date.valueOf(request.getParameter("brithday"));
		int sex = Integer.parseInt(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		Friend friend = parseFriend(name, brithday, phone, qq, sex, info,
				address);
		FriendService friendService = createFriendService();
		long id = friendService.addFriend(friend);
		user = parseUser(id, userName, password);
		userService.addUser(user);
		Team team = new Team("我的好友", "系统默认分组");
		team.setUser(user);
		userService.addTeam(team);
		response.sendRedirect("login.jsp");
	}

	private Friend parseFriend(String name, Date brithday, String phone,
			String qq, int sex, String info, String address) {
		Friend friend = new Friend(name, qq, phone, address, info);
		friend.setBrithday(brithday);
		friend.setSex(sex);
		return friend;
	}

	private User parseUser(long id, String userName, String password) {
		User user = new User(userName, password);
		user.setId(id);
		return user;
	}

	private void fail(HttpServletRequest request, HttpServletResponse response,
			String name, String value, String path) throws ServletException,
			IOException {
		request.setAttribute(name, value);
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		FriendService friendService = createFriendService();
		Friend friend = friendService.findFriendById(id);
		request.setAttribute("friend", friend);
		request.getRequestDispatcher("friend.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int now = 1;
		String page = request.getParameter("page");
		if (page != null) {
			now = Integer.parseInt(page);
		}
		FriendService friendService = createFriendService();
		List<Friend> friends = friendService.findFriends(now);
		request.setAttribute("totalPages", friendService.getTotalPages());
		request.setAttribute("now", now);
		request.setAttribute("friends", friends);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private FriendService createFriendService() {
		FriendService friendService = (FriendServiceImpl) FactoryUtil
				.getInstance("friendService");
		((FriendServiceImpl) friendService)
				.setFriendDao((FriendDao) FactoryUtil.getInstance("friendDao"));
		return friendService;
	}

	private UserService createUserService() {
		UserServiceImpl userService = (UserServiceImpl) FactoryUtil
				.getInstance("userService");
		userService.setUserDao((UserDao) FactoryUtil.getInstance("userDao"));
		userService.setPhotoDao((PhotoDao) FactoryUtil.getInstance("photoDao"));
		userService.setTeamDao((TeamDao) FactoryUtil.getInstance("teamDao"));
		return userService;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
