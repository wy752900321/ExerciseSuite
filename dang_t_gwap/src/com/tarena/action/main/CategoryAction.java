package com.tarena.action.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;
import com.tarena.util.DAOFactory;

/**
 * 类别category.jsp的显示逻辑
 * 
 * @author soft01
 * 
 */
public class CategoryAction implements Serializable {
	private static final long serialVersionUID = 7008313760713395351L;
	// 用于存放类别的类别集合
	private List<Category> cats;

	public String execute() {
		// 初始化一个类别的DAO对象
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");
		try {
			// 找出所有的类别表中的数据
			List<Category> all = categoryDAO.findAll();
			// 将parentId=1的元素填充到cats集合
			cats = findByParentId(all, 1);// 所有的商品的父id为1的商品
			// 填充parentId=1的Category对象的subCats
			for (Category category : cats) {
				// 把父id为1的商品的子类别列举出来
				List<Category> subCats = findByParentId(all, category.getId());
				// 把父id为1的商品的子类别填充到subCats集合当中
				category.setSubCats(subCats);
			}
			// 链接到category.jsp
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger logger = Logger.getLogger(CategoryAction.class);
			logger.error("在操作数据库时出了一点异常", e);
			return "error";
		}
	}

	/**
	 * 从all集合中选取parent_id=parentId的子类别
	 * 
	 * @param all
	 * @param parentId
	 * @return
	 */
	private List<Category> findByParentId(List<Category> all, int parentId) {
		// 初始化类别的集合
		List<Category> list = new ArrayList<Category>();
		// 遍历集合all
		for (Category category : all) {
			// 查寻category的父id，如果此id等于传入的parentId
			if (category.getParentId() == parentId) {
				// 则把category加入到集合中
				list.add(category);
			}
		}
		// 返回一个list集合
		return list;
	}

	// getter and setter
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public List<Category> getCats() {
		return cats;
	}

}
