package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Statement;
import com.tarena.dao.IUserDao;
import com.tarena.entity.exet.User;
import com.tarena.util.datasource.DBConnection;

public class UserDaoImpl implements IUserDao {
	private Log log = LogFactory.getLog(UserDaoImpl.class);

	// 注册用户
	@Override
	public int saveUser(User user) {
		int userId = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into d_user(email,nick_name,password,user_integral,is_email_verify,email_verify_code,last_login_time,last_login_ip) values(?,?,?,?,?,?,?,?);";
			log.info(sql);
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			// 邮箱
			ps.setString(1, user.getEmail());
			// 昵称
			ps.setString(2, user.getNickName());
			// 密码
			ps.setString(3, user.getPassword());
			// 用户级别
			ps.setInt(4, user.getUserIntegral());
			// 邮箱是否验证
			ps.setString(5, user.getIsEmailVerify().equals("Y") ? "Y" : "N");
			// 邮箱验证码
			ps.setString(6, user.getEmailVerifyCode());
			// 最后一次登录时间
			ps.setLong(7, user.getLastLoginTime());
			// 登录IP
			ps.setString(8, user.getLastLoginIp());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next()){
				userId=rs.getInt(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnection.close(rs,ps, conn);
		}
		return userId;
	}

	@Override
	public User findUserById(User user) {
		User u = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			rs = ps.executeQuery();
			while (rs.next()) {
				// 邮箱
				u.setEmail(rs.getString("email"));
				// 昵称
				u.setNickName(rs.getString("nick_name"));
				// 密码
				u.setPassword(rs.getString("password"));
				// 用户级别
				u.setUserIntegral(rs.getInt("user_integral"));
				// 邮箱是否验证
				u.setIsEmailVerify(rs.getString("is_email_verify"));
				// 邮箱验证码
				u.setEmailVerifyCode(rs.getString("email_verify_code"));
				// 最后一次登录时间
				u.setLastLoginTime(rs.getLong("last_login_time"));
				// 登录IP
				u.setLastLoginIp(rs.getString("last_login_ip"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return u;
	}

	@Override
	public User findUserByEmail(User user) {
		User u = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_user where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			rs = ps.executeQuery();
			while (rs.next()) {
				//id
				u.setUserId(rs.getInt("id"));
				// 邮箱
				u.setEmail(rs.getString("email"));
				// 昵称
				u.setNickName(rs.getString("nick_name"));
				// 密码
				u.setPassword(rs.getString("password"));
				// 用户级别
				u.setUserIntegral(rs.getInt("user_integral"));
				// 邮箱是否验证
				u.setIsEmailVerify(rs.getString("is_email_verify"));
				// 邮箱验证码
				u.setEmailVerifyCode(rs.getString("email_verify_code"));
				// 最后一次登录时间
				u.setLastLoginTime(rs.getLong("last_login_time"));
				// 登录IP
				u.setLastLoginIp(rs.getString("last_login_ip"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return u;
	}

	@Override
	public boolean updateEmailVerify(User user) {
		boolean bool=false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update d_user set is_email_verify=?";
			log.info(sql);
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getIsEmailVerify());
			int result=ps.executeUpdate();
			if(result>0){
				bool=true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnection.close(ps, conn);
		}
		return bool;
	}

}
