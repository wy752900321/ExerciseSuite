package com.friend.system.manger.cn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.friend.system.manger.cn.bean.Friend;
import com.friend.system.manger.cn.dao.FriendDao;
import com.friend.system.manger.cn.dao.exception.NotFindDataException;
import com.friend.system.manger.cn.util.JDBCUtils;

public class FriendDaoImpl implements FriendDao {
	private static final String findFriends = "select * from friend limit ?,?";
	private static final String save="insert into friend(id,name,phone,qq,address,info,sex,brithday) values(?,?,?,?,?,?,?,?)";
	private static final String count = "select count(*) from friend";
	private static final String findFriendById = "select * from friend where id = ?";
	private static final String findFriendByUserId = "select * from friend where id in (" +
					"select friend from concern c join team t on c.team=t.id where t.user=?"+
			") limit ?,?";
	private static final String myFrtiendCount = "select count(*) from friend where id in (" +
	"select friend from concern c join team t on c.team=t.id where t.user=?"+
	")";
	@Override
	public List<Friend> findFriends(int count, int start)
			throws NotFindDataException {
		List<Friend> friends = new ArrayList<Friend>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findFriends);
			statement.setInt(1, start);
			statement.setInt(2, count);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getString("qq");
				String address = resultSet.getString("address");
				String info = resultSet.getString("info");
				int sex = resultSet.getInt("sex");
				Date brithday = resultSet.getDate("brithday");
				friends.add(parseFriend(id,name,phone,qq,address,info,brithday,sex));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFindDataException("数据库连接失败");
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		if(friends.size()==0){
			throw new NotFindDataException("没有找到数据");
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
	public long save(Friend friend) throws NotFindDataException {
		long id = -1;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(save,Statement.RETURN_GENERATED_KEYS);
			parseData(friend,statement);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()){
				id = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		if(id ==-1){
			throw new NotFindDataException("数据库连接失败");
		}
		return id;
	}

	private void parseData(Friend friend, PreparedStatement statement) throws SQLException {
		statement.setLong(1, friend.getId());
		statement.setString(2, friend.getName());
		statement.setString(3, friend.getPhone());
		statement.setString(4, friend.getQq());
		statement.setString(5, friend.getAddress());
		statement.setString(6, friend.getInfo());
		statement.setInt(7, friend.getSex());
		statement.setDate(8, friend.getBrithday());
	}
	@Override
	public int count() {
		int count =0 ;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(FriendDaoImpl.count);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return count;
	}
	@Override
	public int myFriendCount(long id) {
		int count =0 ;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(myFrtiendCount);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return count;
	}

	@Override
	public Friend findFriendByid(long id) throws NotFindDataException {
		Friend friend = null;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findFriendById);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getNString("qq");
				String address = resultSet.getString("address");
				String info = resultSet.getString("info");
				int sex = resultSet.getInt("sex");
				Date brithday = resultSet.getDate("brithday");
				friend = parseFriend(id, name, phone, qq, address, info,brithday,sex);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		if(friend==null){
			throw new NotFindDataException("没有找到数据");
		}
		return friend;
	}

	@Override
	public List<Friend> findMyFriends(long userId, int count, int start) {
		List<Friend> friends = new ArrayList<Friend>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findFriendByUserId);
			statement.setLong(1, userId);
			statement.setInt(2, start);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String qq = resultSet.getString("qq");
				String address = resultSet.getString("address");
				String info = resultSet.getString("info");
				int sex = resultSet.getInt("sex");
				Date brithday = resultSet.getDate("brithday");
				friends.add(parseFriend(id,name,phone,qq,address,info,brithday,sex));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return friends;
	}
}
