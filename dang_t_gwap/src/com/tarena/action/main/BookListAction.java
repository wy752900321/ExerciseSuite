package com.tarena.action.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.dao.BookDAO;
import com.tarena.dao.CategoryDAO;
import com.tarena.dao.SortDAO;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.util.DAOFactory;

/**
 * 对book_list.jsp页面的显示逻辑
 * 
 * @author soft01
 * 
 */
public class BookListAction extends BaseAction {
	private static final long serialVersionUID = 7591352879827939606L;
	private Integer cid;// 当前类别ID
	private Integer pid;// 当前类别的父ID
	private int page = 1;// 当前页
	private int maxPage = 1;// 最大页
	private List<Category> cats;// 用于book_list.jsp的左侧类别数据
	private List<Book> pros;// 用于book_list.jsp的右侧产品数据
	private int allSum;// 左侧所有类别包含的产品数量之和
	// Action属性注入
	private int size = 5;// 每页5个
	private String pname;
	private int rule;
	private String cname;

	public String execute() {
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");// 实例化一个类别的DAO对象
		// 实例化一个书的DAO对象
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// 根据父ID获取页面左侧的兄弟菜单项
			cats = categoryDAO.findByParentId(pid);
			// 统计allSum，所有类别产品合计
			allSum = categoryDAO.findCountByCatId(pid);
			// 根据当前ID获取页面右侧的图书信息
			cname = categoryDAO.findNameByCatId(cid);

			// 数据绑定
			session.put("cid", cid);
			session.put("page", page);
			session.put("size", size);
			session.put("pid", pid);
			pros = bookDAO.findByCatId(cid, page, size);
			// 统计最大页数
			maxPage = bookDAO.getTotalPages(cid, 3);
			pname = bookDAO.findParentName(pid);
			// 链接到book_list.jsp
			return "success";
		} catch (Exception e) {
			Logger logger=Logger.getLogger(BookListAction.class);
			logger.error("在操作数据库时出现了异常", e);
			return "error";
		}
	}

	// 排序操作
	public String sort() {
		// 获取session中的对象
		page = (Integer) session.get("page");
		cid = (Integer) session.get("cid");
		pid = (Integer) session.get("pid");
		SortDAO sortDAO = (SortDAO) DAOFactory.getInstance("SortDAO");
		// 实例化一个类别的DAO对象
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");
		// 实例化一个书的DAO对象
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// 根据父ID获取页面左侧的兄弟菜单项
			cats = categoryDAO.findByParentId(pid);
			// 统计allSum，所有类别产品合计
			allSum = categoryDAO.findCountByCatId(pid);
			// 根据当前ID获取页面右侧的图书信息
			// 统计最大页数
			maxPage = bookDAO.getTotalPages(cid, 3);
			// 类别名
			cname = categoryDAO.findNameByCatId(cid);
			// 父类名
			pname = bookDAO.findParentName(pid);
			// 排序
			pros = sortDAO.order(cid, page, size, rule);
			// 链接到book_list.jsp
			return "success";
		} catch (Exception e) {
			Logger logger=Logger.getLogger(BookListAction.class);
			logger.error("在操作数据库时出了点异常", e);
			return "error";
		}
	}

	// getter and setter
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public List<Book> getPros() {
		return pros;
	}

	public void setPros(List<Book> pros) {
		this.pros = pros;
	}

	public int getAllSum() {
		return allSum;
	}

	public void setAllSum(int allSum) {
		this.allSum = allSum;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPname() {
		return pname;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public int getRule() {
		return rule;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}
}
