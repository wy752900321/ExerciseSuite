package com.tarena.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {
	// Properties Map有关系吗
	private String username;
	private String password;
	private int size;
	private List<String> citys;
	private Set<String> friends;
	private Map<Integer, String> books;
	private Properties props;

	public void show() {
		System.out.println("用户名:" + username);
		System.out.println("密码：" + password);
		System.out.println("允许连接数:" + size);
		System.out.println("-----城市列表----");
		for (String str : citys) {
			System.out.println(str);
		}
		System.out.println("----朋友列表----");
		for (String str : friends) {
			System.out.println(str);
		}
		System.out.println("----图书列表---");
		Set<Integer> keys = books.keySet();
		for (Integer key : keys) {
			System.out.println(key + "  " + books.get(key));
		}
		System.out.println("----系统参数信息----");
		Set params = props.keySet();
		for(Object obj:params){
			System.out.println(obj+" : "+props.getProperty(obj.toString()));
		}
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setBooks(Map<Integer, String> books) {
		this.books = books;
	}

	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}

	public void setCitys(List<String> citys) {
		this.citys = citys;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
