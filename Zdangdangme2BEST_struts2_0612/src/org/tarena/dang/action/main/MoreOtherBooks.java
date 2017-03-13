package org.tarena.dang.action.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.MoreOtherBookDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.MoreOtherBooksDAOImpl;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Product;

public class MoreOtherBooks {
	private Logger log = Logger.getLogger(this.getClass());
	//input
	private int page=1;//当前页
	private int maxPage;
	//Action属性注入
	//热销图书的数量
	private int hotNum = 5;
	//显示最新图书的数量 
	private int newNum = 4;
	
	//全部热销图书
	//全部最新图书
	//全部热销排行榜图书
	private List<Product> hotBook;
	//当前显示的是哪一个更好，用于页面中的上下页；
	private String nowAction;
	//更多热销图书
	public String moreHotBooks() throws Exception{
		log.warn("...............moreHotBooks()....................");
		MoreOtherBookDAO prosDao = new MoreOtherBooksDAOImpl();
		hotBook = prosDao.findHotProduct(page, hotNum);
		maxPage = prosDao.findHotProductNumber();
		maxPage = maxPage%hotNum==0?maxPage/hotNum:maxPage/hotNum+1;
		nowAction = "moreHotBooks.action";
		return "success";
	}
	//更多最新图书
	public String moreNewBooks() throws Exception{
		log.warn("...............moreNewBooks()....................");
		ProductDAO proDao = new ProductDAOImpl();
		hotBook = proDao.newProductAll(page, newNum);
		maxPage = proDao.findProductNumber();//产品数量
		//产品数量／最新图书的数量
		maxPage = maxPage%newNum==0?maxPage/newNum:maxPage/newNum+1;
		nowAction ="moreNewBooks.action";
		return "success";
	}
	//新书热销排行榜
	public String moreNewHotBooks() throws Exception{
		int number = 3;
		int month = 120;
		ProductDAO proDao = new ProductDAOImpl();
		hotBook=proDao.newHotProductAll(number,month);
		nowAction = "moreNewHotBooks.action";
		return "success";
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getHotNum() {
		return hotNum;
	}
	public void setHotNum(int hotNum) {
		this.hotNum = hotNum;
	}
	public int getNewNum() {
		return newNum;
	}
	public void setNewNum(int newNum) {
		this.newNum = newNum;
	}
	public List<Product> getHotBook() {
		return hotBook;
	}
	public void setHotBook(List<Product> hotBook) {
		this.hotBook = hotBook;
	}
	public String getNowAction() {
		return nowAction;
	}
	public void setNowAction(String nowAction) {
		this.nowAction = nowAction;
	}
}
