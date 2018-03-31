package org.tarena.dang.action.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Product;

public class HotAction  extends BaseAction {
	private Logger log = Logger.getLogger(this.getClass());
	// input属性注入热销图书的数量
	private int hotNum = 3;
	// output热销图书集
	private List<Product> hotBook;
	public String execute() throws Exception {
		log.warn("....................热销..............");
		ProductDAO proDao =new ProductDAOImpl();
		hotBook = proDao.findHotProduct(1, hotNum);
		return "success";
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
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
