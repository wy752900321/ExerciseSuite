package org.tarena.dang.dao;

import org.tarena.dang.entity.Product;


public interface CartDAO {
	/**
	 * 通过产品ID查找图书
	 * @param pid 产品ID
	 * @return	图书
	 * @throws Exception
	 */
	public Product findProductByPid(int pid) throws Exception;
}
