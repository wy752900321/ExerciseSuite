package cn.itcast.factory;

import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.impl.CategoryDaoImpl;

public class DaoFactory {
	public static CategoryDao getCategoryDao(){
		return new CategoryDaoImpl();
	}
}
