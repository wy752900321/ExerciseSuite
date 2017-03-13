package org.colin.dang.action.main;

import java.util.List;

import org.colin.dang.dao.CategoryDAO;
import org.colin.dang.dao.ProductDAO;
import org.colin.dang.dao.impl.CategoryDAOImpl;
import org.colin.dang.dao.impl.ProductDAOImpl;
import org.colin.dang.pojo.Book;
import org.colin.dang.pojo.Category;
import org.colin.dang.pojo.Product;

public class BookListAction {
  private int pid;
  private int cid;
  private List<Category> cats;
  private List<Book> books;
  private int totalNum;
  private int page=1;
  private int pageSize=3;
  private int totalPage;
  
  public String execute(){
	  CategoryDAO dao=new CategoryDAOImpl();
	  cats=dao.findByParentId(pid);
//	  ProductDAO proDao=new ProductDAOImpl();
		 books= dao.findByCatId(cid, page, pageSize);
	  int proNum=dao.findProductByCatId(cid).size();
	  if(proNum%pageSize==0){
		  totalPage=proNum/pageSize;
	  }else{
		  totalPage=proNum/pageSize+1;
	  }
	  for(Category cat:cats){
		  totalNum+=cat.getProNum();
	  }
	  return "success";
  }

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public List<Category> getCats() {
	return cats;
}

public void setCats(List<Category> cats) {
	this.cats = cats;
}

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}

public int getTotalNum() {
	return totalNum;
}

public void setTotalNum(int totalNum) {
	this.totalNum = totalNum;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
  
 
  
  
}
