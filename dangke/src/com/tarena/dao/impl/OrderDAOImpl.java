package com.tarena.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.service.impl.CartItem;

public class OrderDAOImpl extends GetConnection implements OrderDAO{
	private static final String  FindOrderByUserId = "select * from d_receive_address where user_id = ? ";
	private static final String  FindOrderByOrderId = "select * from d_receive_address where id = ? ";
	private static final String AddAddress =
		" insert into d_order ( mobile, order_desc , order_time , phone," +
		" postal_code , receive_name , status , user_id , total_price , full_address ) " +
		" values ( ?,?,?,?,?,?,?,?,?,?) ";
	private static final String AddProduct= 
		"insert into d_item ( order_id , product_id , product_name , " +
		" dang_price , product_num , amount  ) values ( ?, ?, ?, ?, ?, ?) ";
	private static final String AddCategoryProduct =
		"insert into d_receive_address ( user_id , receive_name , full_address , " +
		" postal_code , mobile , phone  ) values ( ?, ?, ?, ?, ?, ?) ";
	
	public List<Order> findOrderByUserId(int userId) throws Exception {
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		PreparedStatement prep = getConnection().prepareStatement(FindOrderByUserId);
		prep.setInt(1, userId);
		ResultSet rs = prep.executeQuery();
		while (rs.next()){
			order  = new Order();
			order.setId(rs.getInt("id"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
			order.setPostal_code(rs.getString("postal_code"));
			order.setReceive_name(rs.getString("receive_name"));
			order.setUser_id(rs.getInt("user_id"));
			order.setFull_address(rs.getString("full_address"));
			list.add(order);
		}
		for(Order o : list){
			System.out.println(o.getId()+"..........................."+o.getMobile());
		}
		return list;
	}

	public String findOrderByOrderId(int addressId) throws Exception {
		String orderStr = null;
		PreparedStatement prep = getConnection().prepareStatement(FindOrderByOrderId);
		prep.setInt(1, addressId);
		ResultSet rs = prep.executeQuery();
		rs.next();
		orderStr = rs.getString("receive_name")+"**"+rs.getString("full_address")+"**"+
							 rs.getString("postal_code")+"**"+rs.getString("mobile")+"**"+rs.getString("phone");	
		return orderStr;
	}

	public int addAddress(int userId, String receiveName, String fullAddress,
			String postalCode, String phone, String mobile,double totalPrice) throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(AddAddress ,Statement.RETURN_GENERATED_KEYS);
		prep.setString(1,mobile);
		prep.setString(2, "订单描述");
		Date date = new Date();
		prep.setLong(3, date.getTime());
		prep.setString(4, phone);
		prep.setString(5, postalCode);
		prep.setString(6, receiveName);
		prep.setInt(7,0);
		prep.setInt(8, userId);
		prep.setDouble(9, totalPrice);
		prep.setString(10, fullAddress);
		return prep.executeUpdate();//获得操作数
	}

	public void addProduct(int orderId, CartItem item) throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(AddProduct);
		prep.setInt(1, orderId);
		prep.setInt(2, item.getProduct().getId());
		prep.setString(3, item.getProduct().getProductName());
		prep.setDouble(4, item.getProduct().getDangPrice());
		prep.setInt(5, item.getCount());
		double amount = item.getCount()*item.getProduct().getDangPrice();
		prep.setDouble(6,amount);
		prep.executeUpdate();
	}

	public void addCategoryProduct(int userId, String receiveName,
			String fullAddress, String postalCode, String phone, String mobile)
			throws Exception {
		PreparedStatement prep = getConnection().prepareStatement(AddCategoryProduct);
		prep.setInt(1, userId);
		prep.setString(2, receiveName);
		prep.setString(3, fullAddress);
		prep.setString(4, postalCode);
		prep.setString(5, mobile);
		prep.setString(6, phone);
		prep.executeUpdate();
	}

}
