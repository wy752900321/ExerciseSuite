package dao;

import java.util.List;

import pojo.User;

public interface UserDAO {
	public List<User> list();
	public void save(User user);
	public User findByUsername(String username);
	public User findById(Long id);
	
}
