package org.colin.dang.dao;

import java.util.List;

import org.colin.dang.pojo.Book;
import org.colin.dang.pojo.Category;
import org.colin.dang.pojo.Product;

public interface CategoryDAO {
	//根据parentId查询图书的类别
 public List<Category> findByParentId(int parentId);
 //根据cartId查询产品并分页
 public List<Book> findByCatId(int catId,int page,int pageSize);
 //根据catId查询产品
 public List<Product> findProductByCatId(int catId);
}
