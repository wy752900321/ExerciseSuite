package com.friend.system.manger.cn.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Message;
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

public class UserOwn extends HttpServlet {

	private static final long serialVersionUID = -799317517273049550L;

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
			HttpServletResponse response, String path) throws ServletException, IOException {
		if(path.equals("showAll")){
			showAll(request,response);
		}
		else if(path.equals("delete")){
			delete(request,response);
		}
		else if(path.equals("showMe")){
			showMe(request,response);
		}
		else if(path.equals("teamFriend")){
			teamFriend(request,response);
		}
		else if(path.equals("showMeFriend")){
			showMeFriend(request,response);
		}
		else if(path.equals("leaveMessage")){
			leaveMessage(request,response);
		}
		else if(path.equals("leave")){
			leave(request,response);
		}
		else if(path.equals("showMessage")){
			showMessage(request,response);
		}
		else if(path.equals("deleteMessage")){
			deleteMessage(request,response);
		}
		else if(path.equals("showImg")){
			showImg(request,response);
		}
		else if(path.equals("deleteImg")){
			deleteImg(request,response);
		}
	}

	private void deleteImg(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		long id = Long.parseLong(request.getParameter("id"));
		User user =(User)request.getSession().getAttribute("user");
		UserService userService = createUserService();
		Photo photo = userService.deletePhoto(id);
		Uplode.delete(request,photo.getImg(),this);
		response.sendRedirect("showImg.userOwn?id="+user.getId());
	}

	private void showImg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int now = 1;
		String page = request.getParameter("page");
		if (page != null) {
			now = Integer.parseInt(page);
		}
		long id = Long.parseLong(request.getParameter("id"));
		UserService userService = createUserService();
		List<Photo> photos = userService.findPhotosByFriendId(id,now);
		FriendService friendService = createFriendService();
		Friend friend = friendService.findFriendById(id);
		request.setAttribute("totalPages",userService.getTotalPages());
		request.setAttribute("now", now);
		request.setAttribute("photos", photos);
		request.setAttribute("friend", friend);
		request.getRequestDispatcher("showImg.jsp").forward(request, response);
	}

	private void deleteMessage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		long id = Long.parseLong(request.getParameter("id"));
		UserService userService = createUserService();
		userService.deleteMessageById(id);
		response.sendRedirect("showMessage.userOwn");
	}

	private void showMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int now = 1;
		String page = request.getParameter("page");
		if (page != null) {
			now = Integer.parseInt(page);
		}
		UserService userService = createUserService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Message> messages = new ArrayList<Message>();
		messages = userService.findMyMessages(user.getId(), now);
		request.setAttribute("size", messages.size());
		request.setAttribute("totalPages", userService.getTotalPages());
		request.setAttribute("now", now);
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("showMessage.jsp").forward(request, response);
	}

	private void leave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long friendId = Long.parseLong(request.getParameter("friendId"));
		FriendService friendService = createFriendService();
		Friend friend = friendService.findFriendById(friendId);
		request.setAttribute("friend",friend);
		request.getRequestDispatcher("leaveMessage.jsp").forward(request, response);
	}

	private void leaveMessage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		long friendId = Long.parseLong(request.getParameter("friendId"));
		User user = (User)request.getSession().getAttribute("user");
		String message = request.getParameter("message");
		Message me = new Message();
		me.setMessage(message);
		User u = new User();
		u.setId(friendId);
		me.setUser(u);
		me.setMessageUser(user);
		UserService userService = createUserService();
		userService.saveMessage(me);
		response.sendRedirect("showMe.userOwn");
	}

	private void showMeFriend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long friendId = Long.parseLong(request.getParameter("friendId"));
		User user = (User)request.getSession().getAttribute("user");
		FriendService friendService = createFriendService();
		UserService userService = createUserService();
		Friend friend = friendService.findFriendById(friendId);
		request.setAttribute("friend", friend);
		Team team = userService.findTeamByteamId(user.getId(), friendId);
		request.setAttribute("team", team);
		request.getRequestDispatcher("me.jsp").forward(request, response);
	}

	private void teamFriend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserService userService = createUserService();
		
		int now = 1;
		String page = request.getParameter("page");
		if (page != null) {
			now = Integer.parseInt(page);
		}
		long teamId = Long.parseLong(request.getParameter("id"));
		List<Friend> friends = userService.findMyFriendByTeamId(teamId, now);
		Team team = userService.findTeamByteamId(teamId);
		request.setAttribute("team", team);
		request.setAttribute("size", friends.size());
		request.setAttribute("totalPages", userService.getTotalPages());
		request.setAttribute("now", now);
		request.setAttribute("friends", friends);
		request.getRequestDispatcher("teamFriend.jsp").forward(request, response);
	}

	private void showMe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		FriendService friendService = createFriendService();
		UserService userService = createUserService();
		Friend friend = friendService.findFriendById(user.getId());
		request.setAttribute("friend", friend);
		List<Team> teams = userService.findTeamsByFriendId(user.getId());
		request.setAttribute("teams", teams);
		request.setAttribute("size", teams.size());
		request.getRequestDispatcher("me.jsp").forward(request, response);
	}
	private UserService createUserService() {
		UserServiceImpl userService = (UserServiceImpl) FactoryUtil
				.getInstance("userService");
		userService.setUserDao((UserDao) FactoryUtil.getInstance("userDao"));
		userService.setPhotoDao((PhotoDao) FactoryUtil.getInstance("photoDao"));
		userService.setTeamDao((TeamDao) FactoryUtil.getInstance("teamDao"));
		return userService;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		long friendId = Long.parseLong(request.getParameter("friendId"));
		UserService userService = createUserService();
		long teamId = userService.findTeamByteamId(user.getId(), friendId).getId();
		userService.deleteFriendById(user.getId(), friendId);
		request.getRequestDispatcher("teamFriend.userOwn?id="+teamId).forward(request, response);
	}

	private void showAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FriendService friendService = createFriendService();
		int now = 1;
		String page = request.getParameter("page");
		if (page != null) {
			now = Integer.parseInt(page);
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Friend> friends = new ArrayList<Friend>();
		friends = friendService.findMyFriends(user.getId(),now);
		request.setAttribute("size", friends.size());
		request.setAttribute("totalPages", friendService.getTotalPages());
		request.setAttribute("now", now);
		request.setAttribute("friends", friends);
		request.getRequestDispatcher("myFriend.jsp").forward(request, response);
	}

	private FriendService createFriendService() {
		FriendService friendService = (FriendServiceImpl) FactoryUtil
				.getInstance("friendService");
		((FriendServiceImpl) friendService)
				.setFriendDao((FriendDao) FactoryUtil.getInstance("friendDao"));
		return friendService;
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
