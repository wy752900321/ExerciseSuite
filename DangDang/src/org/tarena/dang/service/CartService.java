package org.tarena.dang.service;

import java.util.List;

public interface CartService {
	/**
	 * @param pid  product的ID
	 */
	public boolean add(int pid) throws Exception;
	/**
	 * 更改数量
	 * @param pid	产品ID
	 * @param qty	数量
	 */
	public boolean update(int pid,int qty);
	/**
	 * 删除
	 * @param pid 商品ID
	 */
	public boolean delete(int pid);
	/**
	 * 恢复
	 * @param pid 商品ID
	 */
	public boolean recovery(int pid);
	/**
	 * 得到所有购买商品
	 * @return	
	 */
	//public List<CartItem> getBuyPros();
	/**
	 * 得到所有己删除商品
	 * @return
	 */
	public List<CartItem> getItems(boolean buy);
	/**
	 * 计价
	 * @return
	 */
	public double cost();
	/**
	 * 
	 * @return
	 */
	public double countSave();
	/**
	 * 清空
	 */
	public void clear();
	/**
	 * 用于Cookie，处理关闭浏览器后，定单消失情况。analyze(),revert()
	 * items集合中的数据转变成一个	类似"3,8;4,11;9,2"这样的字符串。
	 * analyze[ˊænәlaiz] v. 分析,分解;
	 */
	public String analyze();
	/**
	 * revert[riˊvәːt]v. 恢复,复归,回到;
	 * 还原类似"3,8;4,11;9,2"这样的字符串。
	 * @param content	由clear()方法产生的字符串
	 */
	public void revert(String content);
}
