package com.tarena.action.main;

import java.util.List;

import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.ProductDAOImpl;
import com.tarena.entity.Product;

public class NewAction {
	//input 
	//在页面上显示多少个图书信息,（属性注入）
	private int size=8;
	//output
	//在页面上显示的图书信息的集合
	private List<Product> listNew;
	public String execute(){
		ProductDAO proDao =new  ProductDAOImpl();
		try {
			listNew = proDao.findNewProduct(size);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}	
	}
	
	public List<Product> getListNew() {
		return listNew;
	}
	public void setListNew(List<Product> listNew) {
		this.listNew = listNew;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public static void main(String []args){
		NewAction action = new NewAction();
		System.out.println(action.execute()); 
	}
}
