package com.tarena.action.main;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.BookDAO;
import com.tarena.dao.CategoryDAO;
import com.tarena.dao.impl.BookDAOImpl;
import com.tarena.dao.impl.CategoryDAOImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Category;

public class SelectOrderAction extends BaseAction {
	// input
	private int cid;//子类型的id，对应数据库中的dcp.cat_id;
	private int pid;//服类型的id
	private int page=1;// 当前页
	private int maxPage = 5;//获取最大页数
	private String select_order="no";//从页面中获取到的排序方式
	// Action属性注入
	private int size = 5;//显示图书的数量
	// output
	private String parentName;
	private String childrenName;
	private List<Category> cats;
	private List<Book> books;
	// 页面中显示"全部（23?）"的图书数量
	private int allBookNumbers;

	public String execute() {
		try {
			System.out.println("cid........................................."+cid);
			System.out.println("pid........................................."+pid);
			System.out.println("page........................................."+page);
			System.out.println("select_order........................................"+select_order);
			System.out.println("select_order........................."+select_order);
			//中间图书的信息；
			BookDAO bookDao = new BookDAOImpl();
			if (select_order.equals("timeUp")) {
				books = bookDao.findBooksIf_TimeUp(cid, page, size);
			} else if (select_order.equals("timeDown")) {
				books = bookDao.findBooksIf_TimeDown(cid, page, size);
			} else if (select_order.equals("saleMoneyUp")) {
				books = bookDao.findBooksIf_MoneyUp(cid, page, size);
			} else if(select_order.equals("saleMoneyDown")){
				books = bookDao.findBooksIf_MoneyDown(cid, page, size);
			}else if(select_order.equals("saleDown")){
				books = bookDao.findBooksIf_SaleDown(cid, page, size);
			}else{
				books=bookDao.findBooksIf(cid, page, size);
			}
			//左侧栏的内容；
			CategoryDAO catDao = new CategoryDAOImpl();
			cats = catDao.findByPID(pid);
			maxPage = bookDao.findMaxPage(cid, size);
			allBookNumbers = catDao.findBookNumber(pid);
			parentName = catDao.findNameById(pid);
			childrenName = catDao.findNameById(cid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getCid() {
		return cid;
	}

	public int getPid() {
		return pid;
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

	public String getSelect_order() {
		return select_order;
	}

	public void setSelect_order(String selectOrder) {
		select_order = selectOrder;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String childrenName) {
		this.childrenName = childrenName;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getAllBookNumbers() {
		return allBookNumbers;
	}

	public void setAllBookNumbers(int allBookNumbers) {
		this.allBookNumbers = allBookNumbers;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
