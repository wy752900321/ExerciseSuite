package com.tarena.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.tarena.dao.UserDAO;
@Repository("userdao")
@Scope("prototype")
public class UserDAOImpl implements UserDAO {

	public void delete() {
		System.out.println("用户删除");

	}

	public void findById() {
		System.out.println("用户查询");

	}

	public void save() {
		System.out.println("用户保存");

	}

	public void update() {
		System.out.println("用户更新");

	}

}
