package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;

/**
 * d_book信息处理
 * 
 * @author soft01
 * 
 */
public interface BookDAO {
	/**
	 * 通过类别找书
	 * 
	 * @param cid
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Book> findByCatId(int cid, int page, int size) throws Exception;

	/**
	 * 列出全部书
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAll() throws Exception;

	/**
	 * 获取总页数
	 * 
	 * @param cid
	 * @param rowsPerPage
	 * @return
	 * @throws Exception
	 */
	public int getTotalPages(int cid, int rowsPerPage) throws Exception;

	/**
	 * 查看详细信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Book findDetailById(int id) throws Exception;

	/**
	 * 查看其父类别名
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public String findParentName(Integer pid) throws Exception;

	/**
	 * 通过id查看购买的数量
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int findTotalNumById(int id) throws Exception;

	/**
	 * 通过id找书名
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<String> findNameById(int id) throws Exception;
}
