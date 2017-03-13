package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Order;
import com.tarena.service.impl.CartItem;

public interface OrderDAO {

	List<Order> findOrderByUserId(int userId) throws Exception;

	String findOrderByOrderId(int addressId) throws Exception;

	int addAddress(int i, String receiveName, String fullAddress,
			String postalCode, String phone, String mobile, double totalPrice) throws Exception;

	void addProduct(int orderId, CartItem item)throws Exception;

	void addCategoryProduct(int i, String receiveName, String fullAddress,
			String postalCode, String phone, String mobile)throws Exception;

}
