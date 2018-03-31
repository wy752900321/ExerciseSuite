package org.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.impl.CategoryDAOImpl;
import org.tarena.dang.entity.Category;

public class CategoryAction {
	//存放parent_id=1的一级类别
	private List<Category> cats;
	
	public String execute() throws Exception{
		CategoryDAO catDao = new CategoryDAOImpl();
			//Thread.sleep(2000);
			List<Category> all=catDao.findAll();
			//将所有Category对象构建起父子关系
			cats = findByParentId(all,1);
			//为cats元素中的Category对象填充subCats对象
			for(Category cat : cats){
				List<Category> subCats = findByParentId(all,cat.getId());
				cat.setSubCats(subCats);
			}
			return "success";
	}

	private List<Category> findByParentId(List<Category> all, int parent_id) {
		List<Category> list = new ArrayList<Category>();
		for(Category c:all){
			if(c.getParent_id()==parent_id){
				list.add(c);
			}
		}
		return list;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
}
