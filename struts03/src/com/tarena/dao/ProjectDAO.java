package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Project;

public interface ProjectDAO {
	public List<Project> findAll() throws Exception;
	public List<Project> findPage(int page,int size)
													throws Exception;
	public int countTotalPage(int size) throws Exception;
	public void save(Project pro) throws Exception;
	public void deleteById(int id) throws Exception;
	public Project findById(int id) throws Exception;
	public void update(Project pro) throws Exception;
}
