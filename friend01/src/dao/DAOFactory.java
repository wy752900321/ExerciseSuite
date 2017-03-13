package dao;

import util.ConfigUtil;


public class DAOFactory {
	public static Object getDAOInstance(Class c){
		String className = ConfigUtil.getProperty(c.getSimpleName());
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
