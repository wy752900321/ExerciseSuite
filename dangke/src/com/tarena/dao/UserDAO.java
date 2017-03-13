package com.tarena.dao;

import com.tarena.entity.User;

public interface UserDAO {
	public void insert(User user) throws Exception;
	public User findUserByEmail(String email)throws Exception;
	public void updateIsEmailVerify(int id, boolean b) throws Exception;
	public User findUserByIDandUUID(int ID, String UUID) throws Exception;
	public User checkEmailandPassword(String email, String password) throws Exception;
	public void updateLoginTimeAndIp(int id, long currentTimeMillis,
			String remoteAddr) throws Exception;
}
