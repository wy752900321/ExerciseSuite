package com.tarena.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.tarena.dao.DeptDAO;
@Repository("deptdao")
@Scope("prototype")
public class DeptDAOImpl implements DeptDAO {

	public void save() {
		System.out.println("部门添加");

	}

	public void update() {
		System.out.println("部门更新");

	}

	public void delete() {
		System.out.println("DeptDAOImpl->delete(): 异常测试");
		String s= null;
		s.length();//异常测试,触发异常通知
	}

}
