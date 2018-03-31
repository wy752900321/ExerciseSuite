package com.friend.system.manger.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friend.system.manger.cn.bean.Concern;
import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Photo;
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
import com.friend.system.manger.cn.util.Uplode;

public class UserAction extends HttpServlet {

	private static final long serialVersionUID = 4691501203269127411L;

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
		if (path.equals("login")) {
			login(request, response);
		} else if (path.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("./index.jsp");
		} else if (path.equals("up")) {
			up(request, response);
		} else if (path.equals("touchTeam")) {
			touchTeam(request, response);
		} else if (path.equals("allFriend")) {
			allfriend(request, response);
		}
		else if (path.equals("showFriend")) {
			showFriend(request, response);
		}
		else if (path.equals("addFriend")) {
			addFriend(request, response);
		}
		else if (path.equals("add")) {
			add(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long friendId = Long.parseLong(request.getParameter("id"));
		long teamId = Long.parseLong(request.getParameter("team"));
		Friend friend = new Friend();
		friend.setId(friendId);
		Team team = new Team();
		team.setId(teamId);
		Concern concern = new Concern();
		concern.setFriend(friend);
		concern.setTeam(team);
		UserService userService = createUserService();
		userService.addConcern(concern);
		response.sendRedirect("myFriend.jsp");
	}

	private void addFriend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		FriendService friendService = createFriendService();
		Friend friend = friendService.findFriendById(id);
		UserService userService = createUserService();
		id = ((User)request.getSession().getAttribute("user")).getId();
		List<Team> teams = userService.findTeamsByFriendId(id);
		System.out.println(teams.size());
		request.setAttribute("teams", teams);
		request.setAttribute("friend", friend);
		request.getRequestDispatcher("addFriend.jsp").forward(request, response);
	}

	private void showFriend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		FriendService friendService = createFriendService();
		Friend friend = friendService.findFriendById(id);
		request.setAttribute("friend", friend);
		request.getRequestDispatcher("friend.jsp").forward(request, response);
	}

	private void allfriend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	private FriendService createFriendService() {
		FriendService friendService = (FriendServiceImpl) FactoryUtil
				.getInstance("friendService");
		((FriendServiceImpl) friendService)
				.setFriendDao((FriendDao) FactoryUtil.getInstance("friendDao"));
		return friendService;
	}

	private void touchTeam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		User user = (User) request.getSession().getAttribute("user");
		Team team = new Team(name, info);
		team.setUser(user);
		UserService userService = createUserService();
		userService.addTeam(team);
		response.sendRedirect("main.jsp");
	}

	private void up(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String[] names = Uplode.getOrdinaryFileds(request);
		String img = Uplode.getImage(request,this);
		Photo photo = new Photo();
		photo.setImg(img);
		photo.setName(names[0]);
		photo.setInfo(names[1]);
		photo.setUser((User) request.getSession().getAttribute("user"));
		UserService userService = createUserService();
		userService.addPhoto(photo);
		response.sendRedirect("main.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		UserService userService = createUserService();
		User user = userService.findUserByUserName(userName);
		if (user == null) {
			fail(request, response, "userNameMessage", "该用户不存在 !!!!!",
					"login.jsp");
			return;
		}
		String password = request.getParameter("password");
		if (!user.getPassword().equals(password)) {
			fail(request, response, "passwordMessage", "密码输入错误 !!!!!",
					"login.jsp");
			return;
		}
		request.getSession().setAttribute("user", user);
		response.sendRedirect("user/main.jsp");
	}

	private UserService createUserService() {
		UserServiceImpl userService = (UserServiceImpl) FactoryUtil
				.getInstance("userService");
		userService.setUserDao((UserDao) FactoryUtil.getInstance("userDao"));
		userService.setPhotoDao((PhotoDao) FactoryUtil.getInstance("photoDao"));
		userService.setTeamDao((TeamDao) FactoryUtil.getInstance("teamDao"));
		return userService;
	}
	private void fail(HttpServletRequest request, HttpServletResponse response,
			String name, String value, String path) throws ServletException,
			IOException {
		request.setAttribute(name, value);
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
