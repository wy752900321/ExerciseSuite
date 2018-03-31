package org.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Book;

public class Recommend {
	private Logger log = Logger.getLogger(this.getClass());
	// input 显示页面出现的编辑推荐图书数目；
	private int size = 2;
	// output 要显示的图书集合
	private List<Book> recList = new ArrayList<Book>();
	
	public String execute() throws Exception {
		log.warn("........图书推荐.....");
		ProductDAO dao = new ProductDAOImpl();
		recList = dao.findRecommendProduct(2);
		return "success";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Book> getRecList() {
		return recList;
	}

	public void setRecList(List<Book> recList) {
		this.recList = recList;
	}
}
