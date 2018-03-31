package com.friend.system.manger.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.friend.system.manger.cn.bean.Photo;
import com.friend.system.manger.cn.bean.User;
import com.friend.system.manger.cn.dao.PhotoDao;
import com.friend.system.manger.cn.util.JDBCUtils;

public class PhotoDaoImpl implements PhotoDao {
	private static final String save = "insert into photo(name,info,img,user) values(?,?,?,?)";
	private static final String findPhotosByUserId = "select * from photo where user = ? limit ?,?";
	private static final String deletePhoto = "delete from photo where id = ?";
	private static final String findPhotoById = "select * from photo where id = ?";
	private static final String photoCount = "select count(*) from photo where user = ?";
	@Override
	public void save(Photo photo) {
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(save);
			parseData(statement,photo);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
	}
	private void parseData(PreparedStatement statement, Photo photo) throws SQLException {
		statement.setString(1, photo.getName());
		statement.setString(2, photo.getInfo());
		statement.setString(3, photo.getImg());
		statement.setLong(4, photo.getUser().getId());
	}
	@Override
	public Photo deletePhoto(long id) {
		Photo photo = findPhotoById(id);
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(deletePhoto);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return photo;
	}
	private Photo findPhotoById(long id) {
		Photo photo = null;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findPhotoById);
			statement.setLong(1, id);
			resultSet =statement.executeQuery();
			if(resultSet.next()){
				String name = resultSet.getString("name");
				String img = resultSet.getString("img");
				long user = resultSet.getLong("user");
				String info = resultSet.getString("info");
				photo = parsePhoto(id,name,img,user,info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return photo;
	}
	@Override
	public List<Photo> findPhotosByUserId(long friendId,int count,int start) {
		List<Photo> photos = new ArrayList<Photo>();
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(findPhotosByUserId);
			statement.setLong(1, friendId);
			statement.setInt(2, start);
			statement.setInt(3, count);
			resultSet =statement.executeQuery();
			while(resultSet.next()){
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String img = resultSet.getString("img");
				String info = resultSet.getString("info");
				long user = resultSet.getLong("user");
				photos.add(parsePhoto(id,name,img,user,info));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtils.close(resultSet);
			JDBCUtils.close(statement);
			JDBCUtils.close(connection);
		}
		return photos;
	}
	private Photo parsePhoto(long id, String name, String img, long user, String info) {
		Photo photo = new Photo();
		photo.setId(id);
		photo.setImg(img);
		photo.setName(name);
		User u = new User();
		u.setId(user);
		photo.setInfo(info);
		photo.setUser(u);
		return photo;
	}
	@Override
	public int photoCount(long friendId) {
		int count =0 ;
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(photoCount);
			statement.setLong(1, friendId);
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
}
