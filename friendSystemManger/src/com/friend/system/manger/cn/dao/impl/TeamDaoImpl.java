package com.friend.system.manger.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.dao.TeamDao;
import com.friend.system.manger.cn.util.JDBCUtils;

public class TeamDaoImpl implements TeamDao {
	private static final String save = "insert into team(name,info,user) values(?,?,?)";
	private static final String findTeamsByUserId = "select * from team where user = ? ";
	private static final String findTeamsByTeamId = "select * from team where id = ? ";

	@Override
	public void save(Team team) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(save);
			parseData(statement, team);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}

	private void parseData(PreparedStatement statement, Team team)
			throws SQLException {
		statement.setString(1, team.getName());
		statement.setString(2, team.getInfo());
		statement.setLong(3, team.getUser().getId());
	}

	@Override
	public List<Team> findTeamsByUserId(long userId) {
		List<Team> teams = new ArrayList<Team>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findTeamsByUserId);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String info = resultSet.getString("info");
				teams.add(parseTeam(id, name, info));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return teams;
	}

	private Team parseTeam(long id, String name, String info) {
		Team team = new Team(name, info);
		team.setId(id);
		return team;
	}

	@Override
	public Team findTeamsByTeamId(long teamId) {
		Team team = null;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findTeamsByTeamId);
			statement.setLong(1, teamId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String info = resultSet.getString("info");
				team= parseTeam(teamId, name, info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return team;
	}
}
