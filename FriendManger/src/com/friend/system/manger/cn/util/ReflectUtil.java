package com.friend.system.manger.cn.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
	/**
	 * 
	 * @param object
	 * @param methodName
	 * @param paramTypes
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object call(Object object,String methodName,Class[] paramTypes,Object[] params){
		Class<? extends Object> cls = object.getClass();
		Object result = null;
		Method method;
		try {
			method = cls.getDeclaredMethod(methodName, paramTypes);
			result = method.invoke(object, params);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param object
	 * @param methodName
	 * @return
	 */
	public static Object call(Object object,String methodName){
		return call(object, methodName, new Class[]{}, new Object[]{});
	}
	 /**
	  * 
	  * @param className
	  * @param paramTypes
	  * @param params
	  * @return
	  */
	@SuppressWarnings("unchecked")
	public static Object createObject(String className,Class[] paramTypes,Object[] params){
		Object result = null;
		Class<? extends Object> cls = null;
		Constructor<?> constructor = null;
		try {
			cls = Class.forName(className);
			constructor = cls.getConstructor(paramTypes);
			result = constructor.newInstance(params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param className
	 * @return
	 */
	public static Object createObject(String className){
		return createObject(className,new Class[]{},new Object[]{});
	}
}
