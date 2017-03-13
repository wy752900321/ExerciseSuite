package util;

/**
 * 工厂类
 * @author tarena
 *
 */
public class DAOFactory {
	//type是一个接口名
	public static Object getInstance(String type){
		Object obj = null;
		//依据接口名(也就是type)，查询dao.properties文件，
		//找到对应的实现类的名称
		String className = ConfigUtil.getValue(type);
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	
}
