package util;

public class DAOFactory {
	//����
		public static Object getInstance(String type){
			Object obj = null;
			//���ݽӿ�����type)�ҵ���Ӧ�����������ظýӿڶ�Ӧ��ʵ��������� 
			String className = ConfigUtil.getProperty(type);
			try {
				obj = Class.forName(className).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}
}
