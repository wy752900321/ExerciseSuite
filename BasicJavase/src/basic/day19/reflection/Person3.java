package basic.day19.reflection;
/**
 *反射操作
 */
interface China{				//定义接口
	public static final String NATIONAL = "China";//定义全局常量
	public static final String AUTHOR = "贾东坡";
	public void sayChina();//定义无参的抽象方法
	public String sayHello(String name,int age);//定义有参的抽象方法
}
public class Person3 implements China {
	private String name;
	private int age;
	public Person3(){			//声明无参数构造
	}
	public Person3(String name){	//声明有一个参数的构造方法
		this.name=name;
	}
	public Person3(String name,int age){	//声明有两个参数的构造方法
		this(name);
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
	public void sayChina() {	//覆写方法输出信息
		System.out.println("作者："+AUTHOR+",国籍："+NATIONAL);
	}
	public String sayHello(String name, int age) {//覆写方法，返回信息
		return name+",你好！我今年"+age+"岁了！";
	}
}
