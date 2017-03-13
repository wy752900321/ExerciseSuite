package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * 新书热卖榜newhot.jsp的显示逻辑
 * 
 * @author soft01
 * 
 */
public class NewHotProductAction implements Serializable {
	private static final long serialVersionUID = -4106185149840831938L;
	// 把找到的新书存放到集合当中
	private List<Product> pros;

	public String execute() {
		// 实例化一个产品的DAO对象
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			// 调用方法获取新书热卖的图书
			pros = productDAO.findNewHotProduct();
			// 链接到newhot.jsp
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger logger=Logger.getLogger(NewHotProductAction.class);
			logger.error("在查找新书热卖的图书时出了异常", e);
			// 链接到error.jsp
			return "error";
		}
	}

	// getter and setter 
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public List<Product> getPros() {
		return pros;
	}
}
