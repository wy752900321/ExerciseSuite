package com.tarena.action.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;

/**
 * 编辑推荐recommend.jsp部分的显示逻辑
 * 
 * @author soft01
 * 
 */
public class RecommendAction implements Serializable {
	private static final long serialVersionUID = -8707206896610682354L;
	private List<Book> books;// 用于存放随机生成的两本书

	public String execute() {
		// 实例化一个书的DAO对象
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// 实例化书的集合对象
			books = new ArrayList<Book>();
			// 列出所有的书
			List<Book> list = bookDAO.findAll();
			// 进行次循环找出两本书
			for (int i = 0; i < 2; i++) {
				// 1.对所有书的个数随机取其中某个整数
				// 2.移除该整数位置的书并获得该书的具体内容
				// 3.把此书加入到books集合中
				books.add(list.remove((int) (Math.random() * list.size())));
			}
			// 链接recommend.jsp
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger  logger=Logger.getLogger(RecommendAction.class);
			logger.error("在构建编辑推荐图书时出了异常", e);
			// error.jsp
			return "error";
		}
	}

	// getter and setter
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

}
