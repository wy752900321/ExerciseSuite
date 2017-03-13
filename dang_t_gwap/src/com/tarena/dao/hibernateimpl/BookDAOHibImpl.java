package com.tarena.dao.hibernateimpl;

import java.io.Serializable;
import java.util.List;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;

public class BookDAOHibImpl implements BookDAO, Serializable {
	private static final long serialVersionUID = -3746761075176578218L;

	public List<Book> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findByCatId(int cid, int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Book findDetailById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> findNameById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String findParentName(Integer pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int findTotalNumById(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTotalPages(int cid, int rowsPerPage) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
