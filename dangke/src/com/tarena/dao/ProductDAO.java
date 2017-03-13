package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;
import com.tarena.entity.Product;

public interface ProductDAO {
	/**
	 * 查询前n个最新上架商品
	 * @param size 获取前n个
	 * @return
	 */
	public List<Product> findNewProduct(int number)throws Exception;
	public List<Book> findRecommendProduct(int number)throws Exception;
	public List<Product> findHotProduct( int start,int number) throws Exception;
	public List<String > newHotSaleColumn (int number ,int month) throws Exception;
	public List<Product> newHotProductAll(int number,int month) throws Exception;
	public List<Product> newProductAll(int page, int newNum) throws Exception;
	public int findProductNumber() throws Exception;
	public Product findProductById(int parseInt) throws Exception;
}
