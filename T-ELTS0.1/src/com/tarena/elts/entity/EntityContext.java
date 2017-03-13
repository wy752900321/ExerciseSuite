package com.tarena.elts.entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/** 实体数据管理，用来读取数据文件放到内存集合中 */
public class EntityContext {
	/**key是用户的ID，value：用户实例*/
	private HashMap<Integer, User> users = new HashMap<Integer, User>();

	public User findUserById(int id) {
		return users.get(id);
	}
	private void loadUsers(String filename) throws Exception {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(filename),"GBK"));//打开文件
			String line;//一行数据，一行一行读取
			while((line=in.readLine())!=null){
				line = line.trim();
				if(line.startsWith("#")||line.equals("")){
					continue;//忽略空行和注释(#)
				}
				User one = parseUser(line);
				users.put(one.getId(), one);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//1002:张三:1234:13810381038:zhangsan@tarena.com.cn
	//0		1    2   3            4                 
	private User parseUser(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]	));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}
	/**测试方法*/
	public static void main(String[] args) throws Exception {
		EntityContext context =new EntityContext();//因为变量是私有 的
		context.loadUsers("user.txt");
		System.out.println(context.users);
	}
}
