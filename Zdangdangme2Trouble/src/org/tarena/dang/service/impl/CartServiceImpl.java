package org.tarena.dang.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.tarena.dang.dao.CartDAO;
import org.tarena.dang.dao.impl.CartDAOImpl;
import org.tarena.dang.entity.Product;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

public class CartServiceImpl implements CartService {
	private Logger log = Logger.getLogger(this.getClass());
	// 购物车实例，其实就是一个CartItem集合
	private List<CartItem> items = new ArrayList<CartItem>();
	private List<CartItem> dItem = new ArrayList<CartItem>();
	private CartDAO cartDAO = new CartDAOImpl();

	private CartServiceImpl() {

	}

	// 获取当前用户session绑定的cart对象
	public static CartService getInstance(Map<String, Object> session) {
		CartService cart = (CartService) session.get(Constant.CART_KEY);
		if (cart == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			cart = new CartServiceImpl();
			// 尝试查找名叫cart的cookie，恢复之前购买的商品数据
			try {
				System.out.println("恢复Cart");
				cart.revert(CookieUtil.findCookie("cart", request));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			session.put(Constant.CART_KEY, cart);
		}
		return cart;
	}

	@Override
	public boolean add(int pid) {
		try {
			// 判断是否购买过
			// 如果购买过，则不可再购
			// 如果未购买过,创建item对象,添加到items
			for (CartItem cart : items) {
				if (cart.getPro() != null && cart.getPro().getId() == pid
						&& cart.isBuy() == true) {
					cart.setQty(cart.getQty() + 1);
					return true;
				}
				if (cart.getPro() != null && cart.getPro().getId() == pid
						&& cart.isBuy() == false) {
					cart.setQty(1);
					cart.setBuy(true);
					return true;
				}
			}
			CartDAO cartDao = new CartDAOImpl();
			Product pro = cartDao.findProductByPid(pid);
			CartItem c = new CartItem(pro, 1, true);
			items.add(c);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public double cost() {
		double cost = 0.0;
		// 遍历items集合,统计buy=true的元素金额
		for (CartItem c : items) {
			if (c.isBuy()) {
				cost += c.getPro().getDang_price() * c.getQty();
			}
		}
		return cost;
	}

	@Override
	// 统计节省的总金额
	public double countSave() {
		double cost = 0.0;
		for (CartItem c : items) {
			if (c.isBuy()) {
				cost += (c.getPro().getFixed_price() - c.getPro()
						.getDang_price())
						* c.getQty();
			}
		}
		return cost;
	}

	@Override
	public boolean delete(int pid) {
		System.out.println(items.size());
		CartItem c = null;
		for (CartItem cart : items) {
			if (cart.getPro().getId() == pid) {
				dItem.add(cart);
				cart.setBuy(false);
				/*
				 * c = cart;//必须通过引入，不能在迭代时删除,然后在循环外边删除。
				 * 不然有java.util.ConcurrentModificationException
				 */
				// boolean b = items.remove(cart);
				c = cart;
				log.warn("delete??");
			}
			// log.warn("循环");
		}
	
		
		log.warn("return");
		return true;
	}

	@Override
	public List<CartItem> getBuyPros() {
		return items;
	}

	// 获取购买/删除的商品
	@Override
	public List<CartItem> getDeletePros() {
		System.out.println(dItem.size() + "size");
		return dItem;
	}

	@Override
	public void recovery(int pid) {
		log.warn(".........recovery..........");
		for (CartItem cart : dItem) {
			if (pid == cart.getPro().getId()) {
				cart.setBuy(true);
				boolean b = items.add(cart);
				log.warn(b);
				dItem.remove(cart);
				return;
			}
		}
	}

	@Override
	public boolean update(int pid, int qty) {
		for (CartItem cart : items) {
			if (cart.getPro().getId() == pid) {
				cart.setQty(qty);
				return true;
			}
		}
		return false;
	}

	/**
	 * 将cart中的所有商品信息，即items集合中的数据转变成一个 类似"3,8,1;4,11,0;9,2"这样的字符串。 如果信息为空，返回“0”。
	 * 
	 * @return
	 */
	@Override
	public String analyze() {
		StringBuffer sb = new StringBuffer();
		if (items.size() == 0) {
			sb.append("0");
		} else {
			for (int i = 0; i < items.size(); i++) {
				CartItem item = items.get(i);
				if (item.isBuy()) {
					sb.append(item.getPro().getId() + "," + item.getQty() + ","+"1"+";");
				}else{
					sb.append(item.getPro().getId() + "," + item.getQty() + ","+"0"+";");
				}
				
			}
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	@Override
	public void clear() {
		items.clear();

	}

	/**
	 * 依据content(类似"3,8;4,11;9,2"这样的字符串) 重新恢复cart中用户所购买的商品，即items集合。
	 * 
	 * @param content
	 */
	@Override
	public void revert(String content) {
		if (content == null || content.equals("0")) {
			System.out.println("000000");
			return;
		}
		String[] pcs = content.split(";");
		for (int i = 0; i < pcs.length; i++) {
			String pc = pcs[i];
			String[] strs = pc.split(",");
			// long pid = Long.parseLong(strs[0]);
			int pid = Integer.parseInt(strs[0]);
			int qty = Integer.parseInt(strs[1]);
			int buy = Integer.parseInt(strs[2]);
			CartDAO dao = new CartDAOImpl();
			try {
				Product pro = dao.findProductByPid(pid);
				CartItem item = new CartItem();
				if(buy==1){
					item.setPro(pro);// 把Computer对象添加到CartItem中
					item.setQty(qty);
					item.setBuy(true);
					items.add(item);// item放入集合
				}else{
					item.setPro(pro);// 把Computer对象添加到CartItem中
					item.setQty(qty);
					item.setBuy(false);
					dItem.add(item);
				}
				System.out.println(item.getQty() );
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	
}
