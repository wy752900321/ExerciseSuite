package com.tarena.action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartServiceImpl;
import com.tarena.service.impl.CartItem;
import com.tarena.util.Constant;
import com.tarena.util.CookieUtil;

/**
 * 对购物车的管理操作，cart_list.jsp
 * 
 * @author soft01
 * 
 */
public class CartAction extends BaseAction {
	private static final long serialVersionUID = 5439995935441058652L;
	private int id;// input
	private int pnum;// input
	private boolean ok = false;
	private boolean flag;
	private List<CartItem> buyPro;// 购买的商品
	private List<CartItem> delPro;// 删除的商品
	private CartService cartService;
	private double cartCost;// 花的钱数

	public String execute() {
		try {
			// 实例化购物车对象
			cartService = CartServiceImpl.getInstance(session, request);
			init();
		} catch (UnsupportedEncodingException e) {
			Logger logger = Logger.getLogger(CartAction.class);
			logger.error("不支持utf-8编码", e);
		}
		return "success";
	}

	// 购买处理
	public String add() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// 添加操作
		flag = cartService.add(id);
		// 添加cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		if (flag) {
			ok = true;
			// 返回json结果
			return "success";
		} else {
			return "error";
		}
	}

	// 更新处理
	public String update() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// 更新
		flag = cartService.update(id, pnum);
		// 初始化操作
		init();
		// 添加cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		if (flag) {
			// 返回json结果
			return "success";
		} else {
			return "error";
		}
	}

	// 删除操作
	public String delete() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// 删除
		flag = cartService.delete(id);
		// 添加cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		// 初始化操作
		init();
		if (flag) {
			// 返回json结果
			return "success";
		} else {
			return "error";
		}
	}

	// 恢复操作
	public String recovery() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// 恢复
		flag = cartService.recovery(id);
		// 添加cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		// 初始化
		init();
		if (flag) {
			// 返回json结果
			return "success";
		} else {
			return "error";
		}
	}

	private void init() {
		// 获取当前购物车中的所有已经购物和删除的商品
		buyPro = cartService.getItems(true);
		delPro = cartService.getItems(false);
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setBuyPro(List<CartItem> buyPro) {
		this.buyPro = buyPro;
	}

	public List<CartItem> getBuyPro() {
		return buyPro;
	}

	public void setDelPro(List<CartItem> delPro) {
		this.delPro = delPro;
	}

	public List<CartItem> getDelPro() {
		return delPro;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public void setCartCost(double cartCost) {
		this.cartCost = cartCost;
	}

	public double getCartCost() {
		return cartCost;
	}

}
