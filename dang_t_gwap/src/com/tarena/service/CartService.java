package com.tarena.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.tarena.service.impl.CartItem;
/**
 * 购物车cart_list.jsp的显示逻辑
 * @author soft01
 *
 */
public interface CartService {

	/**
	 * 购买商品
	 * 
	 * @param pid
	 *            购买商品的id
	 * @return 购买成功还是失败
	 */
	public boolean add(int pid);

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
			throws UnsupportedEncodingException;

	/**
	 * 删除
	 * 
	 * @param pid
	 * @return
	 */
	public boolean delete(int pid);

	/**
	 * 恢复
	 * 
	 * @param pid
	 * @return
	 */
	public boolean recovery(int pid);

	/**
	 * 计算购买商品的总额
	 * 
	 * @return
	 */
	public double countCost();

	/**
	 * 计算节省金额
	 * 
	 * @return
	 */
	public double countSales();

	/**
	 * 返回购买/删除状态的集合
	 * 
	 * @param buy
	 *            true购买,false删除
	 * @return
	 */
	public List<CartItem> getItems(boolean buy);

	/**
	 * 清空购物车逻辑
	 * 
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean clear(HttpServletResponse response)
			throws UnsupportedEncodingException;

	/**
	 * 依据content(类似 "3,8;4,11;9,2"这样的字符串)
	 * 
	 * 重新恢复cart中用户所购买的商品，即items集合。
	 * 
	 * @param content
	 */
	public void load(String content);

	/**
	 * 将cart中的所有商品信息，即items集合中的数据转变成一个类似
	 * 
	 * "3,8;4,11;9,2"这样的字符串。如果集合为空，返回"0"。
	 * 
	 * @return
	 */
	public String store();
}
