package org.tarena.dang.action.order;

import java.util.Random;

import org.apache.log4j.Logger;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.dao.impl.OrderDAOImpl;
import org.tarena.dang.entity.User;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.service.CartService;
import org.tarena.dang.service.impl.CartServiceImpl;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;
import org.tarena.dang.util.UUIDToken;

import com.opensymphony.xwork2.ActionContext;

public class SubmitAddress extends BaseAction{
	private Logger log = Logger.getLogger(this.getClass());
	private int address_id;
	private String receive_name;
	private String full_address;
	private String postal_code;
	private String phone;
	private String mobile;
	// 返回order_ok页面信息
	private int order_id;
	private double total_price;
	private boolean flag;

	/*public String addressOk() throws Exception{
		flag = UUIDToken.getUuidToken().isValidateToken(httpRequest);
		log.warn("......................"+UUIDToken.getUuidToken().getUUidAsUniqueStr(httpRequest)+"..........................");
		log.warn("......................"+flag+"..........................");
		if(flag){
			OrderDAO orderDao = new OrderDAOImpl();
			User user = (User)session.get(Constant.USER_KEY);
			int user_id = user.getId();
				CartService cart = CartServiceImpl.getInstance(session);
				Random random = new Random();
				order_id = random.nextInt(99999999);
				total_price = cart.cost();
				if(address_id==-1){
					orderDao.addCategoryProduct(user_id, receive_name, full_address, 
							postal_code, phone, mobile);
				}
				int order_id = orderDao.addAddress(user_id, receive_name,
						full_address, postal_code, phone, mobile, total_price);
				for(CartItem item:cart.getItems(true)){
					orderDao.addProduct(order_id, item);
				}
				cart.clear();
				return "success";
		}else{
			log.warn("。。。。。。。。。。。。。。表单重啦。。。。。。。。。。。。。。。");
			return "formToken";
			//return "invalid.token";
		}
	}*/
	
	public String addressOk() throws Exception{
		log.warn(".............EXECUTE BEGIN.............."+address_id);
		OrderDAO orderDao = new OrderDAOImpl();
		//User user = (User) session.get("user");
		User user = (User)session.get(Constant.USER_KEY);
		
		int user_id = user.getId();
		log.warn("....user_id......"+user_id+"...........");
		log.warn("....address_id......"+address_id+"...........");
			CartService cart = CartServiceImpl.getInstance(session);
			Random random = new Random();
			order_id = random.nextInt(99999999);
			total_price = cart.cost();
			if(address_id==-1){
				log.warn("...ADD  ADDRESS...");
				orderDao.addCategoryProduct(user_id, receive_name, full_address, 
						postal_code, phone, mobile);
			}
			int order_id = orderDao.addAddress(user_id, receive_name,
					full_address, postal_code, phone, mobile, total_price);
			log.warn("....address_id......"+address_id+"...........");
			for(CartItem item:cart.getItems(true)){
				orderDao.addProduct(order_id, item);
			}
			cart.clear();
			System.out.println("添加的用户"+user.getId());
			if(user!=null){
				CookieUtil.addCookie("cart"+user.getId(), cart.analyze(), response);
			}
			log.warn(".............EXECUTE END..............");
			
		return "success";
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int addressId) {
		address_id = addressId;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receiveName) {
		receive_name = receiveName;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String fullAddress) {
		full_address = fullAddress;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postalCode) {
		postal_code = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double totalPrice) {
		total_price = totalPrice;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
}
