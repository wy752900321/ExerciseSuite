package com.tarena.dao.hibernateimpl;

import java.io.Serializable;
import java.util.List;

import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;

public class CategoryDAOHibImpl implements CategoryDAO, Serializable {
	private static final long serialVersionUID = -4896918691989052799L;

	public List<Category> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int findBookNumber(int cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Category> findByParentId(int pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int findCountByCatId(int cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public String findNameByCatId(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
