package com.tarena.dao;
import java.util.List;

import com.tarena.entity.Category;

public interface CategoryDAO extends java.io.Serializable{
	public List<Category> findAll() throws Exception;

	public List<Category> findByPID(int id) throws Exception ;
	public int findBookNumber(int cat_id) throws Exception;

	public String findNameById(Integer pid)throws Exception;
}
