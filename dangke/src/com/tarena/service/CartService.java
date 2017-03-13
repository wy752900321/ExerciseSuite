package com.tarena.service;

import java.util.List;

import com.tarena.service.impl.CartItem;

public interface CartService {

	public boolean add(int productId) throws Exception;
	public  double countCost();
	public double countSave();
	public boolean delete(int pid);
	public List<CartItem> getItems(boolean buy);
	public boolean recovery (int pid);
	public boolean update(int pid,int pnum);
	public void clearCart();
	public void load(String findCookie) throws Exception;
	public String store();
}
