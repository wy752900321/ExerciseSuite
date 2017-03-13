package test.tarena.biz.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tarena.biz.IBookServ;
import com.tarena.entity.exet.Category;
import com.tarena.factory.ObjectFactory;

public class BookServImplTest {

	IBookServ ibookServ;
	@Before
	public void setUp() throws Exception {
		ibookServ=(IBookServ)ObjectFactory.createObject("IBookServ");
	}

	@Test
	@Ignore
	public void testShowAllCategory() {
		List<Category> categorys=ibookServ.showAllCategory();
		for (Category category : categorys) {
			System.out.println("父："+category.getName());
			List<Category> categoryChild=category.getCateChild();
			for (Category category2 : categoryChild) {
				System.out.println("子："+category2.getName());
			}
		}
	}

	
}
