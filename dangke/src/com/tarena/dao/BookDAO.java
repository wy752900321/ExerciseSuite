package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;

public interface BookDAO {

	List<Book> findBooksIf(Integer id, int page, int size) throws Exception;

	int findMaxPage(Integer id ,int size) throws Exception;

	Book getBookByBookId(int bookId) throws Exception;

	List<Book> findBooksIf_TimeUp(Integer cid, int page, int size) throws Exception;

	List<Book> findBooksIf_TimeDown(Integer cid, int page, int size)throws Exception;

	List<Book> findBooksIf_SaleDown(Integer cid, int page, int size) throws Exception;

	List<Book> findBooksIf_MoneyUp(int cid, int page, int size) throws Exception;

	List<Book> findBooksIf_MoneyDown(int cid, int page, int size)throws Exception;

}
