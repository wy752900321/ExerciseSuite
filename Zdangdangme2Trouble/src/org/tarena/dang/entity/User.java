package org.tarena.dang.entity;
/**
	DROP TABLE IF EXISTS d_user;
	CREATE TABLE d_user (
	  id int(12) NOT NULL auto_increment,
	  email varchar(50) NOT NULL,
	  nickname varchar(50) default NULL,
	  password varchar(50) NOT NULL,
	  user_integral int(12) NOT NULL default '0',
	  is_email_verify char(3),
	  email_verify_code varchar(50) default NULL,
	  last_login_time bigint default NULL,
	  last_login_ip varchar(15) default NULL,
	  PRIMARY KEY  (id),
	  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
@SuppressWarnings("serial")
public class User implements java.io.Serializable {
	private int id;
	private String email;
	private String nickname;// [nikneim]绰号,昵称
	private String password;
	// 用户等级
	private int userIntegral;
	// Email是否验证
	private boolean emailVerify;
	// Email验证码
	private String emailVerifyCode;
	private long lastLoginTime;
	private String lastLoginIp;

	public int getId() {
		return id;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

}
