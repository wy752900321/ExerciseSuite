package com.wangxin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.wangxin.dao.UserDao;
import com.wangxin.entity.Dept;
import com.wangxin.entity.DeptMapper;

public class UserDaoImpl implements UserDao{
	private JdbcTemplate template;
	public void setDataSource(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	public void delete(int id) {
		String sql = "delete from zj_dept where id=?";
		template.update(sql,new Object[]{id});
	}

	public List<Dept> findAll() {
		String sql = "select * from zj_dept";
		DeptMapper mapper = new DeptMapper();
		List<Dept> list = template.query(sql, mapper);
		return list;
	}

	public Dept findById(int id) {
		String sql = "select * from zj_dept where id=?";
		DeptMapper mapper = new DeptMapper();
		Object[] params = new Object[]{id};
		Dept dept = (Dept)template.queryForObject(sql, params, mapper);
		return dept;
	}

	public void save(Dept dept) {
		String sql = "insert into zj_dept(name,city) values(?,?)";
		Object[] params = new Object[]{dept.getName(),dept.getCity()};
		template.update(sql, params);
	}

	public void update(Dept dept) {
		String sql = "update zj_dept set name=?,city=? where id=?";
		Object[] params = new Object[]{dept.getName(),dept.getCity(),dept.getId()};
		template.update(sql, params);
	}
	public int count() {
		String sql = "select count(*) from zj_dept";
		int count = template.queryForInt(sql);
		return count;
	}
	public List<Dept> findPage(int page, int size) {
		return null;
	}
	
}
