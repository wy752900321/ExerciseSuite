package test.tarena.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.ext.User;

public class UserTest {
	public static String HIBERNATE_COINFIG_FILE = "/hibernate.cfg.xml";

	UserDaoImpl userDaoImpl = null;

	@Before
	public void setUp() throws Exception {
		userDaoImpl = new UserDaoImpl();
	}

	@Test
	@Ignore
	public void saveUserTest() {
		User user = new User();
		int userId = userDaoImpl.saveUser(user);
		assertEquals(7, userId);
	}

	@Test
	@Ignore
	public void saveFindUserByIdTest() {
		User u = new User();
		u.setUserId(7);
		User user = userDaoImpl.findUserById(u);
		assertEquals("小A", user.getUsername());
	}

	@Test
	@Ignore
	public void saveFindAllUserTest() {
		List<User> users = userDaoImpl.findAllUser();
		assertEquals(6, users.size());
	}

	@Test
    @Ignore
	public void saveUpdateUserByIdTest() {
		User user = new User();
		user.setUserId(7);
		user.setUsername("小b");
		user.setPassword("258");
		userDaoImpl.updateUserById(user);
	}
	@Test
    @Ignore
	public void updateOrSaveUserByIdTest() {
		User user = new User();
		//user.setUserId(7);
		user.setUsername("大S");
		user.setPassword("258");
		userDaoImpl.updateOrSaveUserById(user);
	}
	@Test
   // @Ignore
	public void deleteUserByIdTest() {
		User user = new User();
		user.setUserId(1);
		//不为空的数据必须有值
		user.setUsername("1223");
		userDaoImpl.deleteUserById(user);
	}
	

}
