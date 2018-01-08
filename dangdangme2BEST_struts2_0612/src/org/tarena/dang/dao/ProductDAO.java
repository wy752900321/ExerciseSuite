package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Book;
import org.tarena.dang.entity.Product;

public interface ProductDAO {
	/**
	 * 获取最新上架产品
	 * @param size 最多取多少条
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception;
	/**
	 * 查询某个类别中包含哪些Book
	 * @param size 最多取多少条
	 * @return
	 * @throws Exception
	 */
	public List<Product> findBookByCatId(int catId) throws Exception;
	/**
	 *推荐图书
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public List<Book> findRecommendProduct(int number) throws Exception;
	/**
	 * 热销图书
	 * @param start
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHotProduct(int start,int number) throws Exception;
	/**
	 * 最新热销热卖
	 * @param page
	 * @param newNum
	 * @return
	 * @throws Exception
	 */
	public List<Product> newProductAll(int page,int newNum) throws Exception;
	/**
	 * 产品数量
	 * @return
	 * @throws Exception
	 */
	public int findProductNumber() throws Exception;
	/**
	 * 新书热销排行榜
	 * @param number
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public List<Product> newHotProductAll(int number,int month) throws Exception;
}
