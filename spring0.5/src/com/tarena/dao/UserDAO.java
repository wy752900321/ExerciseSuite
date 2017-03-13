package com.tarena.dao;

import java.util.List;

import com.tarena.entity.User;


public interface UserDAO {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User findById(int id);
	public List<User> findAll();
	public int count();
	public List<User> findPage(int page,int pageSize);
	
}
