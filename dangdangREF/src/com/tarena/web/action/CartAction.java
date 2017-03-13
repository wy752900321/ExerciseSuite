package com.tarena.web.action;

import java.util.ArrayList;
import java.util.List;

import com.tarena.biz.IBookServ;
import com.tarena.entity.CartItem;
import com.tarena.entity.exet.Book;
import com.tarena.factory.ObjectFactory;
import com.tarena.util.collection.Cart;

public class CartAction extends BaseAction {
	private Book book;
	private List<CartItem> cartItems;
	private int updateCount;
	private String errorMsg;
	// 工厂
	private IBookServ ibookServ = (IBookServ) ObjectFactory
			.createObject("IBookServ");

	// 跳到购物车页面
	public String goCart() {
		return "cart_list";
	}

	// 显示购物车
	public String showCart() {
		// 获取购物车
		Cart cart = (Cart) session.get("cart");
		cartItems = cart.findAllCartItem();
		session.put("cartItems", cartItems);
		// 计算总价
		double sumPrice = cart.sumPrice();
		session.put("sumPrice", sumPrice);
		// 计算共节省的价钱
		double save = cart.save();
		session.put("save", save);
		return "cart_list";
	}

	// 添加商品
	public String addBook() {
		book = ibookServ.findBookById(book.getId());
		// 检查购物篮是否存在
		Cart cart = (Cart) session.get("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addBook(book.getId(), book);
		session.put("cart", cart);
		return "showCart";
	}

	// 删除商品
	public String delete() {
		Cart cart = (Cart) session.get("cart");
		cart.deleteCartItemById(book.getId());
		return "showCart";
	}

	// 恢复删除的商品
	public String recover() {
		Cart cart = (Cart) session.get("cart");
		cart.recover(book.getId());
		return "showCart";
	}

	// 修改数量
	public String update() {
		Cart cart = (Cart) session.get("cart");
		cart.updateCartItemCount(book.getId(), updateCount);
		return "showCart";
	}

	public String toOrder() {
			// 检查用户是否登录过
			if (loginOk()) {
				Cart cart = (Cart) session.get("cart");
				cartItems = cart.findAllCartItem();
				List<CartItem> cats = new ArrayList<CartItem>();
				for (CartItem cartItem : cartItems) {
					if (cartItem.isFlag() == false) {
						cats.add(cartItem);
					}
				}
				session.put("cartItems", cats);
				//没有购买不能结算
				double sum =(Double)this.session.get("sumPrice");
				if(sum<=0){
					errorMsg="您还未购买任何商品";
					return "cart_list";
				}
				
				return "order_info";
			} else {
				// 返回到登录界面
				return "login_form";
			}
			
			
			
	}

	private boolean loginOk() {
		boolean isLogin = false;
		if (session.get("loginOk") != null) {
			isLogin = true;
		}
		return isLogin;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
