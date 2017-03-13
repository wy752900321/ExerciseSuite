package com.tarena.action.main;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.MoreOtherBooksDAO;
import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.MoreOtherBooksDAOImpl;
import com.tarena.dao.impl.ProductDAOImpl;
import com.tarena.entity.Product;

public class MoreOtherBooks extends BaseAction {
	// input
	private int page = 1;// 当前页
	private int maxPage;
	// Action属性注入
	// 热销图书的数量
	private int hotNum = 5;
	//显示最新图书的数量
	private int newNum = 4;
	
	// 全部热销图书
	//全部最新图书
	//全部热销排行榜图书
	private List<Product> hotBook;
	//当前显示的是哪一个更多，用于页面中的上下页；
	private String nowAction;
	//更多热销图书
	public String moreHotBooks() {
		MoreOtherBooksDAO prosDao = new MoreOtherBooksDAOImpl();
		try {
			hotBook = prosDao.findHotProduct(page, hotNum);
			maxPage = prosDao.findHotProductNumber();
			maxPage = maxPage%hotNum==0 ? maxPage/hotNum : maxPage/hotNum+1;
			nowAction = "moreHotBooks.action";
			System.out.println("maxPage........"+maxPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//更多最新图书
	public String moreNewBooks(){
		ProductDAO proDao =new  ProductDAOImpl();
		try {
			System.out.println("moreNewBooks...........................");
			hotBook = proDao.newProductAll(page, newNum);
			maxPage = proDao.findProductNumber();
			System.out.println(maxPage);
			maxPage = maxPage%newNum==0 ? maxPage/newNum : maxPage/newNum+1;
			nowAction="moreNewBooks.action";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}	
		
	}
	//新书热销排行榜
	public String moreNewHotBooks(){
		int number = 3;
		int month = 120;
		try {
			ProductDAO proDao = new ProductDAOImpl();
			hotBook = proDao.newHotProductAll(number,month);
			nowAction="moreNewHotBooks.action";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public int getNewNum() {
		return newNum;
	}
	public void setNewNum(int newNum) {
		this.newNum = newNum;
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

	public List<Product> getHotBook() {
		return hotBook;
	}

	public void setHotBook(List<Product> hotBook) {
		this.hotBook = hotBook;
	}
	public void setNowAction(String nowAction) {
		this.nowAction = nowAction;
	}
	public String getNowAction() {
		return nowAction;
	}

}
