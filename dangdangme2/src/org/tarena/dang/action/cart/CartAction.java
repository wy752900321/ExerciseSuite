package org.tarena.dang.action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.service.CartService;
import org.tarena.dang.service.impl.CartServiceImpl;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

import com.opensymphony.xwork2.ActionContext;

public class CartAction extends BaseAction {
	private Logger log = Logger.getLogger(this.getClass());
	public int id;// 接收用户要购买的产品ID
	private boolean ok;// 用于ajar请求的json响应，同时判断用户的购物车是否为空
	private List<CartItem> buyItems;//要购买的商品集合
	private List<CartItem> deleteItems;//从购物车里删除的商品集合
	private int pnum;//更新商品的数量
	private double moneyCost;//实际消费金额
	private double moneySave;//节省金额
	
	

	/**
	 * 添加商品到购物车
	 * @return
	 */
	public String addCart() throws Exception {
		log.warn("...............addCart() Begin............");
		// 将商品条目对象添加到购物车(cart)
		// 首先从session中取cart对象,获取当前用户session绑定的cart响应
		CartService cart = CartServiceImpl.getInstance(session);
		log.warn("...addCart()->cart的值：.............."+cart+".................");
		// 接下来，调用cart对象的add方法
		ok = cart.add(id);
		log.warn("....ok = cart.add(id)＝＞OK的值：............."+ok+".................");
		// 将cart中的数据以cookie的形式备份到客户端
		User user =(User) ActionContext.getContext().getSession().get(Constant.USER_KEY);
		
		if(user!=null){
			CookieUtil.addCookie("cart"+user.getId(), cart.analyze(), response);
		}
		log.warn("....addCart() End................");
		return "addSuccess";
	}
	/**
	 * 删除购物车
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String deleteCart() throws UnsupportedEncodingException{
		log.warn(".....deleteCart Begin.....");
		CartService cart = CartServiceImpl.getInstance(session);
		/*if(cart.delete(id)){
			CookieUtil.addCookie("cart", cart.analyze(), response);
		}*/
		cart.delete(id);
		User user =(User) ActionContext.getContext().getSession().get(Constant.USER_KEY);
		if(user!=null){
			CookieUtil.addCookie("cart"+user.getId(), cart.analyze(), response);
		}
		
		log.warn(".....showCart End....");
		return "deleteSuccess";
	}
	/**
	 *  更新购物车中某件商品数量
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String updateCart() throws UnsupportedEncodingException{
		log.warn("........updateCart Begin..........");
		CartService cart  = CartServiceImpl.getInstance(session);
		if(cart.update(id, pnum)){
			
			User user =(User) ActionContext.getContext().getSession().get(Constant.USER_KEY);
			if(user!=null){
				CookieUtil.addCookie("cart"+user.getId(), cart.analyze(), response);
			}
			log.warn(".......updateCart End......");
			//showCart()不能在这里回显，我们在用的时候直接在struts-cart.xml中控制逻辑的关系
			//不应该在这里出现业务逻辑的调用，因为由xml文件控制
			//showCart();//更改数量回显,如果没有，回显Cookie时数量为1
			return "updateSuccess";
		}else{
			//showCart();
			return "error";
		}
	}
	/**
	 * 恢复
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String recoveryCart() throws UnsupportedEncodingException{
		log.warn("........recoveryCart Begin..........");
		CartService cart = CartServiceImpl.getInstance(session);
		cart.recovery(id);
	
		User user =(User) ActionContext.getContext().getSession().get(Constant.USER_KEY);
		if(user!=null){
			CookieUtil.addCookie("cart"+user.getId(), cart.analyze(), response);
		}
		log.warn("........recoveryCart End..........");
		//showCart();
		return "recoverySuccess";
	}
	/**
	 * 显示购物车或显示订单信息
	 * @return
	 */
	public String showCart(){
		log.warn("...................showCart Begin..........................");
		CartService cart = CartServiceImpl.getInstance(session);
		buyItems = cart.getItems(true);
		log.warn("......."+buyItems+"..........");
		deleteItems=cart.getItems(false);
		log.warn("......."+deleteItems+".......");
		moneyCost = cart.cost();
		log.warn("......."+moneyCost+".......");
		moneySave = cart.countSave();
		log.warn("......"+moneySave+".........");
		log.warn("...................showCart End................................");
		return "showSuccess";
	}
	/**
	 * 结算时：如果购物车为空，就返回购物车界面，并给出提示信息！
	 * @return
	 */
	public String showOrderInfo(){
		CartService cart = CartServiceImpl.getInstance(session);
		if(cart==null||cart.getItems(true).size()==0){
			ok = false;
			showCart();
			return "cart";
		}
		ok=true;
		showCart();
		return "showCartSuccess";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
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
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public double getMoneyCost() {
		return moneyCost;
	}
	public void setMoneyCost(double moneyCost) {
		this.moneyCost = moneyCost;
	}
	public double getMoneySave() {
		return moneySave;
	}
	public void setMoneySave(double moneySave) {
		this.moneySave = moneySave;
	}
}
