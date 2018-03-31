package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Order;
import org.tarena.dang.service.CartItem;

public interface OrderDAO {
	List<Order> findOrderByUserId(int user_id) throws Exception;
	String findOrderByOrderId(int address_id) throws Exception;
	int addAddress(int user_id,String receive_name,String full_address,
			String postal_code,String phone,String mobile,double total_price) throws Exception;
	void addProduct(int order_id,CartItem item) throws Exception;
	void addCategoryProduct(int i,String receive_name,String full_address,
			String postal_code,String phone,String mobile) throws Exception;
}
