package org.tarena.dang.dao;

import java.util.List;

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
}
