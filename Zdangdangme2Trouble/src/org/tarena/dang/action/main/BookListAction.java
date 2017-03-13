package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.CategoryDAOImpl;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Category;
import org.tarena.dang.entity.Product;

public class BookListAction {
	//接收参数 category.jsp
	private int cid;//当前类别ID
	private int pid;//父类别ID
	//传出参数
	//book_list.jsp左侧类别信息
	private List<Category> cats;
	//右侧产品信息
	private List<Product> pros;
	public String execute() throws Exception{
		CategoryDAO catDao = new CategoryDAOImpl();
		ProductDAO proDao = new ProductDAOImpl();

		//根据父Id填充cats
			cats = catDao.findByParentId(pid);
			//TODO 根据当前类别ID填充pros集合
			pros =proDao.findBookByCatId(cid);
			return "success";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
}
