package com.tarena.dao.hibernateimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.util.HibernateUtil;

/**
 * 创建定单
 * 
 * @author soft01
 * 
 */
public class OrderDAOHibImpl implements OrderDAO, Serializable {
	private static final long serialVersionUID = 8289583595560112490L;

	public int createOrder(Order order) throws Exception {
		// 1.创建session对象
		Session session = HibernateUtil.getSession();
		// 2.开始事务
		Transaction transaction = session.beginTransaction();
		// 3.保存定单,接收主键值
		Serializable identifier = session.save(order);
		// 4.事务提交
		transaction.commit();
		// 5.关闭session对象
		HibernateUtil.closeSession();
		// 6.返回主键值
		return (Integer) identifier;
	}

}
