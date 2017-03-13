package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;

public interface IBookDao {
	//根据categoryId 查询出图书,并完成分页，以及排序
	List<Book> findBookByCategoryId(int categoryId,Page page,String sort);
	//根据图书id查询出图书
	Book findBookById(int id);
	
	/**
	 * 根据Book查询类别
	 */
	List<Category> findCategoryByBookId(Book book);
	
}
