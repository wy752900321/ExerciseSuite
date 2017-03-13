package com.wangxin.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptMapper implements RowMapper {
	//一行记录调用一次，将记录映射成entity对象
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Dept dept = new Dept();
		dept.setId(rs.getInt("id"));
		dept.setName(rs.getString("name"));
		dept.setCity(rs.getString("city"));
		return dept;
	}

}
