package org.colin.dang.action.main;

import java.util.List;

import org.colin.dang.dao.RecommendDAO;
import org.colin.dang.dao.impl.RecommendDAOImpl;
import org.colin.dang.pojo.Book;
import org.colin.dang.pojo.Product;

public class RecommendAction {
	private int size=2;
  private List<Book> pro;

  public String execute(){
	  RecommendDAO reDao=new RecommendDAOImpl();
	  pro=reDao.findRecommend(size);
	  return "success";
  }
  


public List<Book> getPro() {
	return pro;
}



public void setPro(List<Book> pro) {
	this.pro = pro;
}



public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}
  
}
