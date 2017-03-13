package basic.day19.reflection;
/**得到父类
 *取得父类：
	一具类可以实现多个接口，但是只能继承一个父类，所以如果要取得一个类的父类，可以直接使用Class类中的getSuperclass()方法。
	此方法定义如下：	public Class<? super T>getSuperclass()
	getSuperclass()返回的是Class实例，和之前得到一个接口一样，可以通过getName()方法取得名称  
 */
public class GetSuperClassDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//声明Class对象
		try{
			c1 = Class.forName("basic.day19.reflection.Person");//实例化Class对象
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Class<?> c2 = c1.getSuperclass();//取得父类
		System.out.println("父类名称："+c2.getName());
	}
}
