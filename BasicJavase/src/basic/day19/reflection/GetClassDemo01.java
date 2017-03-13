package basic.day19.reflection;
/**
 * Class类本身没有定义构造方法，所以如果要使用则首先必须通过forName()
 * 方法实例化对象，也可以使用“类.class”或“对象.getClass()”方法实例化
 */
public class GetClassDemo01 {
	public static void main(String[] args) {
		Class <?> c1 = null;//指定泛型
		Class <?> c2 = null;
		Class <?> c3 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.X");//最常用的形式
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		c2 = new X().getClass();//通过Object类中的方法实例
		c3 = X.class;//通过类.class实例化
		System.out.println("类名称："+c1.getName());//得到类的名称
		System.out.println("类名称："+c2.getName());
		System.out.println("类名称："+c3.getName());
	}
}	
class X{}