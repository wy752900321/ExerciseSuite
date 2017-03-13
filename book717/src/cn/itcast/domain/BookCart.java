package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.exception.ServiceException;

/*
 购物车
 */
public class BookCart {
	private Map<String, BookItem> map = new HashMap<String, BookItem>();

	public Map<String, BookItem> getMap() {
		return map;
	}

	public void setMap(Map<String, BookItem> map) {
		this.map = map;
	}

	/**
	 * 在购物车中增加新的书籍
	 * 
	 * @param bookItem
	 */
	public void addBookItem2BookCart(BookItem bookItem) {
		if (bookItem == null) {
			throw new ServiceException("该商品不存在，不能加入到购物车");
		}
		if (bookItem.getBook() == null) {
			throw new ServiceException("该商品不存在，不能加入到购物车");
		}
		BookItem oldBookItem = map.get(bookItem.getBook().getId());

		// 在map集合不存在该书籍
		if (oldBookItem == null) {
			bookItem.setQuantity(1);
			bookItem.setTotalprice(bookItem.getBook().getPrice()*bookItem.getQuantity());
			map.put(bookItem.getBook().getId(), bookItem);
		}else{
			//存在该书籍
			oldBookItem.setQuantity(oldBookItem.getQuantity()+1);
			oldBookItem.setTotalprice(oldBookItem.getBook().getPrice()*oldBookItem.getQuantity());
		}
	}
	/**
	 * 计算总的价格
	 * @return
	 */
	public double getSumprice(){
		if(map!=null&&!map.isEmpty()){
			double sum = 0;
			for(Map.Entry<String, BookItem> em:map.entrySet()){
				BookItem bookItem = em.getValue();
				if(bookItem!=null){
					sum=sum+bookItem.getTotalprice();
				}
			}
			return sum;
		}
		return 0d;
	}
}
