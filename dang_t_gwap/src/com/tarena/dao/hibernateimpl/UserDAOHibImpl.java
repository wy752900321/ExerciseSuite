package com.tarena.dao.hibernateimpl;

import java.io.Serializable;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class UserDAOHibImpl implements UserDAO, Serializable {
	private static final long serialVersionUID = 4646285273276949792L;

	public User findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByNickName(String nickName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	public void updateById(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	public String updateVerify(int id, boolean verify) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
