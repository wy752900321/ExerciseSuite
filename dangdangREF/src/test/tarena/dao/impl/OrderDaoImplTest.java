package test.tarena.dao.impl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.tarena.dao.IOrderDao;
import com.tarena.dao.impl.OrderDaoImpl;
import com.tarena.entity.exet.Order;

public class OrderDaoImplTest {
IOrderDao iorderDao=null;
	@Before
	public void setUp() throws Exception {
		iorderDao=new OrderDaoImpl();
	}

	@Test
	public void testAddOrder() {
		Order order=new Order();
		order.setReceiveName("小明");
		order.setFullAddress("北京");
		order.setMobile("12312564");
		order.setOrderDesc("good");
		order.setOrderTime(System.currentTimeMillis());
		order.setPhone("56325");
		order.setPostalCode("524312");
		order.setStatus(1);
		order.setTotalPrice(4315.45);
		order.setUserId(49);
		int orderId=iorderDao.addOrder(order);
		Assert.assertEquals(10, orderId);
	}

}
