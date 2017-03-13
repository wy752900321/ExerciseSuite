package com.tarena.dao;

import java.util.List;

import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.entity.exet.Product;

public interface ICategoryDao {

	//获取所有的类别
	List<Category> findAllCategory();
	//查询一个类别下的产品的数量
	 List<Product> findProductByCategoryId(Category category);
	//根据类别id查询出类别
	Category findCategoryByid(int parentId);
}
