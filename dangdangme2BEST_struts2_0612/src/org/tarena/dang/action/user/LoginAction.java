package org.tarena.dang.action.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.UserDAO;
import org.tarena.dang.dao.impl.UserDAOImpl;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.service.CartService;
import org.tarena.dang.service.impl.CartServiceImpl;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.MD5Utils;

public class LoginAction extends BaseAction {
	private String email;
	private String password;
	private User user;
	private String login_erro_msg;
	private UserDAO dao = new UserDAOImpl();
	private String uri;
	private Logger log = Logger.getLogger(this.getClass());
	
	//返回购物车要显示的信息
	private List<CartItem> buyItems;//要购买的商品集合
	private List<CartItem> deleteItems;//从购物车里删除的商品集合
	private double moneyCost;//实际消费金额
	private double moneySave;//节省金额
	public String execute() throws Exception {

			user = dao.findByEmail(email);
			String pwd = MD5Utils.md5(password);
			// 1.检查email和密码是否正确 不正确跳转到login_form.jsp
			if (user != null && pwd.equals(user.getPassword())) {
				// 2.检查邮箱是否通过验证,未验证跳转到verify_form.jsp
				if (user.isEmailVerify()) {
					// 3.更新d_user中最后登录时间和ip
					user.setLastLoginTime(System.currentTimeMillis());
					user.setLastLoginIp(httpRequest.getRemoteAddr());
					dao.updateTimeOrIp(user);
					// 4.将user写入session,此时user里存放的是上一次登录的时间和IP
					session.put(Constant.USER_KEY, user);
					//5如果是从购物车界面返回的，就返回到购物车界面
					/*CartService cart = CartServiceImpl.getInstance(session);
					if(cart != null){
						buyItems = cart.getItems(true);
						deleteItems=cart.getItems(false);
						moneySave = cart.countSave();
						moneyCost = cart.cost();
						return "cart";
					}
					//6，不是从购物车跳转到的就返回到当当主界面 main.jsp
					return "main";*/
					uri = (String) session.get(Constant.URI);
					if (uri != null) {
						this.uri = uri.substring(uri.indexOf("/", 1));
						System.out.println(this.uri);
						session.remove("uri");
					}
					return "main";
				} else {
					return "verify";
				}
			}
			login_erro_msg = "登陆失败啦";
			return "login";
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

	public String getLogin_erro_msg() {
		return login_erro_msg;
	}

	public void setLogin_erro_msg(String loginErroMsg) {
		login_erro_msg = loginErroMsg;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Logger getLog() {
		return log;
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

//	public List<CartItem> getBuyItems() {
//		return buyItems;
//	}
//
//	public void setBuyItems(List<CartItem> buyItems) {
//		this.buyItems = buyItems;
//	}
//
//	public List<CartItem> getDeleteItems() {
//		return deleteItems;
//	}
//
//	public void setDeleteItems(List<CartItem> deleteItems) {
//		this.deleteItems = deleteItems;
//	}
//
//	public double getMoneyCost() {
//		return moneyCost;
//	}
//
//	public void setMoneyCost(double moneyCost) {
//		this.moneyCost = moneyCost;
//	}
//
//	public double getMoneySave() {
//		return moneySave;
//	}
//
//	public void setMoneySave(double moneySave) {
//		this.moneySave = moneySave;
//	}

}
