package com.friend.system.manger.cn.test;

import java.util.List;

import org.junit.Test;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.dao.FriendDao;
import com.friend.system.manger.cn.service.FriendService;
import com.friend.system.manger.cn.service.impl.FriendServiceImpl;
import com.friend.system.manger.cn.util.FactoryUtil;

public class TestService {
	private FriendService friendService = (FriendServiceImpl)FactoryUtil.getInstance("friendService");
	private FriendDao friendDao = (FriendDao)FactoryUtil.getInstance("friendDao");
	
	public void testFindFriends(){
		((FriendServiceImpl)friendService).setFriendDao(friendDao);
		List<Friend> friends = friendService.findFriends(1);
		for (Friend friend : friends) {
			System.out.println(friend.getName());
		}
	}
	@Test
	public void testFindFriendById(){
		((FriendServiceImpl)friendService).setFriendDao(friendDao);
		Friend friend = friendService.findFriendById(2);
		System.out.println(friend.getName());
	}
}
