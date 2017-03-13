package com.tarena.web.action;

import java.util.List;

import com.tarena.biz.IBookServ;
import com.tarena.biz.IOrderServ;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.factory.ObjectFactory;

public class BookAction extends BaseAction {
	private List<Category> categorys;
	private Category category;
	// 父类别的数量（总数量）
	private int count;
	// 业务工厂
	private IBookServ ibookServ = (IBookServ) ObjectFactory
			.createObject("IBookServ");
	private IOrderServ iorderServ = (IOrderServ) ObjectFactory
			.createObject("IOrderServ");
	// 图书集合
	private List<Book> books;
	// 图书信息
	private Book book;
	private Page page = new Page();
	// 每页显示的条数
	private int pageSize = 3;
	// 排序
	private String sort = "publish_time desc";

	/**
	 * 在main页面 显示书籍类别
	 * 
	 */
	public String showCategory() {
		categorys = ibookServ.showAllCategory();
		return "category";
	}

	// 进入书籍分类的页面
	public String showBookCategory() {
		// 在book_list.jsp中设置父结点样式
		session.put("categoryId", category.getId());
		// 获取所有的类别
		categorys = ibookServ.showAllCategory();

		// 获取父结点的信息
		Category fatherCategory = ibookServ.findCategoryByid(category
				.getParentId());
		session.put("fatherCategory", fatherCategory);
		// 获取子结点的集合
		categorys = ibookServ.showAllCategory(category.getParentId());
		for (Category cate : categorys) {
			if (cate.getId() == category.getId()) {
				// 求子结点的数量
				category.setCount(cate.getCount());
				session.put("cate", cate);
			}
			// 求父结点的总数量
			count += cate.getCount();
		}
		// 设置每页显示的条数
		page.setPageSize(pageSize);
		// 分页以及排序
		books = ibookServ.findBookByCategoryId(category.getId(), page, sort);

		return "book_list";
	}

	/**
	 * 查看图书详情
	 * 
	 * @return
	 */
	public String product() {
		book = ibookServ.findBookById(book.getId());
		List<Category> categorys = ibookServ.findCategoryByBookId(book);
		Category father = categorys.get(1);
		Category child = categorys.get(0);
		session.put("father", father);
		session.put("child", child);
		session.put("book", book);
		return "product";
	}

	/**
	 * 最新上架图书
	 * 
	 * @return
	 */
	public String newBook() {
		Page page = new Page();
		page.setBegin(0);
		page.setPageSize(4);
		String sort = "add_time desc";
		List<Book> books = ibookServ.findBookByCategoryId(1, page, sort);
		session.put("books", books);
		return "new";
	}

	/**
	 * 热卖图书
	 * 
	 * @return
	 */
	public String hotBook() {
		Page page = new Page();
		page.setBegin(0);
		page.setPageSize(4);
		List<Book> books = iorderServ.findBookByCategoryId(page);
		session.put("books", books);
		return "hot";
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
