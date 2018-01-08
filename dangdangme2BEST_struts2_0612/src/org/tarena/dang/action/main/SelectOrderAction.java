package org.tarena.dang.action.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.BookDAO;
import org.tarena.dang.dao.CategoryDAO;
import org.tarena.dang.dao.impl.BookDAOImpl;
import org.tarena.dang.dao.impl.CategoryDAOImpl;
import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Category;

public class SelectOrderAction extends BaseAction {
	// input
	private int cid;// 子类型 的id,对应数据库中的dcp.cat_id
	private int pid;// 父类型 的id
	private int page = 1;// 当前页
	private int maxPage = 5;// 获取最大页数
	private String select_order = "no";// 从页面中获取到的排序方式
	// Action属性注入
	private int size = 5;// 显示图书的数量
	// output
	private String parentsName;// 父类别的名字
	private String childrenName;// 子类别的名字
	private List<Category> cats; // 父类别
	private List<Book> pros; // 图书信息
	private int allBookNumbers;// 页面中显示"全部（23?）"的图书数量
	private Logger log = Logger.getLogger(this.getClass());

	public String execute() throws Exception {
		log.warn(".......cid的值........" + cid);
		log.warn(".......pid的值........" + pid);
		log.warn(".......page的值........" + page);
		log.warn(".......select_order的值........" + select_order);
		// 中间图书的信息
		BookDAO bookDao = new BookDAOImpl();
		if (select_order.equals("timeUp")) {
			pros = bookDao.findBooksIf_TimeUp(cid, page, size);
		} else if (select_order.equals("timeDown")) {
			pros = bookDao.findBooksIf_TimeDown(cid, page, size);
		} else if (select_order.equals("saleMoneyUp")) {
			pros = bookDao.findBooksIf_MoneyUp(cid, page, size);
		} else if (select_order.equals("saleMoneyDown")) {
			pros = bookDao.findBooksIf_MoneyDown(cid, page, size);
		} else if (select_order.equals("saleDown")) {
			pros = bookDao.findBooksIf_SaleDown(cid, page, size);
		} else if (select_order.equals("saleUp")) {
			pros = bookDao.findBooksIf_SaleUp(cid, page, size);
		} else {
			pros = bookDao.findBooksIf(cid, page, size);
		}
		// 左侧栏的内容；
		CategoryDAO catDao = new CategoryDAOImpl();
		cats = catDao.findByParentId(pid);
		maxPage = bookDao.findMaxPage(cid, size);
		allBookNumbers = catDao.findBookNumber(pid);
		parentsName = catDao.findNameById(pid);
		childrenName = catDao.findNameById(cid);
		log.warn("----------------"+pros.size()+"---------------");
		return "success";
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

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
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

	
	public List<Book> getPros() {
		return pros;
	}

	public void setPros(List<Book> pros) {
		this.pros = pros;
	}

	public int getAllBookNumbers() {
		return allBookNumbers;
	}

	public void setAllBookNumbers(int allBookNumbers) {
		this.allBookNumbers = allBookNumbers;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}
