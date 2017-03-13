package basic.day19.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *	利用以上方法取得一个类中的全部方法定义 
 */
public class GetMethodDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.Person");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Method m[] = c1.getMethods();//取得全部的方法
		for(int i=0;i<m.length;i++){
			Class<?> r = m[i].getReturnType();//得到方法的返回值类型
			Class<?> p[] = m[i].getParameterTypes();//得到全部的参数类型
			int xx = m[i].getModifiers();//得到方法的修饰符
			System.out.print(Modifier.toString(xx)+" ");//还原修饰符
			System.out.print(r.getName()+" ");//得到方法名称
			System.out.print(m[i].getName());//取得方法名称
			System.out.print("(");
			for(int x=0;x<p.length;x++){
				System.out.print(p[x].getName()+""+"arg"+x);
				if(x<p.length-1){//判断是否输出","
					System.out.print(",");
				}
				Class<?> ex[] = m[i].getExceptionTypes();//得到全部的异常抛出
				if(ex.length>0){//判断是否有异常
					System.out.print(") throws ");
				}else{
					System.out.print(") ");
				}
				for(int j=0;j<ex.length;j++){
					System.out.print(ex[j].getName());//输出异常信息
					if(j<ex.length-1){//判断是否输出","
						System.out.print(",");//输出","
					}
				}
				System.out.println();//换行
			}
			
		}
	}
}
