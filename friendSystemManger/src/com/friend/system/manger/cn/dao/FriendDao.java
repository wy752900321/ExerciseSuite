package com.friend.system.manger.cn.dao;

import java.util.List;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;

public interface FriendDao {
	/**
	 * 分页查找数据库中的数据 
	 * 从 第 start 条 数据开始  第一条 的下标 为 0
	 * 查询出 count 条数据
	 * 未找到数据 或者数据库连接失败 会抛出 异常
	 * @param start
	 * @param end
	 * @return
	 * @throws NotFindDataException
	 */
	List<Friend> findFriends(int count,int start) throws NotFindDataException;
	/**
	 * 保存 friend 返回生成的主键
	 * 连接数据库失败 会 抛出异常
	 * @param friend
	 * @return
	 * @throws NotFindDataException
	 */
	long save(Friend friend) throws NotFindDataException;
	/**
	 * 返回表中的记录数
	 * @return
	 */
	int count();
	/**
	 * 通过 id 查找 朋友  如果 找不到
	 * 抛出异常
	 * @param id
	 * @return
	 * @throws NotFindDataException
	 */
	Friend findFriendByid(long id)throws NotFindDataException;
	/**
	 * 根据用户id 查找 联系人
	 * @param id
	 * @param pageCount
	 * @param start
	 * @return
	 */
	List<Friend> findMyFriends(long id, int pageCount, int start);
	/**
	 * 查找我的联系人的数目
	 * @return
	 */
	int myFriendCount(long id);
}
