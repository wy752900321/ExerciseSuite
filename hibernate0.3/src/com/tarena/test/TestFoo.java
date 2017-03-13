package com.tarena.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Foo;
import com.tarena.util.SessionUtil;

/**
 * 测试主键生成方式和date映射类型
 */
public class TestFoo {
	@Test
	public void testAdd() throws Exception{
		Foo foo = new Foo();
		foo.setName("apple");
		foo.setBirth(new Date(System.currentTimeMillis()));
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(foo);
		tx.commit();
		session.close();
	}
}
