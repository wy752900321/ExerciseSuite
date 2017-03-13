package com.tarena.dao.impl;

import java.sql.*;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.MD5Util;

public class UserDAOImpl extends GetConnection implements UserDAO {
	private static final String INSERT = "insert into d_user (email , nickname , password ,"
			+ " user_integral , is_email_verify , email_verify_code ,"
			+ " last_login_time , last_login_ip ) values (?  , ?  , ?  , ?  , ?  , ? , ? , ? )";
	private static final String FIND_USER_BY_EMAIL = "select * from d_user where email = ? ";
	private static final String UPDATE_IS_VERIFY_CODE_BY_ID = "update  d_user set is_email_verify = ? where id = ? ";
	private static final String IS_USER_BY_ID_UUID = "select * from d_user where id = ? and email_verify_code = ? ";
	private static final String IS_USER_BY_EMAIL_PASSWORD = "select * from d_user where email = ? and password = ? ";
	private static final String UPDATE_LOGIN_TIME_ID_BY_ID = "update d_user set last_login_ip =?  , last_login_time =?  where id= ? ";

	/**
	 * 注册用户User
	 */
	public void insert(User user) throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(INSERT,
				Statement.RETURN_GENERATED_KEYS);
		prep.setString(1, user.getEmail());
		prep.setString(2, user.getNickname());
		prep.setString(3, user.getPassword());
		prep.setInt(4, user.getUserIntegral());
		String verify = user.isEmailVerify() ? "Y" : "N";
		prep.setString(5, verify);
		prep.setString(6, user.getEmailVerifyCode());
		prep.setLong(7, user.getLastLoginTime());
		prep.setString(8, user.getLastLoginIp());
		prep.executeUpdate();
		ResultSet rs = prep.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		user.setId(id);
	}

	/**
	 * 通过email找到用户，如果存在返回用户对象user 如果不存在返回null;
	 */
	public User findUserByEmail(String email) throws Exception {
		User user = null;
		PreparedStatement prep = getConnection().prepareStatement(FIND_USER_BY_EMAIL);
		prep.setString(1, email);
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmailVerify(rs.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * 更新用户的邮箱出测标识
	 */
	public void updateIsEmailVerify(int id, boolean b) throws Exception {
		PreparedStatement prep =getConnection()
				.prepareStatement(UPDATE_IS_VERIFY_CODE_BY_ID);
		String verify = b ? "Y" : "N";
		prep.setString(1, verify);
		prep.setInt(2, id);
		prep.executeUpdate();
	}
	
	//根据ID和UUID 查找
	//如果用户存在且没有注册过，则返回user对象;
	//其他情况返回null:  ——————情况有两种如下：
	//如果用户不存在返回false
	//如果用户存在且已经注册了，返回false;
	public User findUserByIDandUUID(int ID, String UUID) throws Exception {
		User user = null;
		PreparedStatement prep = getConnection().prepareStatement(IS_USER_BY_ID_UUID);
		prep.setInt(1, ID);
		prep.setString(2, UUID);
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
			if(!rs.getBoolean("is_email_verify")){
				updateIsEmailVerify(ID,true);		
				user.setEmailVerify(true);
				return user;
			}
		}
		return null;
	}


	/**
	 * 根于登录输入的email 和 password 判断用户是否存在
	 * 如果存在返回user对象
	 * 如果不存在返回空对象user；
	 */
	public User checkEmailandPassword(String email, String password)
			throws Exception {
		User user = null;
		String pwd = MD5Util.encode(password);
		PreparedStatement prep =getConnection().prepareStatement(IS_USER_BY_EMAIL_PASSWORD);
		prep.setString(1, email);
		prep.setString(2, pwd);
		ResultSet rs = prep.executeQuery();
		System.out.println("pwd加密后－－－－－－－－－"+pwd);
		//System.out.println(rs.next());
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmailVerify(rs.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
		}
		return user;
	}
	/**
	 * 根据用户的id 更新用户的登录时间，和登录地址；
	 */
	public void updateLoginTimeAndIp(int id, long currentTimeMillis,
			String remoteAddr) throws Exception {
		PreparedStatement prep = getConnection()
				.prepareStatement(UPDATE_LOGIN_TIME_ID_BY_ID);
		prep.setString(1, remoteAddr);
		prep.setLong(2, currentTimeMillis);
		prep.setInt(3, id);
		prep.executeUpdate();
	}
	
	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		try {
			System.out.println(dao.checkEmailandPassword("9493413751@qq.com", "123456").getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
