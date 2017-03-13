package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Item;

/**
 * d_item的信息处理逻辑
 * 
 * @author soft01
 * 
 */
public interface ItemDAO {
	/**
	 * 插入数据
	 * 
	 * @param item
	 * @throws Exception
	 */
	public void insert(Item item) throws Exception;

	/**
	 * 通过product_id找出商品明细
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<Item> findByProductId(int productId) throws Exception;
}
