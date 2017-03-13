package com.friend.system.manger.cn.service.impl;

import java.util.List;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.dao.FriendDao;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;
import com.friend.system.manger.cn.service.FriendService;
import com.friend.system.manger.cn.util.LimitUtil;

public class FriendServiceImpl implements FriendService {
	private FriendDao friendDao;
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
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the allPages
	 */
	@Override
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return the friendDao
	 */
	public FriendDao getFriendDao() {
		return friendDao;
	}

	/**
	 * @param friendDao
	 *            the friendDao to set
	 */
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	public List<Friend> findFriends(int page) {
		List<Friend> friends = null;
		count = friendDao.count();
		totalPages = LimitUtil.getTotalPages(count);
		try {
			friends = friendDao.findFriends(LimitUtil.getPageCount(), LimitUtil
					.getStart(page));
		} catch (NotFindDataException e) {
			e.printStackTrace();
		}
		return friends;
	}

	@Override
	public Friend findFriendById(long id) {
		Friend friend = null;
		try {
			friend = friendDao.findFriendByid(id);
		} catch (NotFindDataException e) {
			e.printStackTrace();
		}
		return friend;
	}

	@Override
	public long addFriend(Friend friend) {
		long id = -1;
		try {
			id = friendDao.save(friend);
		} catch (NotFindDataException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Friend> findMyFriends(long id, int page) {
		List<Friend> friends = null;
		count = friendDao.myFriendCount(id);
		totalPages = LimitUtil.getTotalPages(count);
		friends = friendDao.findMyFriends(id, LimitUtil.getPageCount(),
				LimitUtil.getStart(page));
		return friends;
	}
}
