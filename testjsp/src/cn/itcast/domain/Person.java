package cn.itcast.domain;

public class Person {
	private String name;
	private Address address;
	
	

	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
