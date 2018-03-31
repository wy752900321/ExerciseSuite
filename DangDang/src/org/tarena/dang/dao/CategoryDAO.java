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
	/**
	 * 分页进用的，页面中显示"全部（23?）"的图书数量
	 * @param cat_id 父类别ID
	 * @return
	 * @throws Exception
	 */
	public int findBookNumber(int cat_id) throws Exception;
	/**
	 * 通过产品父类ID查
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public String findNameById(int pid) throws Exception;
}
