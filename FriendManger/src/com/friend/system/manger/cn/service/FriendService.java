package com.friend.system.manger.cn.service;

import java.util.List;

import com.friend.system.manger.cn.bean.Friend;

public interface FriendService {
	/**
	 * 查询出第几页的数据
	 * @param page
	 * @return
	 */
	List<Friend> findFriends(int page);
	/**
	 * 返回 总页数
	 * @return
	 */
	int getTotalPages();
	/**
	 *  通过 id 查找 对应的朋友 
	 * @param id
	 * @return
	 */
	Friend findFriendById(long id);
	/**
	 * 添加联系人
	 * 
	 * @param friend
	 * @return
	 */
	long addFriend(Friend friend);
	/**
	 * 根据用户的id 查找出 该用户的联系人
	 * @param id
	 * @param i
	 * @return
	 */
	List<Friend> findMyFriends(long id, int i);
	/**
	 * 得到朋友的数目
	 * @return
	 */
	int getCount();
}
