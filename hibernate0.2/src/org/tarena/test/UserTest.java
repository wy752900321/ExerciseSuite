package org.tarena.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.tarena.dao.impl.UserDaoImpl;
import org.tarena.entity.ext.User;

public class UserTest {
	public static String HIBERNATE_COINFIG_FILE = "/hibernate.cfg.xml";
	UserDaoImpl userDaoImpl = null;
	
	public void setUp() throws Exception{
		userDaoImpl = new UserDaoImpl();
	}
	@Test
	@Ignore
	public void saveUserTest(){
		User user = new User();
		int userId = userDaoImpl.saveUser(user);
		assertEquals(7, userId);
	}
	
	@Test
	@Ignore
	public void saveFindUserByIdTest(){
		User u = new User();
		u.setId(2);
		User user = userDaoImpl.findUserById(u);
		assertEquals("小A",user.getName());
	}
	
	@Test
	@Ignore
	public void saveFindAllUserTest(){
		List<User> users = userDaoImpl.findAllUser();
		assertEquals(6,users.size());
	}
	
	@Test
	@Ignore
	public void saveUpdateUserByIdTest(){
		User user = new User();
		user.setId(8);
		user.setName("小b");
		user.setPassword("238");
		userDaoImpl.updateUserById(user);
	}
	
	@Test
	@Ignore
	public void updateOrSaveUserByIdTest(){
		User user = new User();
		user.setId(3);
		user.setName("大S");
		user.setPassword("345");
		userDaoImpl.updateOrSaveUserById(user);
	}
	
	@Test
	@Ignore
	public void deleteUserByIdTest(){
		User user = new User();
		user.setId(1);
		//不为空的数据必须有值
		user.setName("1231");
		userDaoImpl.deleteUserById(user);
	}
}
