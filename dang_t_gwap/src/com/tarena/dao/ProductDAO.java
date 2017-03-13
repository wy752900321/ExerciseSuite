package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Product;

/**
 * 商品显示的信息处理
 * 
 * @author soft01
 * 
 */
public interface ProductDAO {
	/**
	 * 查询前n个最新上架商品
	 * 
	 * @param size
	 *            获取前n个
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception;

	/**
	 * 查询前n个热卖图书
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHotProduct() throws Exception;

	/**
	 * 查询前n个新书热卖图书
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewHotProduct() throws Exception;

	/**
	 * 通过id查询一个商品
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Product findProductById(int pid) throws Exception;
}
