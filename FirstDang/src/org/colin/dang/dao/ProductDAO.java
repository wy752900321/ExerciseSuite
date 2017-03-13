package org.colin.dang.dao;

import java.util.List;

import org.colin.dang.pojo.Product;

public interface ProductDAO {
	/**
	 * 
	 * @param size 取多少个
	 * @return
	 */
  public List<Product> findByAddTime(int size);
  
  public List<Product> findHot(int size);
  public List<Product> findMaxCount(int size);
}
