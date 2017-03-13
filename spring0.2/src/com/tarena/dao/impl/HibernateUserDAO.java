package com.tarena.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.tarena.dao.UserDAO;
@Repository
public class HibernateUserDAO implements UserDAO {

	public void delete() {
		System.out.println("hibernate delete");
	}

	public void save() {
		System.out.println("hibernate save");
	}

}
