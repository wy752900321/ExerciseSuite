package util;

public class DAOFactory {
	//工厂
		public static Object getInstance(String type){
			Object obj = null;
			//依据接口名（type)找到对应的类名，返回该接口对应的实现类的名称 
			String className = ConfigUtil.getProperty(type);
			try {
				obj = Class.forName(className).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}
}
