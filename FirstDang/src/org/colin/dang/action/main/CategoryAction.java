package org.colin.dang.action.main;

import java.util.List;

import org.colin.dang.dao.CategoryDAO;
import org.colin.dang.dao.impl.CategoryDAOImpl;
import org.colin.dang.pojo.Category;

public class CategoryAction {
 private int parentId=1;
 private List<Category> cats;
 
 public String execute() throws Exception{
	 Thread.sleep(500);
	 CategoryDAO catDao=new CategoryDAOImpl();
	 cats=catDao.findByParentId(parentId);
	 return "success";
 }
 
public int getParentId() {
	return parentId;
}
public void setParentId(int parentId) {
	this.parentId = parentId;
}
public List<Category> getCats() {
	return cats;
}
public void setCats(List<Category> cats) {
	this.cats = cats;
}
 
 
}
