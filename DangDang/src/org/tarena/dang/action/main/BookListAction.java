package org.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.BookDAO;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.dao.impl.BookDAOImpl;
import org.tarena.dang.dao.impl.CategoryDAOImpl;
import org.tarena.dang.dao.impl.ProductDAOImpl;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Category;
import org.tarena.dang.entity.Product;

public class BookListAction {
	private Logger log = Logger.getLogger(this.getClass());

	// 接收参数 category.jsp
	private int cid;// 当前类别ID
	private int pid;// 父类别ID
	// 传出参数
	private List<Category> cats;// book_list.jsp左侧类别信息
	private List<Product> pros;// 右侧产品信息
	// 用于分页
	private int page = 1;// 当前页
	private int maxPage = 5; //总页数
	private int allBookNumbers;// 页面中显示"全部（23?）"的图书数量
	private int size = 5;// Action属性注入
	// out
	private String parentName; // 父类别的名字
	private String childrenName;// 子类别的名字
	private List<Book> books; //

	private int count;// 父类别的数量（总数量）

	public String execute() throws Exception {
		log.warn(".......BookListAction->execute() Begin...........");
		CategoryDAO catDao = new CategoryDAOImpl();
		ProductDAO proDao = new ProductDAOImpl();

		cats = catDao.findByParentId(pid);// 根据父Id填充cats

		pros = proDao.findBookByCatId(cid);// 根据当前类别ID填充pros集合

		BookDAO bookDao = new BookDAOImpl();
		books = bookDao.findBooksIf(cid, page, size);
		maxPage = bookDao.findMaxPage(cid, size);
		allBookNumbers = catDao.findBookNumber(pid);
		parentName = catDao.findNameById(pid);
		childrenName = catDao.findNameById(cid);
		log.warn(".......BookListAction->execute() End ..........."+pros.size());
		log.warn(".......BookListAction->execute() End ..........."+books.size());
		/*
		 *集合复制：
		 *	构造起复制
		 */
		pros = new ArrayList<Product>(books);
		
		return "success";
	}

	public Logger getLog() {
		return log;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public int getAllBookNumbers() {
		return allBookNumbers;
	}

	public void setAllBookNumbers(int allBookNumbers) {
		this.allBookNumbers = allBookNumbers;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
