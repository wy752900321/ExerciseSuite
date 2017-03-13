package com.tarena.action.main;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.CategoryDAO;
import com.tarena.dao.impl.CategoryDAOImpl;
import com.tarena.entity.Category;;
public class CategoryAction {
	private List<Category> cats;
	public String execute(){
		CategoryDAO catDao = new CategoryDAOImpl();
		try{
			List<Category>all = catDao.findAll();
			//将parentId =1 的元素存入集合；
			 cats= findByParentId(all,1);
			 for(Category cat :  cats){
				List <Category> subCats =findByParentId(all,cat.getId());
				 cat.setSubCats(subCats); 
			 }
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	private List<Category> findByParentId(List<Category> all, int pid) {
		List<Category> subCats=new ArrayList<Category>();
		for(Category c : all){
			// System.out.println(c.getId()+"    name =  "+c.getName());
			if(c.getParentId()==pid){
				subCats.add(c);
			}
		}
		return subCats;
	}
	
	
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public static void main(String []args){
		CategoryAction action = new CategoryAction();
		System.out.println(action.execute());
	}
}
