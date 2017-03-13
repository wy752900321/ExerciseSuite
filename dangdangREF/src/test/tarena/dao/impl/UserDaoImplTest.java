package test.tarena.dao.impl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.tarena.dao.IUserDao;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.exet.User;

public class UserDaoImplTest {
	IUserDao iuserDao=null;
	@Before
	public void setUp() throws Exception {
		iuserDao=new UserDaoImpl();
	}

	@Test
	public void testSaveUser() {
		User user=new User();
		user.setEmail("lll@163.com");
		user.setEmailVerifyCode("010101");
		user.setLastLoginIp("127.0.0.1");
		user.setLastLoginTime(System.currentTimeMillis());
		user.setNickName("小明");
		user.setPassword("1234");
		int userId=iuserDao.saveUser(user);
		Assert.assertEquals(10, userId);
	}

}
