package test;

import bean.Cart;
import bean.CartItem;
import entity.Computer;

public class TestCart {
	public static void main(String[] args) {
		Cart cart = new Cart();
		//测试1：store方法
		Computer c = new Computer("x200","x200.jpg","good",2000);
		c.setId(1);
		CartItem item = new CartItem();
		item.setC(c);
		item.setQty(2);
		cart.add(item);
		
		Computer c2 = new Computer("x200","x200.jpg","good",2000);
		CartItem item2 = new CartItem();
		item2.setC(c2);
		item.setQty(22);
		cart.add(item2);
		String content = cart.store();
		System.out.println(content);
		
		//测试：load方法
		String content1 = "1,3;2,11;3,8";
		cart.load(content1);
		System.out.println(cart.list().size());
	}
}
