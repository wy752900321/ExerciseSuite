package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * 新书上架new.jsp的显示逻辑
 * 
 * @author soft01
 * 
 */
public class NewProductAction implements Serializable {
	private static final long serialVersionUID = 2211088643858860874L;
	// 把取出来的8本书加入到集合当中
	private List<Product> pros;

	public String execute() {
		// 实例化一个产品的DAO对象
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			// 通过dao对象调用findNewProduct方法取出8本书
			setPros(productDAO.findNewProduct(8));
			for (Product product : pros) {
				System.out.println(product.getId() + " "
						+ product.getProductName());
			}
			// new.jsp显示
			return "success";
		} catch (Exception e) {
			// 出错了记录日志跳转到error.jsp
			Logger logger = Logger.getLogger(NewProductAction.class);
			logger.error("在构建新书的时候出了点异常", e);
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
