package org.tarena.dang.test;

import org.junit.Test;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;

public class TestData {
	@Test
	public void test1() throws Exception {
		UserDAO ud = new UserDAOImpl();
		User user = new User();
		user.setEmail("2955156@qq.com");
		user.setNickname("123");
		user.setPassword("123");
		user.setUserIntegral(1);
		user.setEmailVerify(true);
		user.setEmailVerifyCode("123");
		user.setLastLoginIp("192.168.0.62");
		ud.save(user);
	}
}
