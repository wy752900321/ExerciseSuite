package com.friend.system.manger.cn.dao;

import java.util.List;

import com.friend.system.manger.cn.bean.Team;

public interface TeamDao {
	/**
	 * 保存分组
	 * @param team
	 */
	void save(Team team);
	/**
	 * 查找指定用户的分组
	 * @param userId
	 * @return
	 */
	List<Team> findTeamsByUserId(long userId);
	Team findTeamsByTeamId(long teamId);
}
