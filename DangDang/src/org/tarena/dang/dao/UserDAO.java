package org.tarena.dang.dao;

import org.tarena.dang.entity.User;

public interface UserDAO {
	public void save(User user) throws Exception;

	public User findByEmail(String email) throws Exception;

	public User findByNickName(String nickname) throws Exception;
	
	public void updateTimeOrIp(User user)throws Exception;
	
	public User fingUserById(int id) throws Exception;
	
	public void updateEmailVerify(User user) throws Exception;
	
}
