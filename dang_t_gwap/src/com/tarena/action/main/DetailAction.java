package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;

/**
 * 书籍明细
 * 
 * @author soft01
 * 
 */
public class DetailAction implements Serializable {
	private static final long serialVersionUID = 7267484624980612551L;
	private Book book;
	private int id;
	private String name;

	public String execute() {
		// 创建BookDAO对象
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// 通过id找书籍明细
			book = bookDAO.findDetailById(id);
			// 获取返回回来的书类别名
			List<String> names = bookDAO.findNameById(id);
			name = names.get(2) + ">>" + names.get(1) + ">>" + names.get(0);
			// 链接到book_info.jsp
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger logger = Logger.getLogger(DetailAction.class);
			logger.error("操作数据库时出了一点点异常", e);
			return "error";
		}
	}

	// getter and setter
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
