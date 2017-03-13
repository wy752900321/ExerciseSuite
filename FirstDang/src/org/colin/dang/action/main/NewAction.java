package org.colin.dang.action.main;

import java.util.List;

import org.colin.dang.dao.ProductDAO;
import org.colin.dang.dao.impl.ProductDAOImpl;
import org.colin.dang.pojo.Product;

public class NewAction {
     private int size=8;//默认取前八
     private List<Product> pros;
     
     public String execute() throws Exception{
    	 Thread.sleep(600);
    	 ProductDAO proDao=new ProductDAOImpl();
    	 pros=proDao.findByAddTime(size);
    	 return "success";
    	 
     }
     
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
     
}
