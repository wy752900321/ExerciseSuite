package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Item;
import com.tarena.entity.exet.Order;

public interface IOrderDao {

	//插入订单信息
	int addOrder(Order order);
	//插入订单项
	int addOrderItem(Item item);
	// select * from d_book,d_item where d_book.id=d_item.product_id and d_item.product_id in(select id from d_product)group by product_name order by sum(product_num) desc;
	List<Book> findBookByCategoryId(Page page);
}
