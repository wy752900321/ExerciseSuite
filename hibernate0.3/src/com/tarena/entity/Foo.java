package com.tarena.entity;

import java.sql.Date;

public class Foo implements java.io.Serializable{
	private int id;
	private String name;
	private Date birth;
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
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
}
