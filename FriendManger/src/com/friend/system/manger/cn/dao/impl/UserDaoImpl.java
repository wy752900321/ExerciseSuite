package com.friend.system.manger.cn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.bean.Message;
import com.friend.system.manger.cn.bean.Team;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.UserDao;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;
import com.friend.system.manger.cn.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
	private static final String save = "insert into user (id,userName,password) values (?,?,?)";
	private static final String findUserByUserName = "select * from user where userName = ? ";
	private static final String saveConcern = "insert into concern(team,friend) values(?,?)";
	private static final String findFriendIdByTeamId = "select * from friend where id in ("
			+ "select friend from concern where team = ?)limit ?,?";
	private static final String teamFriendCount = "select count(*) from friend where id in ("
			+ "select friend from concern where team = ?)";
	private static final String deleteFriendById = "delete from concern where team in("
			+ "select id from team where user = ?) and friend = ?";
	private static final String findTeamByuserIdFriendId = "select * from team where id =("
			+ "select team from concern where team in(select id from team where user = ?) and friend = ?)";
	private static final String saveMessage = "insert into message (message,user,messageUser) values(?,?,?)";
	private static final String findMessages ="select * from message where user =? order by id desc limit ?,?";
	private static final String messageCount = "select count(*) from message where user =?";
	private static final String findUserById = "select * from user where id = ?";
	private static final String deleteMessageById ="delete from message where id=?";
	@Override
	public long save(User user) throws NotFindDataException {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(save);
			parseData(user, statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return user.getId();
	}

	private void parseData(User user, PreparedStatement statement)
			throws SQLException {
		statement.setLong(1, user.getId());
		statement.setString(2, user.getUserName());
		statement.setString(3, user.getPassword());
	}

	@Override
	public User findUserByUserName(String userName) throws NotFindDataException {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			statement = connection.prepareStatement(findUserByUserName);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				long id = resultSet.getLong("id");
				String password = resultSet.getString("password");
				user = new User(userName, password);
				user.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return user;
	}

	@Override
	public void save(long teamId, long friendId) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(saveConcern);
			statement.setLong(1, teamId);
			statement.setLong(2, friendId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}

	@Override
	public List<Friend> findFriendsIdByTeamId(long teamId, int count, int start) {
		List<Friend> friends = new ArrayList<Friend>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findFriendIdByTeamId);
			statement.setLong(1, teamId);
			statement.setInt(2, start);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getString("qq");
				String address = resultSet.getString("address");
				String info = resultSet.getString("info");
				int sex = resultSet.getInt("sex");
				Date brithday = resultSet.getDate("brithday");
				friends.add(parseFriend(id, name, phone, qq, address, info,
						brithday, sex));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return friends;
	}

	private Friend parseFriend(long id, String name, String phone, String qq,
			String address, String info, Date brithday, int sex) {
		Friend friend = new Friend(name, qq, phone, address, info);
		friend.setId(id);
		friend.setBrithday(brithday);
		friend.setSex(sex);
		return friend;
	}

	@Override
	public void deleteFriendById(long userId, long friendId) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(deleteFriendById);
			statement.setLong(1, userId);
			statement.setLong(2, friendId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}

	@Override
	public int teamFriendCount(long teamId) {
		int count = 0;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(teamFriendCount);
			statement.setLong(1, teamId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}

		return count;
	}

	@Override
	public Team findTeamIdByuserIdFriendId(long userId, long friendId) {
		Team team = null;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findTeamByuserIdFriendId);
			statement.setLong(1, userId);
			statement.setLong(2, friendId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				long teamId = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String info = resultSet.getString("info");
				team = parseTeam(teamId, name, info);
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

	private Team parseTeam(long id, String name, String info) {
		Team team = new Team(name, info);
		team.setId(id);
		return team;
	}

	@Override
	public void saveMessage(Message me) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(saveMessage);
			statement.setString(1, me.getMessage());
			statement.setLong(2, me.getUser().getId());
			statement.setLong(3, me.getMessageUser().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}

	@Override
	public List<Message> findMessages(long userId, int count, int start) {
		List<Message> messages = new ArrayList<Message>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findMessages);
			statement.setLong(1, userId);
			statement.setInt(2, start);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				long id = resultSet.getLong("id");
				String message = resultSet.getString("message");
				long user = resultSet.getLong("user");
				long messageUser = resultSet.getLong("messageUser");
				messages.add(parseMessage(id,message,messageUser,user));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return messages;
	}

	private Message parseMessage(long id, String message, long messageUser,
			long user) {
		Message me = new Message();
		me.setId(id);
		me.setMessage(message);
		me.setMessageUser(findUserByid(messageUser));
		me.setUser(findUserByid(user));
		return me;
	}
	private User findUserByid(long id){
		User user = null;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findUserById);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				String name = resultSet.getString("userName");
				user = new User();
				user.setId(id);
				user.setUserName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return user;
	}
	@Override
	public int messageCount(long userId) {
		int count = 0;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(messageCount);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}

		return count;
	}
	@Override
	public void deleteMessageById(long id) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(deleteMessageById);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}
}
