package com.tarena.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.biz.IBookServ;
import com.tarena.dao.IBookDao;
import com.tarena.dao.ICategoryDao;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.factory.ObjectFactory;

public class BookServImpl implements IBookServ {

	private ICategoryDao icategoryDao = (ICategoryDao) ObjectFactory
			.createObject("ICategoryDao");
	private IBookDao ibookDao = (IBookDao) ObjectFactory
			.createObject("IBookDao");

	// 查询类别
	@Override
	public List<Category> showAllCategory() {
		// 获取所有的类别
		List<Category> categorys = icategoryDao.findAllCategory();
		// 获取父类别
		List<Category> cateFather = findFatherCategory(categorys, 1);
		// 获取子类别
		for (Category category : cateFather) {
			List<Category> cateChild = findFatherCategory(categorys, category
					.getId());
			category.setCateChild(cateChild);
		}
		return cateFather;
	}

	// 获取父类别以及这个父类别下的所有子类别
	private List<Category> findFatherCategory(List<Category> categorys,
			int parentId) {
		List<Category> cateFather = new ArrayList<Category>();
		for (Category category : categorys) {
			if (category.getParentId() == parentId) {
				cateFather.add(category);
			}
		}
		return cateFather;
	}

	public List<Category> showAllCategory(int parentId) {
		// 获取所有的类别
		List<Category> categorys = icategoryDao.findAllCategory();
		// 获取父类别
		List<Category> cateFather = findFatherCategory(categorys, parentId);
		// 获取子类别
		for (Category category : cateFather) {
			List<Category> cateChild = findFatherCategory(categorys, category
					.getId());
			category.setCount(icategoryDao.findProductByCategoryId(category)
					.size());
			category.setCateChild(cateChild);
		}
		return cateFather;
	}
	
	@Override
	public Category findCategoryByid(int parentId) {
		return icategoryDao.findCategoryByid(parentId);
	}

	@Override
	public List<Book> findBookByCategoryId(int categoryId, Page page,String sort) {
		return ibookDao.findBookByCategoryId(categoryId,page,sort);
	}

	@Override
	public Book findBookById(int id) {
		return ibookDao.findBookById(id);
	}

	@Override
	public List<Category> findCategoryByBookId(Book book) {
		return ibookDao.findCategoryByBookId(book);
	}

}
