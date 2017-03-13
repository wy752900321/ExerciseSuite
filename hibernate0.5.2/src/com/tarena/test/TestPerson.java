package com.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Person;
import com.tarena.entity.PersonAddress;
import com.tarena.util.HibernateUtil;

public class TestPerson {
//	@Test
	public void testAdd(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//添加
		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		person.setHome(new PersonAddress(
				       "1323223243",
						"北京大钟寺",
						"102222"));
		person.setCompany(new PersonAddress(
				"6456545",
				"中关村大街",
				"212222"
				));
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Person p = (Person)session.get(Person.class, 1);
		System.out.println(p.getId()+" "+p.getName());
		System.out.println("-----家庭地址-----");
		System.out.println(p.getHome().getPhone());
		System.out.println(p.getHome().getAddress());
		System.out.println(p.getHome().getZipcode());
		System.out.println("-----公司地址-----");
		System.out.println(p.getCompany().getPhone());
		System.out.println(p.getCompany().getAddress());
		System.out.println(p.getCompany().getZipcode());
		HibernateUtil.closeSession();
	}
	
	
}
