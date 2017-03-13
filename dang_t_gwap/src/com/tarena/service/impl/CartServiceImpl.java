package com.tarena.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.service.CartService;
import com.tarena.util.Constant;
import com.tarena.util.CookieUtil;
import com.tarena.util.DAOFactory;

/**
 * 购物车cart_list.jsp的显示逻辑
 * 
 * @author soft01
 * 
 */
public class CartServiceImpl implements CartService {
	private static final long serialVersionUID = -7203518833040195267L;
	private List<CartItem> store = new ArrayList<CartItem>();

	// 无参数购造器
	public CartServiceImpl() {
		
	}

	// 创建购物车实例方法
	public static CartService getInstance(Map<String, Object> session,
			HttpServletRequest request) throws UnsupportedEncodingException {
		CartService cart = (CartService) session.get(Constant.SESSION_CART);
		if (cart == null) {
			// 如果第一次购买
			cart = (CartService) DAOFactory.getInstance("CartService");
			// 去下载浏览器中的cookie
			cart.load(CookieUtil.findCookie(Constant.SESSION_CART, request));
			// 把购物车加入session
			session.put(Constant.SESSION_CART, cart);
		}
		return cart;
	}

	/**
	 * 购买商品
	 * 
	 * @param pid
	 *            购买商品的id
	 * @return 购买成功还是失败
	 */
	public boolean add(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// 购买过
			if (item.getPro().getId() == pid) {
				item.setBuy(true);
				item.setQty(item.getQty() + 1);
				return true;
			}
		}

		try {
			// 第一次购买
			Product pro = new Product();
			ProductDAO productDAO = (ProductDAO) DAOFactory
					.getInstance("ProductDAO");
			pro = productDAO.findProductById(pid);
			CartItem item = new CartItem(1, pro, true);
			store.add(item);
		} catch (Exception e) {
			Logger logger = Logger.getLogger(CartServiceImpl.class);
			logger.error("购买商品失败", e);
		}
		return true;
	}

	/**
	 * 计算购买商品的总额
	 * 
	 * @return
	 */
	public double countCost() {
		double sum = 0;
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// 遍历store集合,统计buy=true的元素金额
			if (item.isBuy() == true) {
				sum += item.getPro().getDangPrice() * item.getQty();
			}
		}
		return sum;
	}

	/**
	 * 计算节省金额
	 * 
	 * @return
	 */
	public double countSales() {
		double sum = 0;
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// 遍历store集合,统计buy=true的元素
			if (item.isBuy() == true) {
				// 统计节省金额：(fixedPrice-dangPrice)*数量
				sum += (item.getPro().getFixedPrice() - item.getPro()
						.getDangPrice())
						* item.getQty();
			}
		}
		return sum;
	}

	/**
	 * 删除
	 * 
	 * @param pid
	 * @return
	 */
	public boolean delete(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			if (item.getPro().getId() == pid) {
				// 找到pid对应的item对象,修改buy=false
				item.setBuy(false);
			}
		}
		return true;
	}

	/**
	 * 返回购买/删除状态的集合
	 * 
	 * @param buy
	 *            true购买,false删除
	 * @return
	 */
	public List<CartItem> getItems(boolean buy) {
		List<CartItem> list = new ArrayList<CartItem>();
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// 将store 集合中buy属性等于buy参数的元素返回
			if (item.isBuy() == buy) {
				list.add(item);
			}
		}
		return list;
	}

	/**
	 * 恢复
	 * 
	 * @param pid
	 * @return
	 */
	public boolean recovery(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			if (item.getPro().getId() == pid) {
				// 找到pid对应的item对象,修改buy=true
				item.setBuy(true);
			}
		}
		return true;
	}

	/**
	 * 更新购买数量
	 * 
	 * @param pid
	 *            购买商品的id
	 * @param pnum
	 *            购买的数量
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean update(int pid, int pnum)
			throws UnsupportedEncodingException {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// pid对应的item对象,修改qty=pnum
			if (item.getPro().getId() == pid) {
				item.setQty(pnum);
				return true;
			}
		}
		return false;
	}

	/**
	 * 清空购物车逻辑
	 * 
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean clear(HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 清空Cookie
		CookieUtil.deleteCookie(Constant.SESSION_CART, response);
		store.clear();
		return true;
	}

	/**
	 * 将cart中的所有商品信息，即items集合中的数据转变成一个类似
	 * 
	 * "3,8;4,11;9,2"这样的字符串。如果集合为空，返回"0"。
	 * 
	 * @return
	 */
	public String store() {
		StringBuffer sb = new StringBuffer();
		if (store.size() == 0) {
			sb.append("0");
		} else {
			for (int i = 0; i < store.size(); i++) {
				CartItem item = store.get(i);
				sb.append(item.getPro().getId() + "," + item.getQty() + ","
						+ item.isBuy() + ";");
			}
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 依据content(类似 "3,8;4,11;9,2"这样的字符串)
	 * 
	 * 重新恢复cart中用户所购买的商品，即items集合。
	 * 
	 * @param content
	 */
	public void load(String content) {
		if (content == null || content.equals("0")) {
			return;
		}
		String[] pcs = content.split(";");
		CartItem item = null;
		for (int i = 0; i < pcs.length; i++) {
			String pc = pcs[i];
			String[] strs = pc.split(",");
			int id = Integer.parseInt(strs[0]);
			int qty = Integer.parseInt(strs[1]);
			boolean buy = Boolean.parseBoolean(strs[2]);

			ProductDAO productDAO = (ProductDAO) DAOFactory
					.getInstance("ProductDAO");
			try {
				Product pro = productDAO.findProductById(id);
				item = new CartItem();
				item.setPro(pro);
				item.setQty(qty);
				item.setBuy(buy);
				store.add(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 以下是getter and setter
	public void setStore(List<CartItem> store) {
		this.store = store;
	}

	public List<CartItem> getStore() {
		return store;
	}

}
