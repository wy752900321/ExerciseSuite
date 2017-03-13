package com.tarena.action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.tarena.action.BaseAction;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;
import com.tarena.util.CookieUtil;

public class CartAction extends BaseAction {
	private int productId;	//商品的id
	private boolean ok=true; //判断添加到购物车是否成功或判断用户的购物车是否为空
	private int pnum;//更新某件某件商品的数量
	private List<CartItem> buyItems; //要购买的商品的集合
	private List<CartItem> deleteItems;//从购物车中删除的商品的集合
	private double moneySave;//购买商品的实际消费金额
	private double moneyCost;//购买商品节省的消费金额
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	/**
	 * 添加商品到购物车
	 * @return
	 */
	public String add() {
		CartService cart = CartServiceImpl.getInstance(session);
		boolean flag;
		try {
			flag = cart.add(productId);
			ok = flag ? true : false;
			CookieUtil.addCookie("cart", cart.store(), response);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	/**
	 *  更新购物车中某件商品数量
	 * @return
	 */
	public String update() {
		CartService cart = CartServiceImpl.getInstance(session);
		if (cart.update(productId, pnum)) {
			showCart();
			try {
				CookieUtil.addCookie("cart", cart.store(), response);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "success";
		} else {
			showCart();
			return "error";
		}
	}

	/**
	 * 删除购物车中的某件商品
	 * @return
	 */
	public String delete() {
		CartService cart = CartServiceImpl.getInstance(session);
		if (cart.delete(productId)) {
			showCart();
			try {
				CookieUtil.addCookie("cart", cart.store(), response);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * 恢复某件购物车中已删除的商品
	 * @return
	 */
	public String recovery() {
		CartService cart = CartServiceImpl.getInstance(session);
		if (cart.recovery(productId)) {
			showCart();
			try {
				CookieUtil.addCookie("cart", cart.store(), response);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "error";
			}
			return "success";
		}
		return "error";
	}

	/**
	 *  清空购物车
	 * @return
	 */
	public String clearCart() {
		CartService cart = CartServiceImpl.getInstance(session);
		cart.clearCart();
		CookieUtil.deleteCookie("cart", response);
		return "success";
	}
	/**
	 * 将购物车中的信息存储到字符串中
	 * 并返回 
	 */

	/**
	 * 结算时：如果购物车为空，就返回购物车界面，并给出提示信息！
	 * @return
	 */
	public String showOrderInfo() {
		CartService cart = CartServiceImpl.getInstance(session);
		if (cart == null || cart.getItems(true).size()==0) {
			ok = false;
			showCart();
			return "cart";
		}
		ok=true;
		showCart();
		return "success";
	}

	/**
	 * 显示购物车或显示订单信息
	 * @return
	 */
	public String showCart() {
		System.out.println("显示购物车。。。。begin。。。。");
		CartService cart = CartServiceImpl.getInstance(session);
		buyItems = cart.getItems(true);
		deleteItems = cart.getItems(false);
		moneyCost = cart.countCost();
		moneySave = cart.countSave();
		return "success";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<CartItem> getBuyItems() {
		return buyItems;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public void setBuyItems(List<CartItem> buyItems) {
		this.buyItems = buyItems;
	}

	public List<CartItem> getDeleteItems() {
		return deleteItems;
	}

	public void setDeleteItems(List<CartItem> deleteItems) {
		this.deleteItems = deleteItems;
	}

	public double getMoneySave() {
		return moneySave;
	}

	public void setMoneySave(double moneySave) {
		this.moneySave = moneySave;
	}

	public double getMoneyCost() {
		return moneyCost;
	}

	public void setMoneyCost(double moneyCost) {
		this.moneyCost = moneyCost;
	}

}
