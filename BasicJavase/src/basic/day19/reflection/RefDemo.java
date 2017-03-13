package basic.day19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**反射API 功能 
 * 1.反射API是Java语言核心功能API，是java的底层工作机制
 * 	 在Object类上就存在支持反射API的方法(getClass())
 * 	反射API的功能
 * 		A.发现对象的类型
 * 		B.发现类型的属性，方法，构造器等
 * 		C.访问对象的属性，调用对象的方法，创建类型的实例等
 */
public class RefDemo {
	public static void main(String[] args) {
//		discovery(1);
//		discovery("1");
		Scanner s = new Scanner(System.in);
		System.out.print("输入类名");
		String name =s.nextLine();
		Object obj = create(name);
		discovery(obj);
		
		Class c  = int.class;
		System.out.println(c.getName());//int
		//一切皆对象
		//任何类型(具体类型)都是Class的实例
		//int.class,double.class,String.class,Integer.class.........都是类型的实例
		//Card.class
		//Class 的实例有3种获得方法：
		//A String.class  类名＋Class
		//B "abc".getClass()
		//C  Class.forName("java.lang.String")
		//3种方式获得的都是同一个对象
		//String.class=="abc".getClass();//返回true
		obj = create("basic.day19.reflection.RefDemo.Foo",
				new Class[]{int.class,String.class},new Object[]{5,"好"});
		discovery(obj);
		System.out.println(get(obj,"n"));
		System.out.println(call(obj,"add",new Class[]{int.class,int.class,String.class},new Object[]{5,5,"55"}));
		
	}
	/**
	 * 创建某类型的实例（调用构造器）
	 * @param className 类名
	 * @return paramTypes 参数类型列表
	 * 		如：new Class[]{int.class,String.class}表示：int,String
	 * @param params 参数列表
	 * 		如：new Object[]{5,"50"}表示：5，“50”
	 */
	public static Object create(String className,Class[] paramTypes,Object[] params){
		try{
		//找到类型
			Class cls = Class.forName(className);
		//找到构造器
			Constructor c = cls.getDeclaredConstructor(paramTypes);
		//调用构造器，创建实例
			Object obj = c.newInstance(params);
		return obj;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 创建对象
	 * 第一种，便捷是使用默认构造器创建实例
	 * @param className 类名
	 * @return 利用烟灰缸无参数构造器创建的类型实例
	 */
	public static Object create(String className){
		try{
		//反射API，的入口都是从Class实例开始
		//class.forName()是静态方法，去查找内存是否有className
		//对应的类的实例，如果没有就加载这个类，从CLASSPATH上加载
		//如果CLASSPATH上没有找到类的定义抛出：ClassNotFounException
		Class cls = Class.forName(className);
		//newInstance()会调用cls的无参数构造器创建类的实例
		Object obj = cls.newInstance();
		return obj;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		return className;
	}
	
	/**
	 * 创建某类型的实例(调用构造器)
	 */

	/**
	 * 访问某对象的属性
	 * @param obj某对象
	 * @param filedName某属性名
	 * @return 属性的值
	 */
	public static Object get(Object obj,String fileldName){
		try {
			Class cls = obj.getClass();
			Field field = cls.getDeclaredField(fileldName);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}
	
	/**
	 * 访问某对象的方法
	 * @param obj 被调用方法的对象
	 * @param method 方法名
	 * @param   paramTypes 方法参数类型列表
	 * @param params 方法参数列表
	 * @return 方法返回值
	 */
	public static Object call(Object obj,String method,Class[] paramTypes,Object[] params){
		try {
			Class cls  = obj.getClass();
			Method m = cls.getDeclaredMethod(method, paramTypes);
			//invoke:调用
			Object value = m.invoke(obj, params);//obj->this
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
		A.发现对象的类型
 * 		B.发现类型的属性，方法，构造器等
	 */
	public 	static void discovery(Object obj){
		System.out.println("反射:"+obj);
		//"月饼模子"是月饼的类型
		//月饼类型本身 也是对象 是类型的实例
		//月饼模子本身也是是模子的实例，模子相当于软件中的类,class
		//obj.getClass()方法可以获取当前对象的类型
		//这个方法在Object上定义，是java的核心方法之一
		//返回值是class类型的实例，class是类的类型
		System.out.println("发现类型：");
		Class cls  = obj.getClass();
		//cls就是硬盘上.class文件装载(class load)到内存的结果
		System.out.println(cls.getName());//类名！	
		//属性在类型上，属性的值在对象上
		//类型上有属性，具体值在对象上
		//人有性别，具体男女看对象
		//获得在类型cls上声明的属性，Field:字段，属性。因为有多个属性，所以要用数组
		System.out.println("发现属性：");
		Field[] fields = cls.getDeclaredFields();
		for(Field field:fields){
			System.out.println(
				field.getType()+" "+field.getName());//属性的类型
		}
		//Method:方法，getDeclareMethods()在类型上发现声明的方法
		//Declared : 声明的 公告的,公然的;
		System.out.println("发现方法：");
		Method[] methods = cls.getDeclaredMethods();
		for(Method method:methods){
			System.out.println(method.getReturnType());
			System.out.println(method.getName());
//			System.out.println(method.getParameterTypes());//返回的是数组，好看点写成下面的
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
		System.out.println("发现构造器：");
		//Constructor:构造器
		Constructor[] constructors = cls.getDeclaredConstructors();
		for(Constructor c :constructors){
			System.out.print(c.getName());
			System.out.println(Arrays.toString(c.getParameterTypes()));
		}
	}
}
class Foo{
	int a;
	String n;
	public Foo(){
	}
	public Foo(int a,String s){
		this.a = a;
		this.n = s;
	}
	public int add(int b,int c,String s){
		return b+c+s.charAt(0)-'0';
	}
}
