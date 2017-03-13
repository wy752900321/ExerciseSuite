package org.colin.dang.action.main;

import java.util.List;

import org.colin.dang.dao.ProductDAO;
import org.colin.dang.dao.impl.ProductDAOImpl;
import org.colin.dang.pojo.Product;

public class NewHotAction {
  private int size=8;
  private List<Product> pros;
  
  public String execute(){
	  ProductDAO proDao=new ProductDAOImpl();
	  pros=proDao.findMaxCount(size);
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
