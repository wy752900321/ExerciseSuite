package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Product;

public interface MoreOtherBookDAO {
	/**
	 * 热销产品
	 * @param page
	 * @param hotNum
	 * @return
	 * @throws Exception
	 */
	List<Product> findHotProduct(int page,int hotNum) throws Exception;
	/**
	 * 查找热销数量
	 * @return
	 * @throws Exception
	 */
	int findHotProductNumber() throws Exception;
}
