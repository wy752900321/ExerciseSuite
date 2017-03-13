package basic.day19.agent;
/**
 *从结果中可以 发现，默认的ClassLoader就是AppClassLoader。在开发中用户也可以通过继承ClassLoader类来实现
 *自己的类加载器，但是这样做的意义不大
 */
class Person{}
public class ClassLoaderDemo {
	public static void main(String[] args) {
		Person stu = new Person();//实例化子类对象
		System.out.println("类加载器："+stu.getClass().getClassLoader().getClass().getName());
	}
}
