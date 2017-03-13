package com.tarena.entity;

public class Emp implements java.io.Serializable{
	//联合主键属性
	private EmpKey key;
	
	private String sex;

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public EmpKey getKey() {
		return key;
	}
	public void setKey(EmpKey key) {
		this.key = key;
	}
	
}
