package basic.day19.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**取得全部构造方法3 使用MOdifier还原修饰符
 * 从2中可以知道取得权限时却发现返回的是一个数字而不是public，这是因为在整个java中对于方法的修饰符是使用
 * 一定的数字表示出来的，而如果要把这个数字还原成用户可以看懂的关键字，则必须依靠Modifier类完成，此类定义
 * 在java.lang.refect包中。直接使用Modifier类的以下方法即可还原修饰符：
 * 	public static String toString(int mod)
 */
public class GetConstructorDemo03 {
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
			int mod = con[i].getModifiers();//取出权限
			System.out.print(Modifier.toString(mod)+" ");//还原权限
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
