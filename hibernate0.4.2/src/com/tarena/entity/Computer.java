package com.tarena.entity;

public class Computer extends Product implements java.io.Serializable{
	private String cpu;
	private String memory;
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
}
