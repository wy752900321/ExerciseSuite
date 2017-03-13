package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ProjectDAO;
import com.tarena.entity.Project;
import com.tarena.util.DBUtil;

public class ProjectDAOImpl implements ProjectDAO {
	private static final String findAll = "select * from t_project";
	private static final String findPage = "select * from t_project limit ?,?";
	private static final String countTotalPage = "select count(*) from t_project";
	private static final String save = "insert into t_project "
			+ "(no,name,startDate,endDate) " + "values (?,?,?,?)";
	private static final String deleteById = "delete from t_project where id=?";
	private static final String findById = "select * from t_project where id=?";
	private static final String update = "update t_project set no=?,name=?,"
			+ "startDate=?,endDate=? " + "where id=?";

	public List<Project> findAll() throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(findAll);
		ResultSet rs = pst.executeQuery();
		List<Project> list = new ArrayList<Project>();
		while (rs.next()) {
			Project pro = new Project();
			pro.setId(rs.getInt("id"));
			pro.setNo(rs.getString("no"));
			pro.setName(rs.getString("name"));
			pro.setStartDate(rs.getDate("startDate"));
			pro.setEndDate(rs.getDate("endDate"));
			list.add(pro);
		}
		DBUtil.close(conn);
		return list;
	}

	public static void main(String[] args) {
		ProjectDAO proDao = new ProjectDAOImpl();
		try {
			List<Project> list = proDao.findPage(2, 5);
			for (Project pro : list) {
				System.out.println(pro.getNo() + " " + pro.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Project> findPage(int page, int size) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(findPage);
		pst.setInt(1, (page - 1) * size);// 设置抓取记录的开始索引
		pst.setInt(2, size);// 最多抓取多少条记录
		ResultSet rs = pst.executeQuery();
		List<Project> list = new ArrayList<Project>();
		while (rs.next()) {
			Project pro = new Project();
			pro.setId(rs.getInt("id"));
			pro.setNo(rs.getString("no"));
			pro.setName(rs.getString("name"));
			pro.setStartDate(rs.getDate("startDate"));
			pro.setEndDate(rs.getDate("endDate"));
			list.add(pro);
		}
		DBUtil.close(conn);
		return list;
	}

	public int countTotalPage(int size) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(countTotalPage);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int c = rs.getInt(1);
		DBUtil.close(conn);
		// 根据总记录数c,计算总页数
		if (c == 0) {
			return 1;
		} else if (c % size == 0) {
			return c / size;
		} else {
			return c / size + 1;
		}
	}

	public void save(Project pro) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(save);
		pst.setString(1, pro.getNo());
		pst.setString(2, pro.getName());
		pst.setDate(3, pro.getStartDate());
		pst.setDate(4, pro.getEndDate());
		pst.executeUpdate();
		DBUtil.close(conn);
	}

	public void deleteById(int id) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(deleteById);
		pst.setInt(1, id);
		pst.executeUpdate();
		DBUtil.close(conn);
	}

	public Project findById(int id) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(findById);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Project pro = null;
		if (rs.next()) {
			pro = new Project();
			pro.setId(rs.getInt("id"));
			pro.setNo(rs.getString("no"));
			pro.setName(rs.getString("name"));
			pro.setStartDate(rs.getDate("startDate"));
			pro.setEndDate(rs.getDate("endDate"));
		}
		DBUtil.close(conn);
		return pro;
	}

	public void update(Project pro) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(update);
		pst.setString(1, pro.getNo());
		pst.setString(2, pro.getName());
		pst.setDate(3, pro.getStartDate());
		pst.setDate(4, pro.getEndDate());
		pst.setInt(5, pro.getId());
		pst.executeUpdate();
		DBUtil.close(conn);
	}

}
