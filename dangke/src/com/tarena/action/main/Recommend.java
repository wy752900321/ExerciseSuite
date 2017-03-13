package com.tarena.action.main;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.ProductDAOImpl;
import com.tarena.entity.Book;
public class Recommend {
	//input 显示页面出现的编辑推荐图书数目；
	private int size  = 2;
	//output 要显示的图书集合
	private List <Book> recList = new ArrayList<Book>();
	public String execute(){
		ProductDAO dao = new ProductDAOImpl();
		try {
			recList = dao.findRecommendProduct(2);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";	
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Book> getRecList() {
		return recList;
	}
	public void setRecList(List<Book> recList) {
		this.recList = recList;
	} 
	
}
