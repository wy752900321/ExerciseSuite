package com.tarena.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Option;
import com.tarena.entity.Project;

public class PersonAction {
	private int id;
	private String name;
	private String password;
	private int age;
	private String description;
	private boolean marry;//与单个checkbox对应
	private String[]  course;//与多个checkbox对应
	private String cradio;//与一组radio对应
	private String cselect;//与select对应
	private String sex;

	public String execute(){
		id = 100;
		name = "张三";
		age = 20;
		password = "123456";
		description = "我是一个好人";
		marry = true;//控制是否已婚单选框选中
		ProjectDAO proDao = new ProjectDAOImpl();
		try {
			//将课程集合写入session,
			//用于radio,select,checkboxlist动态显示
			List<Project> projects = proDao.findAll();
			Map<String,Object> session = 
					ActionContext.getContext().getSession();
			session.put("pros", projects);
			//将性别选项写入session
			List<Option> opts = new ArrayList<Option>();
			opts.add(new Option("M","男"));
			opts.add(new Option("F","女"));
			session.put("opts", opts);
			sex = "F";//控制性别女选中
			//控制哪几个checkbox选中
			course = new String[]{"jd10004","jd10008","jd10009"};
			//控制哪个radio选中
			cradio = "jd10004";
			//控制哪个option选中
			cselect = "jd10009";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCselect() {
		return cselect;
	}

	public void setCselect(String cselect) {
		this.cselect = cselect;
	}

	public String getCradio() {
		return cradio;
	}

	public void setCradio(String cradio) {
		this.cradio = cradio;
	}

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}
	public boolean isMarry() {
		return marry;
	}


	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
