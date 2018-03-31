package org.tarena.dang.action.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Product;

public class NewProductAction {
	private Logger log = Logger.getLogger(this.getClass());
	//input 
	//在页面上显示多少个图书信息,（属性注入）
	private int size = 8;
	
	//output
	//在页面上显示的图书信息的集合
	private List<Product> pros;
	public String execute() throws Exception{
		log.warn("..........最新上架图书...........");
		ProductDAO proDao = new ProductDAOImpl();
			//Thread.sleep(2000);
			pros = proDao.findNewProduct(size);
			return "success";
	}


	public List<Product> getPros() {
		return pros;
	}


	public Logger getLog() {
		return log;
	}


	public void setLog(Logger log) {
		this.log = log;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
