package test.tarena.dao.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tarena.dao.ICategoryDao;
import com.tarena.entity.exet.Category;
import com.tarena.entity.exet.Product;
import com.tarena.factory.ObjectFactory;

public class CategoryDaoImplTest {
	private ICategoryDao icategoryDao;

	@Before
	public void setUp() throws Exception {
		icategoryDao = (ICategoryDao) ObjectFactory
				.createObject("ICategoryDao");
	}

	@Test
	@Ignore
	public void testFindAllCategory() {
		List<Category> categorys = icategoryDao.findAllCategory();
		Assert.assertEquals(43, categorys.size());
	}

	
}
