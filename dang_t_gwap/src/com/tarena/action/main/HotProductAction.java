package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * 热销图书hot.jsp的显示逻辑
 * 
 * @author soft01
 * 
 */
public class HotProductAction implements Serializable {
	private static final long serialVersionUID = 929243047619563046L;
	//用于存放热销图书的集合
	private List<Product> products;

	public String execute() {
		//实例化一个产品的DAO对象
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			//调用方法把结果添加到集合中
			products = productDAO.findHotProduct();
			// 链接到hot.jsp
			return "success";
		} catch (Exception e) {
			// 记录日志
			Logger logger=Logger.getLogger(HotProductAction.class);
			logger.error("在查找热卖图书的时候出了异常", e);
			return "error";
		}
	}

	// getter and setter
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
}
