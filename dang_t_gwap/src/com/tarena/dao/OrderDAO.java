package com.tarena.dao;

import com.tarena.entity.Order;
/**
 * 创建定单
 * @author soft01
 *
 */
public interface OrderDAO {
	/**
	 * 创建定单
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int createOrder(Order order) throws Exception;
}
