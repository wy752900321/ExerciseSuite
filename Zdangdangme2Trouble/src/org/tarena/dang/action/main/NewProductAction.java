package org.tarena.dang.action.main;

import java.util.List;

import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Product;

public class NewProductAction {
	private List<Product> pros;
	// Actionn属性注入
	private int size = 8;
	
	public String execute() throws Exception{
		ProductDAO proDao = new ProductDAOImpl();
			Thread.sleep(2000);
			pros = proDao.findNewProduct(size);
			return "success";
	}

	public List<Product> getPros() {
		return pros;
	}

	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
