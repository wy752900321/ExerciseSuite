package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Category;

/**
 * d_category的信息处理
 * 
 * @author soft01
 * 
 */
public interface CategoryDAO {
	/**
	 * 按照turn找出商品并排序
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception;

	/**
	 * 通过父类别id找商品并按照turn排序
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception;

	/**
	 * 查询商品数量
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findBookNumber(int cid) throws Exception;

	/**
	 * 某个类别的商量的数量
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findCountByCatId(int cid) throws Exception;

	/**
	 * 通过类别id找到类别名
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public String findNameByCatId(Integer cid) throws Exception;
}
