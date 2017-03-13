package com.tarena.dao.impl;

import java.util.List;

import com.tarena.dao.BaseDAO;
import com.tarena.dao.OrderDAO;

public class HibernateOrderDAO extends BaseDAO implements OrderDAO {

	public List<Object[]> findOrders() {
		// 没有映射Order到User的多对一时
		String hql = "select o.id,u.nickname,o.orderTime,o.totalPrice "
				+ "from Order o ,User u where o.userId=u.id";
		// Order到User的多对一时
		String hql2 = "select o.id,o.user.nickname,o.orderTime,o.totalPrice "
				+ "from Order 0";
		this.getHibernateTemplate().find(hql2);
		return null;
	}

}
