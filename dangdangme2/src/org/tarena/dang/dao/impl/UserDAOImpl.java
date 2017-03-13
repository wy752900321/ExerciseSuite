package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.entity.User;
import org.tarena.dang.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	private static final String SAVE = "insert into d_user(email,nickname,"
			+ "password,user_integral,is_email_verify,"
			+ "email_verify_code,last_login_time,last_login_ip) values(?,?,?,?,?,?,?,?)";
	private static final String FIND_BY_EMAIL = "select * from d_user where email=?";
	private static final String FIND_BY_NICKNAME = "select * from d_user where nickname=?";
	private static final String UPDATE_TIME_OR_IP=
		"update d_user set last_login_time=?,last_login_ip=? where id=?";
	private static final String FIND_USER_BY_ID = 
		"select *from d_user where id=?";
	private static final String UPDATE_EMAIL_VERIFY=
		"update d_user set is_email_verify=? where id=?";
	@Override
	public void save(User user) throws Exception {
		// return_generated_keys 该常量指示生成的键应该可用于获取。
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(SAVE,
				Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getNickname());
		pst.setString(3, user.getPassword());
		pst.setInt(4, user.getUserIntegral());
		String emailVerify = user.isEmailVerify() ? "Y" : "N";
		pst.setString(5, emailVerify);
		pst.setString(6, user.getEmailVerifyCode());
		pst.setLong(7, user.getLastLoginTime());
		pst.setString(8, user.getLastLoginIp());
		pst.executeUpdate();
		// ResultSet getGeneratedKeys()
		// 获取由于执行此 Statement 对象而创建的所有自动生成的键。
		ResultSet rs = pst.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		user.setId(id);
	}

	@Override
	public User findByEmail(String email) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(
				FIND_BY_EMAIL);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		User user = null;
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

	@Override
	public User findByNickName(String nickname) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(
				FIND_BY_NICKNAME);
		pst.setString(1, nickname);
		ResultSet rs = pst.executeQuery();
		User user = null;
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

	@Override
	public User fingUserById(int id) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(
				FIND_USER_BY_ID);
		User user=null;
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(id);
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setEmailVerify(rs.getString("is_email_verify").equals("Y")?true:false);
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
		}
		return user;
	}

	@Override
	public void updateTimeOrIp(User user) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(
				UPDATE_TIME_OR_IP);
		pst.setLong(1, user.getLastLoginTime());
		pst.setString(2, user.getLastLoginIp());
		pst.setInt(3, user.getId());
		pst.executeUpdate();
	}

	@Override
	public void updateEmailVerify(User user) throws Exception {
		//修改邮箱验证：
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(
				UPDATE_EMAIL_VERIFY);
		pst.setString(1, "Y");
		pst.setInt(2, user.getId());
		pst.executeUpdate();
	}

}
