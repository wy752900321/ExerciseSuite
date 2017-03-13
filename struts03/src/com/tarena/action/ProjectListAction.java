package com.tarena.action;

import java.util.List;

import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Project;

public class ProjectListAction {
	//接收属性
	private int page = 1;//当前要显示第几页
	//传出属性
	private List<Project> projects;
	private int totalPage = 1;//总页数
	//
	private static final int SIZE = 5;//一页显示多少条
	
	public String execute(){
		ProjectDAO proDao = new ProjectDAOImpl();
		try {//获取第几页的记录
			projects = proDao.findPage(page, SIZE);
			//获取总页数
			totalPage = proDao.countTotalPage(SIZE);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
