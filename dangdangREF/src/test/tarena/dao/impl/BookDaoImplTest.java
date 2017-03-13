package test.tarena.dao.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tarena.dao.IBookDao;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Category;
import com.tarena.factory.ObjectFactory;

public class BookDaoImplTest {
	IBookDao ibookDao;
	@Before
	public void setUp() throws Exception {
		ibookDao =(IBookDao)ObjectFactory.createObject("IBookDao");
	}

/*	@Test
	public void testFindBookById() {
		List<Book> books=ibookDao.findBookByCategoryId(9);
		for (Book book : books) {
			System.out.println(book.getAuthor());
		}
	
	}
*/
	
	@Test
	@Ignore
	public void testFindBookById() {
		Book book=ibookDao.findBookById(1);
   Assert.assertEquals("鲁迅", book.getAuthor());
	}
	
	
	@Test
	//@Ignore
	public void testFindCategoryByBookId() {
		Book book = new Book();
		book.setId(9);
		List<Category> cates = ibookDao.findCategoryByBookId(book);
   for (Category category : cates) {
	   			System.out.println(category.getName()+":"+category.getId());
   		}
	}
}
