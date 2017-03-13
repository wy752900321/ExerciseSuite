package com.tarena.factory;

import com.tarena.util.file.Config;



public class ObjectFactory {

	/**
	 * 开发原则: 不要依赖与实现，应该依赖抽象(接口、抽象)
	 */

	public static Object createObject(String className) {
		Object obj = null;
		try {
			String clazz = Config.getString(className);
			obj = Class.forName(clazz).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
