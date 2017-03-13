package com.tarena.biz;

import java.util.List;

import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;

public interface IBookServ {

	//查出所有的类别
	List<Category> showAllCategory();
	//查询子类别
	List<Category> showAllCategory(int parentId);
	//查询一个类别下的所有图书
	List<Book> findBookByCategoryId(int categoryId,Page page,String sort);
	//根据类别id查询出类别
	Category findCategoryByid(int parentId);
	//根据图书id查询出图书
	Book findBookById(int id);
	List<Category> findCategoryByBookId(Book book);
}
