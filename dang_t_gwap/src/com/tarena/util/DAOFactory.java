package com.tarena.util;

import java.io.Serializable;

/**
 * 工厂类
 * 
 * @author soft01
 * 
 */
public class DAOFactory implements Serializable {
	private static final long serialVersionUID = -396116908068638655L;

	/**
	 * 根据传进来的类型为此对象创建实例
	 * 
	 * @param type
	 *            传入的类型
	 * @return 返回的是一个实例对象
	 */
	public static Object getInstance(String type) {
		Object obj = null;
		// 根据传入的类型从配置文件读取value
		String className = ConfigUtil.getValue(type);
		try {
			// 为此value也就是类名创建实例
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return obj;
	}
}
