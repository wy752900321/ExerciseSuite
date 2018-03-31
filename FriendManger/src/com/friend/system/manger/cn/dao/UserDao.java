package com.friend.system.manger.cn.dao;

import java.util.List;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Message;
import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;

public interface UserDao {
	/**
	 * 保存用户  如果连接数据库失败 抛出异常
	 * 返回数据库保存的主键
	 * @param user
	 * @return
	 * @throws NotFindDataException
	 */
	long save(User user) throws NotFindDataException;
	/**
	 * 根据 用户名查找 数据 如果 找不到  返回 null
	 * 连接 数据库 失败 抛出 异常 
	 * @param userName
	 * @return
	 * @throws NotFindDataException
	 */
	User findUserByUserName(String userName) throws NotFindDataException;
	/**
	 * 
	 * @param teamId
	 * @param friendId
	 */
	void save(long teamId, long friendId);
	/**
	 * team id 查找联系人
	 * @param teamId
	 * @param count
	 * @param start
	 * @return
	 */
	List<Friend> findFriendsIdByTeamId(long teamId,int count, int start);
	
	/**
	 * 解除 一条好友的记录关系
	 * @param userId
	 * @param friendId
	 */
	void deleteFriendById(long userId,long friendId);
	/**
	 * 查看联系人 的数目 
	 * @param teamId
	 * @return
	 */
	int teamFriendCount(long teamId);
	/**
	 * 查找指定的分组
	 * @param userId
	 * @param friendId
	 * @return
	 */
	Team findTeamIdByuserIdFriendId(long userId, long friendId);
	/**
	 * 将 一条留言存到 数据库
	 * @param me
	 */
	void saveMessage(Message me);
	/**
	 * 查询 某 用户的留言 信息
	 * @param userId
	 * @param count
	 * @param satrt
	 * @return
	 */
	List<Message> findMessages(long userId,int count,int satrt);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	int messageCount(long userId);
	/**
	 * 删除数据库中的一条记录
	 * @param id
	 */
	void deleteMessageById(long id);
}
