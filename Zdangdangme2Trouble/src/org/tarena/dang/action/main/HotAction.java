package org.tarena.dang.action.main;

import java.util.List;
/**
 	 select dp.*
		 from d_item item 
		 join d_product dp on(item.product_id=dp.id)
		 group by item.product_id
		 order by sum(item.product_num) desc
		 limit 3;
 */
import org.tarena.dang.entity.Product;

public class HotAction {
	private List<Product> hots;
}
