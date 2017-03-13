package com.tarena.action;

import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Project;

public class ProjectAction {
	private Project pro;
	ProjectDAO proDao = new ProjectDAOImpl();
	
	//更新到数据库
	public String update(){
		try {
			proDao.update(pro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//更新初始显示
	public String init(){
		try {
			pro = proDao.findById(pro.getId());
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//查看
	public String view(){
		try {
			pro = proDao.findById(pro.getId());
			return "view";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	//删除
	public String delete(){
		try {
			proDao.deleteById(pro.getId());
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//添加
	public String add(){
		try {
			proDao.save(pro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	public Project getPro() {
		return pro;
	}

	public void setPro(Project pro) {
		this.pro = pro;
	}


}
