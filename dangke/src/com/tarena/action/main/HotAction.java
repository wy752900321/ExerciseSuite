package com.tarena.action.main;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.ProductDAOImpl;
import com.tarena.entity.Product;

public class HotAction extends BaseAction {
	// input属性注入
	// 热销图书的数量
	private int hotNum = 3;
	// output
	// 热销图书集
	private List<Product> hotBook;

	public String execute() {
		try {
			ProductDAO proDao = new ProductDAOImpl();
			hotBook = proDao.findHotProduct(1,hotNum);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getHotNum() {
		return hotNum;
	}

	public void setHotNum(int hotNum) {
		this.hotNum = hotNum;
	}

	public List<Product> getHotBook() {
		return hotBook;
	}

	public void setHotBook(List<Product> hotBook) {
		this.hotBook = hotBook;
	}

}
