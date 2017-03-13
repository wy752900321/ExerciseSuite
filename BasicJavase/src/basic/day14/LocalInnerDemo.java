package basic.day14;

import java.util.Comparator;
import java.util.Arrays;

/**局部内部类*/
public class LocalInnerDemo {
	public static void main(String[] args) {
		int a=5;
		final int b = 8;
		class Koo{//局部内部类，在方法中定义,在方法内部可见
			public void test(){
//				System.out.println(a);//编译错误，a变量不是final的
				System.out.println(b);//局部内部类只能访问fianl局部变量
			}
		}
		Koo koo = new Koo();
		koo.test();//8
		
		//局部内部类的应用
		final int dir = -1;//变量由小到大－1，变量由大到小
		class ByLength implements Comparator<String>{
			public int compare(String o1,String o2){
//				return o1.length()-o2.length();
				return dir*(o1.length()-o2.length());
			}
		}
		String[] names = {"Andy","Tom","Jerry"};
		Arrays.sort(names,new ByLength());
		System.out.println(Arrays.toString(names));
	}
}
