package org.tarena.dang.dao;

import java.util.List;

import org.tarena.dang.entity.Category;

public interface CategoryDAO {
	/**
	 * 查询所有类别记录
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception;
	/**
	 * 根据parent_id条件查询类别记录
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception;
}
