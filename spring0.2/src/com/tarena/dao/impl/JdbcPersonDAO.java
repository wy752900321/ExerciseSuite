package com.tarena.dao.impl;

import com.tarena.dao.PersonDAO;

public class JdbcPersonDAO implements PersonDAO {

	public void delete() {
		System.out.println("jdbc用户删除!");

	}

	public void findById() {
		System.out.println("jdbc用户查询!");

	}

	public void save() {
		System.out.println("jdbc用户保存!");

	}

	public void update() {
		System.out.println("jdbc用户更新!");

	}

}
