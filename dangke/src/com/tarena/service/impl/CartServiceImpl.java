package com.tarena.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tarena.util.Contant;
import com.tarena.util.CookieUtil;
import com.tarena.dao.CartDAO;
import com.tarena.dao.ProductDAO;
import com.tarena.dao.impl.CartDAOImpl;
import com.tarena.dao.impl.ProductDAOImpl;
import com.tarena.entity.Product;
import com.tarena.service.CartService;

public class CartServiceImpl implements CartService {
	// 购物车实例，其实就是一个CartItem集合
	private List<CartItem> realCart = new ArrayList<CartItem>();

	private CartServiceImpl() {
	}

	public static CartService getInstance(Map<String, Object> session) {
		CartService cart = (CartService) session.get(Contant.SESSION_CART);
		if (cart == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			cart = new CartServiceImpl();
			try {
				cart.load(CookieUtil.findCookie("cart", request));
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.put(Contant.SESSION_CART, cart);
		}
		return cart;
	}

	// 添加商品
	public boolean add(int pid) {
		try {
			for (CartItem cart : realCart) {
				if (cart.getProduct()!=null&&cart.getProduct().getId() == pid&&cart.isBuy()==true) {
					cart.setCount(cart.getCount() + 1);
					return true;
				}
				if (cart.getProduct()!=null&&cart.getProduct().getId() == pid&&cart.isBuy()==false) {
					cart.setCount(1);
					cart.setBuy(true);
					return true;
				}
			}
			CartDAO cartDao = new CartDAOImpl();
			Product pro = cartDao.findProductById(pid);
			CartItem c = new CartItem(pro, 1, true);
			realCart.add(c);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 更新商品的数量
	public boolean update(int pid, int pnum) {
		for (CartItem c : realCart) {
			if (c.getProduct().getId() == pid) {
				c.setCount(pnum);
				return true;
			}
		}
		return false;
	}

	// 统计购买商品的总金额
	public double countCost() {
		double cost = 0.0;
		for (CartItem c : realCart) {
			if (c.isBuy()) {
				cost += c.getProduct().getDangPrice() * c.getCount();
			}
		}
		return cost;
	}

	// 统计节省的总金额
	public double countSave() {
		double cost = 0.0;
		for (CartItem c : realCart) {
			if (c.isBuy()) {
				cost += (c.getProduct().getFixedPrice() - c.getProduct()
						.getDangPrice())
						* c.getCount();
			}
		}
		return cost;
	}

	// 删除商品
	public boolean delete(int pid) {
		for (CartItem c : realCart) {
			if (c.getProduct().getId() == pid) {
				c.setBuy(false);
			}
		}
		return true;
	}

	// 获取购买/删除的商品
	public List<CartItem> getItems(boolean buy) {
		List<CartItem> items = new ArrayList<CartItem>();
		for (CartItem c : realCart) {
			if (c.isBuy() == buy) {
				items.add(c);
			}
		}
		return items;
	}

	// 恢复删除的商品
	public boolean recovery(int pid) {
		for (CartItem c : realCart) {
			if (c.getProduct().getId() == pid) {
				c.setBuy(true);
				return true;
			}
		}
		return false;
	}

	// 清空购物车
	public void clearCart() {
		realCart.clear();
	}
	//返回购物车中的信息
	public String store(){
		StringBuffer sb = new StringBuffer();
		if(realCart.size()==0){
			sb.append("0");
		}else{
			for(int i =0;i<realCart.size();i++){
				CartItem item =  realCart.get(i);
				sb.append(item.getProduct().getId()+","+item.getCount()+","+item.isBuy()+";");
			}
		}
		if(sb.length()>1){
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println("store........................."+sb.toString());
		return sb.toString();
	}
	//加载cookie中的购物车信息；
	public void load (String content){
		if(content==null||content.equals("0")){
			return ;
		}
		System.out.println("load........................................."+content);
		String[]strs = content.split(";");
		ProductDAO dao = new ProductDAOImpl();
		for(int i =0 ;i<strs.length;i++){
			String itemInfo = strs[i];
			String[]strs1 = itemInfo.split(",");
			try{
				Product p = dao.findProductById(Integer.parseInt(strs1[0]));
				CartItem item = new CartItem();
				item.setProduct(p);
				item.setCount(Integer.parseInt(strs1[1]));
				item.setBuy(Boolean.parseBoolean(strs1[2]));
				realCart.add(item);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("加载购物车中的信息。。。。。。。。。。。。。");
	}
}
