package com.friend.system.manger.cn.service;

import java.util.List;

import com.friend.system.manger.cn.bean.Concern;
import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Message;
import com.friend.system.manger.cn.bean.Photo;
import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.bean.User;

public interface UserService {
	/**
	 * 根据用户名查找用户
	 * 如果找不到 返回 null
	 * @param userName
	 * @return
	 */
	User findUserByUserName(String userName);
	/**
	 * 添加 用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 添加图片
	 * @param photo
	 */
	void addPhoto(Photo photo);
	/**
	 * 增加分组
	 * @param team
	 */
	void addTeam(Team team);
	/**
	 * 根据 userId 找到该用户的 好友分组
	 * @param userId
	 * @return
	 */
	List<Team> findTeamsByFriendId(Long userId);
	/**
	 * 将 联系人和 分组 关联
	 * @param concern
	 */
	void addConcern(Concern concern);
	/**
	 * 
	 * @param teamId
	 * @return
	 */
	List<Friend> findMyFriendByTeamId(long teamId,int now);
	/**
	 * 根据id 删除 一条 对应关系
	 * @param userId
	 * @param friendId
	 */
	void deleteFriendById(long userId,long friendId);
	/**
	 * 得到总页数
	 * @return
	 */
	int getTotalPages();
	/**
	 * 得到 数据的条数
	 * @return
	 */
	int getCount();
	/**
	 * 
	 * @param teamId
	 * @return
	 */
	Team findTeamByteamId(long teamId);
	/**
	 * 
	 * @param userId
	 * @param friendId
	 * @return
	 */
	Team findTeamByteamId(long userId,long friendId);
	/**
	 * 保存留言信息
	 * @param me
	 */
	void saveMessage(Message me);
	/**
	 * 分页查询留言信息
	 * @param userId
	 * @param page
	 * @return
	 */
	List<Message> findMyMessages(long userId,int page);
	/**
	 * 删除 一条 留言 
	 * @param id
	 */
	void deleteMessageById(long id);
	/**
	 * 
	 * @param friendId
	 * @return
	 */
	List<Photo> findPhotosByFriendId(long friendId,int page);
	/**
	 * 
	 * @param id
	 */
	Photo deletePhoto(long id);
}
