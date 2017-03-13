package basic.day19.reflection;

import java.lang.reflect.Constructor;

/**取得全部构造方法2
 * 除了1中的方法，我们也可以自己手工拼凑出信息。
 * 
 * 此处使用了Construtor类，表示构造方法。常用方法如下：
	public int getMedifiers()	得到构造方法的修饰符
	public String getName()	得到构造方法的名称
	public Class<?>[]getParameterType()得到构造方法中参数的类型
	pubic String toString()  返回此构造方法的信息
	public T newInstance(Object...initrgs)throws InstantiationException,
		IllegalAccessException,IllegalArgumentException,InvocationTargetException
		向构造方法中传递参数，实例化对象
 */
public class GetConstructorDemo02 {
	public static void main(String[] args) {
		Class<?> c1 = null;//声明Class对象
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//实例化Class对象
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Constructor<?> con[] = c1.getConstructors();//得到全部构造
		for(int i=0;i<con.length;i++){//循环输出
			Class<?> p[] = con[i].getParameterTypes();//列出构造中的参数类型
			System.out.println("构造方法：");
			System.out.print(con[i].getModifiers()+" ");//取出权限
			System.out.print(con[i].getName());//输出构造 方法名称
			
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.print(p[j].getName()+" arg"+i);//打印参数
				
				if(j<p.length-1){//判断是否要输出","
					System.out.print(",");
				}
			}
			System.out.println("){}");//输出"){}"
		}
	}
}
