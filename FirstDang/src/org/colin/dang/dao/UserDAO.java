package org.colin.dang.dao;

import org.colin.dang.pojo.User;

public interface UserDAO {
	//将用户信息写入d_user
	
  public void save(User user)throws Exception;
  public void updateUser(User user)throws Exception;
  public User findByEmail(String email)throws Exception;
  public User findByPassWord(String email)throws Exception;
  public User findByEmailVerify(String verify)throws Exception;
  
}
