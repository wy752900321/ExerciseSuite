package basic.day19.reflection;
/**取得所实现的全部接口
 *	要取得一个类所实现的全部接口，则必须使用Class类中的getInterfaces()方法.定义如下：
		public Class[] getInterface()
	getInterface()返回一个Class类的对象数组，之后直接利用Class类中的getName()方法输出即可
 */
public class GetInterfaceDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//声明Class对象
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//实例化Class对象
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Class<?> c[] = c1.getInterfaces();//取得实现的全部接口
		for(int i=0;i<c.length;i++){
			System.out.println("实现的接口名称："+c[i].getName());//输出流接口名称
		}
	}
}
