package cn.itcast.factory;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.impl.BookDaoImpl;
import cn.itcast.dao.impl.CategoryDaoImpl;

public class DaoFactory {
	public static CategoryDao getCategoryDao(){
		return new CategoryDaoImpl();
	}
	
	public static BookDao getBookDao(){
		return new BookDaoImpl();
	}
}
