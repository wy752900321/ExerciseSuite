package com.friend.system.manger.cn.test;

import java.util.List;

import org.junit.Test;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.FriendDao;
import com.friend.system.manger.cn.dao.UserDao;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;
import com.friend.system.manger.cn.util.FactoryUtil;

public class TestDao {
	private FriendDao friendDao = (FriendDao)FactoryUtil.getInstance("friendDao");
	private UserDao userDao = (UserDao)FactoryUtil.getInstance("userDao");
	
	public void testSave(){
		for (int i = 0; i < 100; i++) {
			Friend friend = new Friend();
			User user = new User();
			friend.setName("鲁金成"+i);
			friend.setInfo("好人");
			friend.setSex(0);
			friend.setPhone("18301446614");
			friend.setAddress("北京市 昌平区");
			try {
				long id = friendDao.save(friend);
				user.setId(id);
				user.setUserName(friend.getName());
				user.setPassword("123"+i);
				userDao.save(user);
			} catch (NotFindDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ;
			}
		}
	}
	
	public void testFindFriends(){
		try {
			List<Friend> friends = friendDao.findFriends(10, 0);
			for (Friend friend : friends) {
				System.out.println(friend.getName());
			}
		} catch (NotFindDataException e) {

			e.printStackTrace();
		}
 	}
	@Test
	public void test(){
		System.out.println((int)'a');
	}
}
