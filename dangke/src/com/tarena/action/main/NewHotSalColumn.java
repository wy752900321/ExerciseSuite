package com.tarena.action.main;

import java.util.List;

import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.ProductDAOImpl;

public class NewHotSalColumn {
	private List<String > newHotBooks;
	private int number = 3;
	private int month = 120;
	public String execute(){
		try {
			ProductDAO proDao = new ProductDAOImpl();
			newHotBooks = proDao.newHotSaleColumn(number, month);
//			for(String s :newHotBooks){
//				System.out.println(s.toString());
//			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public List<String> getNewHotBooks() {
		return newHotBooks;
	}
	public void setNewHotBooks(List<String> newHotBooks) {
		this.newHotBooks = newHotBooks;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
}
