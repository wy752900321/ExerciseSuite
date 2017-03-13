package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;

/**
 * 专为排序而准备的DAO对象
 * 
 * @author soft01
 * 
 */
public interface SortDAO {
	/**
	 * book_list页面的排序
	 * 
	 * @param cid
	 *            类别id
	 * @param page
	 *            分页数
	 * @param size
	 *            每页大小
	 * @param rule
	 *            排序规则
	 * @return 返回一个书的集合
	 * @throws Exception
	 */
	public List<Book> order(int cid, int page, int size, int rule)
			throws Exception;
}
