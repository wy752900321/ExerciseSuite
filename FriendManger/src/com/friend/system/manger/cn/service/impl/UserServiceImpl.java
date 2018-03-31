package com.friend.system.manger.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.friend.system.manger.cn.bean.Concern;
import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Message;
import com.friend.system.manger.cn.bean.Photo;
import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.PhotoDao;
import com.friend.system.manger.cn.dao.TeamDao;
import com.friend.system.manger.cn.dao.UserDao;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;
import com.friend.system.manger.cn.service.UserService;
import com.friend.system.manger.cn.util.LimitUtil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private PhotoDao photoDao;
	private TeamDao teamDao;
	private int count;
	private int totalPages;
	
	
	/**
	 * @return the count
	 */
	@Override
	public int getCount() {
		return count;
	}

	/**
	 * @return the totalPages
	 */
	@Override
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param teamDao the teamDao to set
	 */
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	/**
	 * @param photoDao the photoDao to set
	 */
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findUserByUserName(String userName) {
		User user = null;
		try {
			user = userDao.findUserByUserName(userName);
		} catch (NotFindDataException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void addUser(User user) {
		try {
			userDao.save(user);
		} catch (NotFindDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPhoto(Photo photo) {
		photoDao.save(photo);
	}
	@Override
	public void addTeam(Team team){
		teamDao.save(team);
	}
	@Override
	public List<Team> findTeamsByFriendId(Long userId) {
		
		return teamDao.findTeamsByUserId(userId);
	}
	@Override
	public void addConcern(Concern concern) {
		long teamId = concern.getTeam().getId();
		long friendId = concern.getFriend().getId();
		userDao.save(teamId,friendId);
	}
	@Override
	public List<Friend> findMyFriendByTeamId(long teamId ,int now) {
		List<Friend> friends = null;
		count = userDao.teamFriendCount(teamId);
		totalPages = LimitUtil.getTotalPages(count);
		friends = userDao.findFriendsIdByTeamId(teamId, LimitUtil.getPageCount(), LimitUtil.getStart(now));
		return friends;
	}
	@Override
	public void deleteFriendById(long userId,long friendId) {
		userDao.deleteFriendById(userId,friendId);
	}

	@Override
	public Team findTeamByteamId(long teamId) {
		return teamDao.findTeamsByTeamId(teamId);
	}
	@Override
	public Team findTeamByteamId(long userId, long friendId) {
		
		return userDao.findTeamIdByuserIdFriendId(userId, friendId);
	}
	@Override
	public void saveMessage(Message me) {
		userDao.saveMessage(me);
	}
	@Override
	public List<Message> findMyMessages(long userId, int page) {
		List<Message> messages = null;
		count = userDao.messageCount(userId);
		totalPages = LimitUtil.getTotalPages(count);
		messages = userDao.findMessages(userId, LimitUtil.getPageCount(), LimitUtil.getStart(page));
		return messages;
	}
	@Override
	public void deleteMessageById(long id) {
		userDao.deleteMessageById(id);
	}

	@Override
	public Photo deletePhoto(long id) {
		return photoDao.deletePhoto(id);
	}

	@Override
	public List<Photo> findPhotosByFriendId(long friendId,int page) {
		List<Photo> photos = new ArrayList<Photo>();
		count = photoDao.photoCount(friendId);
		totalPages = LimitUtil.getTotalPages(count);
		photos = photoDao.findPhotosByUserId(friendId,LimitUtil.getPageCount(), LimitUtil.getStart(page));
		return photos;
	}
}
