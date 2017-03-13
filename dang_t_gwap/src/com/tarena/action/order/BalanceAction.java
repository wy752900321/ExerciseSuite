package com.tarena.action.order;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.action.BaseAction;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;

/**
 * 点击结算时进行的action处理
 * 
 * @author soft01
 * 
 */
public class BalanceAction extends BaseAction {
	private static final long serialVersionUID = 2025409779948165807L;
	// 所购买的商品的明细的集合
	private List<CartItem> list;
	// 购物车服务器对象
	private CartService cartService;

	public String execute() {
		// 获取当前监听器中的session
		session = ActionContext.getContext().getSession();
		try {
			// 创建购物车的实例对象
			setCartService(CartServiceImpl.getInstance(session, request));
		} catch (UnsupportedEncodingException e) {
			Logger logger = Logger.getLogger(BalanceAction.class);
			logger.error("不支持utf-8编码出错", e);
		}
		// 查看购物车中的购买的商品的集合
		list = cartService.getItems(true);
		// 如果此集合为空
		if (list.size() == 0) {
			// 链接到main.jsp
			return "main";
		}
		// 链接到order_info.jsp
		return "success";
	}

	// getter and setter
	public void setList(List<CartItem> list) {
		this.list = list;
	}

	public List<CartItem> getList() {
		return list;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

}
