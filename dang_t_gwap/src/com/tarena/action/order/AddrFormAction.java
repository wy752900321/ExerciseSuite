package com.tarena.action.order;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.dao.ItemDAO;
import com.tarena.dao.OrderDAO;
import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.Item;
import com.tarena.entity.Order;
import com.tarena.entity.ReceiveAddress;
import com.tarena.entity.User;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;
import com.tarena.util.DAOFactory;

/**
 * 把address_form.jsp的信息获取到存入数据库
 * 
 * @author soft01
 * 
 */
public class AddrFormAction extends BaseAction {
	private static final long serialVersionUID = 4734342926827189957L;
	private String receiveName;// 收件人姓名
	private String fullAddress;// 收件人地址
	private String postalCode;// 收件人邮政编码
	private String phone;// 收件人电话
	private String mobile;// 收件人手机
	private double totalPrice;
	private CartService cartService;
	private List<CartItem> buyPro;
	private int orderId;
	private int address;

	public String execute() {
		// 从session中获取User
		User user = (User) session.get("user");
		int userId = user.getId();

		// 创建收件人地址对象
		ReceiveAddress receiveAddress = new ReceiveAddress(userId, receiveName,
				fullAddress, postalCode, mobile, phone);
		// 设置添加定单和添加明细为false
		boolean addOrder = false;
		boolean addItem = false;
		try {
			addOrder = addOrder(receiveAddress);
			addItem = addItem();
		} catch (UnsupportedEncodingException e) {
			// 记录日志
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("不支持utf-8编码", e);
		}
		try {
			// 购物结束清空购物车
			cartService.clear(response);
		} catch (UnsupportedEncodingException e) {
			// 记录日志
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("不支持utf-8编码", e);
		}
		if (buyPro.size() == 0) {
			// 如果购物车的商品大小为0，链接到main.jsp
			return "main";
		} else if (addOrder && addItem) {
			// 如果添加成功，链接到order_ok.jsp
			return "success";
		} else {
			// 链接到error.jsp
			return "error";
		}
	}

	/**
	 * 添加定单
	 * 
	 * @param receiveAddress
	 *            收件人地址对象
	 * @return 返回一个boolean值
	 * @throws UnsupportedEncodingException
	 *             不支持utf-8编码
	 */
	private boolean addOrder(ReceiveAddress receiveAddress)
			throws UnsupportedEncodingException {
		// 创建定单DAO对象
		OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance("OrderDAO");
		// 创建收收人地址DAO对象
		ReceiveAddressDAO receiveAddressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		// 实例化购物车对象
		cartService = CartServiceImpl.getInstance(session, request);
		// 查看购物车中商品的总价
		totalPrice = cartService.countCost();
		// 创建定单对象
		Order order = new Order(receiveAddress.getUserId(), receiveAddress
				.getReceiveName(), receiveAddress.getFullAddress(),
				receiveAddress.getPostalCode(), receiveAddress.getMobile(),
				receiveAddress.getPhone(), totalPrice);
		try {
			// 添加定单
			orderId = orderDAO.createOrder(order);
			// 如果选择的是添加新地址
			if (address == 0) {
				// 把地址加到数据表中
				receiveAddressDAO.insert(receiveAddress);
				return true;
			}
			return true;
		} catch (Exception e) {
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("保存定单和地址的时候出了点异常", e);
			return false;
		}
	}

	private boolean addItem() throws UnsupportedEncodingException {
		// 创建购物车对象
		cartService = CartServiceImpl.getInstance(session, request);
		// 查看购物车中已经购买的商品
		buyPro = cartService.getItems(true);
		// 创建对象
		ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance("ItemDAO");
		// 对buyPro迭代
		for (int i = 0; i < buyPro.size(); i++) {
			// 把每个购物车中明细，保存
			CartItem cartItem = buyPro.get(i);
			Item item = new Item(orderId, cartItem.getPro().getId(), cartItem
					.getPro().getProductName(), cartItem.getPro()
					.getDangPrice(), cartItem.getQty(), cartItem.getPro()
					.getDangPrice()
					* cartItem.getQty());
			try {
				// 保存数据
				itemDAO.insert(item);
				// 如果插入最后一个数据时返回一个true
				if (i == buyPro.size() - 1) {
					return true;
				}
			} catch (Exception e) {
				Logger logger = Logger.getLogger(AddrFormAction.class);
				logger.error("在添加定单明细时出了一点异常", e);
				return false;
			}
		}
		return false;
	}

	// getter and setter
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public List<CartItem> getBuyPro() {
		return buyPro;
	}

	public void setBuyPro(List<CartItem> buyPro) {
		this.buyPro = buyPro;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getAddress() {
		return address;
	}

}
