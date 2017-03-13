package basic.day19.reflection;
import java.lang.reflect.Constructor;
/**
 * newInstance()方法解决实例化对象问题
 * 调用有参数构造实例化对象：
	只有在操作时需要明确地调用类中的构造方法，并将参数传递进去之后才可以进行实例化操作：
	步骤：(1)通过Class类中的getConstructors()取得本类中的全部构造方法
		(2)向构造方法中传递一个对象数组进去，里面包含了构造方法中所需的各个参数
		(3)之后通过Constructor实例化对象
 */
class Person2{
	private String name;
	private int age;
	public Person2(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "姓名："+this.name+",年龄："+this.age;
	}
}
public class InstanceDemo02 {
	public static void main(String[] args) {
		Class<?> c = null;
		try{
			c = Class.forName("basic.day19.reflection.Person2");//声明Class对象
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Person2 per = null;
		Constructor<?> cons[] = null;//声明一个表示构造方法的数组
		cons = c.getConstructors();//通过反射取得全部构造
		try{
			//向构造方法中传递参数，此方法使用可变参数接收，并实例化对象
			per = (Person2)cons[0].newInstance("贾东坡",20);//因为只有一个构造，所以数组下标为0
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(per);//输出对象
		
	}
}
