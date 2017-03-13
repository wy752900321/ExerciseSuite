package com.tarena.action.main;

import java.util.List;

import com.tarena.dao.BookDAO;
import com.tarena.dao.CategoryDAO;
import com.tarena.dao.impl.BookDAOImpl;
import com.tarena.dao.impl.CategoryDAOImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Category;

public class BookListAction {
	// input
	private Integer cid;
	private Integer pid;
	private int page = 1;// 当前页
	private int maxPage = 5;
	// Action属性注入
	private int size = 5;
	// output
	private String parentName;
	private String childrenName;
	private List<Category> cats;
	private List<Book> books;
	// 页面中显示"全部（23?）"的图书数量
	private int allBookNumbers;

	public String execute() {
		try {
			System.out.println("BookListAction.......");
			CategoryDAO catDao = new CategoryDAOImpl();
			BookDAO bookDao = new BookDAOImpl();
			cats = catDao.findByPID(pid);
			books = bookDao.findBooksIf(cid, page, size);
			maxPage = bookDao.findMaxPage(cid, size);
			allBookNumbers = catDao.findBookNumber(pid);
			parentName=catDao.findNameById(pid);
			childrenName=catDao.findNameById(cid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getAllBookNumbers() {
		return allBookNumbers;
	}

	public void setAllBookNumbers(int allBookNumbers) {
		this.allBookNumbers = allBookNumbers;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		BookListAction action = new BookListAction();
		System.out.println(action.execute());
		System.out.println(action.allBookNumbers);

	}


}
