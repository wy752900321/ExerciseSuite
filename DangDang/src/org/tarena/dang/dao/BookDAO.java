package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Book;

public interface BookDAO {
	/**
	 * bookDiscription的bookInfo.jsp信息
	 * 
	 * @param book_id
	 * @return
	 * @throws Exception
	 */
	Book getBookByBookId(int book_id) throws Exception;

	/**
	 * 根据图书查找Book
	 * 
	 * @param id
	 *            当前类别ID
	 * @param page
	 *            当前页
	 * @param size
	 *            显示的数目
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf(int id, int page, int size) throws Exception;

	/**
	 * 最多显示的条数
	 * 
	 * @param id
	 *            当前的类别id
	 * @param size
	 *            显示的数目
	 * @return
	 * @throws Exception
	 */
	int findMaxPage(int id, int size) throws Exception;

	/**
	 * 根据时间的Up来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_TimeUp(int cid, int page, int size) throws Exception;

	/**
	 * 根据时间的Down来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_TimeDown(int cid, int page, int size)
			throws Exception;

	/**
	 * 根据销量的UP来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_SaleUp(int cid, int page, int size) throws Exception;

	/**
	 * 根据销量的Down来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_SaleDown(int cid, int page, int size)
			throws Exception;

	/**
	 * 根据价格的UP来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_MoneyUp(int cid, int page, int size)
			throws Exception;

	/**
	 * 根据销量的Down来查找
	 * 
	 * @param cid
	 *            子类型id
	 * @param page
	 *            显示条数
	 * @param size
	 *            一次显示的条数
	 * @return
	 * @throws Exception
	 */
	List<Book> findBooksIf_MoneyDown(int cid, int page, int size)
			throws Exception;

}
