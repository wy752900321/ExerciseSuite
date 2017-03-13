package com.tarena.action.user;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.UserDAO;
import com.tarena.dao.impl.UserDAOImpl;
import com.tarena.entity.User;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;

public class LoginAction extends BaseAction {
	private User user;
	private String email;
	private String password;
	private String loginMessage;

	// 返回购物车要显示的信息；
	private List<CartItem> buyItems;
	private List<CartItem> deleteItems;
	private double moneySave;
	private double moneyCost;

	public String execute() {
		UserDAO userDAO = new UserDAOImpl();
		try {
			user = userDAO.checkEmailandPassword(email,password);
			if (user == null) {// 1.检查email和密码是否正确 不正确跳转到login_form.jsp
				loginMessage = "用户名或密码错误，请重试！";
				return "login";
			} else if (!user.isEmailVerify()) { // 2.检查邮箱是否通过验证
				 // ,未验证跳转到verify_form.jsp
				return "verify";
			}
			// 3.更新d_user中最后登录时间和ip
			userDAO.updateLoginTimeAndIp(user.getId(), System
					.currentTimeMillis(), request.getRemoteAddr());
			// 4.将user写入session,
			// 此时user里存放的是上一次登录的时间和IP
			session.put("user", user);
			// 5如果是从购物车界面返回的，就返回到购物车界面
			CartService cart = CartServiceImpl.getInstance(session);
			if (cart != null) {
				buyItems = cart.getItems(true);
				deleteItems = cart.getItems(false);
				moneySave = cart.countSave();
				moneyCost = cart.countCost();
				return "cart";
			}
			// 6.不是从购物车跳转到的就返回到当当网主界面main.jsp
			return "main";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public List<CartItem> getBuyItems() {
		return buyItems;
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