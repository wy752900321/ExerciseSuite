package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DbPoolUtil;

/**
 * 处理关于用户操作的数据信息
 * 
 * @author soft01
 * 
 */
public class UserDAOJdbcImpl implements UserDAO, Serializable {
	private static final long serialVersionUID = 760277934329265703L;
	// 往user表中插入数据(注册)
	private static final String INSERT = "insert into d_user(email,"
			+ "nickname,password,user_integral,is_email_verify,"
			+ "email_verify_code,last_login_time,last_login_ip)"
			+ "values(?,?,?,?,?,?,?,?)";
	// 通过email找一个User(验证email合法性)
	private static final String FIND_BY_EMAIL = "select * from d_user "
			+ "where email=?";
	// 通过nickname找一个User(验证nickname合法性，中文名字不可以使用此sql语句)
	private static final String FIND_BY_NICKNAME = "select * from "
			+ "d_user where nickname=?";
	// 通过id找一个User(验证邮箱验证码合法性)
	private static final String FIND_BY_ID = "select * from "
			+ "d_user where id=?";
	// 通过id更新某个用户的is_email_verify的状态(如果验证通过,把其值设置成Y)
	private static final String UPDATE_BY_ID = "update "
			+ "d_user set is_email_verify=? where id=?";

	/**
	 * @param user
	 *            用户信息
	 * @exception Exception
	 */
	public void insert(User user) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句，并返回主键值
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				INSERT, Statement.RETURN_GENERATED_KEYS);
		// 4.设置参数
		stat.setString(1, user.getEmail());
		stat.setString(2, user.getNickname());
		stat.setString(3, user.getPassword());
		stat.setInt(4, user.getUserIntegral());
		String verify = user.isEmailVerify() == true ? "Y" : "N";
		stat.setString(5, verify);
		stat.setString(6, user.getEmailVerifyCode());
		stat.setLong(7, user.getLastLoginTime());
		stat.setString(8, user.getLastLoginIp());
		// 5.执行语句对象
		stat.executeUpdate();
		// 6.返回结果集
		ResultSet set = stat.getGeneratedKeys();
		set.next();
		// 7.把结果集的第一个数给id
		int id = set.getInt(1);
		// 8.赋给use对象
		user.setId(id);
	}

	/**
	 * 通过email找一个用户
	 * 
	 * @param email
	 *            传入的email
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findByEmail(String email) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_EMAIL);
		// 4.设置参数
		stat.setString(1, email);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(set.getInt("id"));
			user.setEmail(email);
			user.setNickname(set.getString("nickname"));
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * 通过nickname找一个用户
	 * 
	 * @param nickName
	 *            传入的nickname
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findByNickName(String nickName) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_NICKNAME);
		// 4.设置参数
		stat.setString(1, nickName);
		// 5.执行语句对象并返回结果集
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(set.getInt("id"));
			user.setEmail(set.getString("email"));
			user.setNickname(nickName);
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * 通过id找一个用户
	 * 
	 * @param id
	 *            传入的id
	 * @return 返回一个用户
	 * @throws Exception
	 */
	public User findById(int id) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_ID);
		// 4.设置参数
		stat.setInt(1, id);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(id);
			user.setEmail(set.getString("email"));
			user.setNickname(set.getString("nickname"));
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * 通过id更新用户信息
	 * 
	 * @param id
	 *            用户id
	 * @throws Exception
	 */
	public void updateById(int id) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				UPDATE_BY_ID);
		// 4.通过id找一个用户
		User user = findById(id);
		String verify = user.isEmailVerify() == true ? "Y" : "N";
		// 5.设置参数
		stat.setString(1, verify);
		stat.setInt(2, id);
		// 6.执行语句对象
		stat.executeUpdate();
	}

	/**
	 * 更新用户的验证码状态
	 * 
	 * @param id
	 *            用户id
	 * @param verify
	 *            是否通过验证
	 * @return 返回Y或N
	 * @throws Exception
	 */
	public String updateVerify(int id, boolean verify) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				UPDATE_BY_ID);
		String verifyStr = verify == true ? "Y" : "N";
		// 4.设置参数
		stat.setString(1, verifyStr);
		stat.setInt(2, id);
		// 5.执行语句对象
		stat.executeUpdate();
		return verifyStr;
	}

}
