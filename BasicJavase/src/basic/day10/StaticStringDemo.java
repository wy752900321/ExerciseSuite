package basic.day10;

public class StaticStringDemo {

	/**
	 	“静态字符串”字符串字面量 String是输入输出时候最常用的数据
	 	类型，String的性能严重影响java的性能
	 java及其变态的优化了String
	 	1.java将字面量和常量(基本类型，String等)的运算，在编译期间执行
	 	2.java将字符串字面量和常量创建在静态池中，尽可能使用同一个对象，静态缓冲池也是在堆中。
	 	3.动态创建的字符串实例，不再静态池中分配。是新对象
	 		如：new String()  s1+s2 的结果
	 */
	public static final String S ="123ABC";
	public static final int N = 123;
	public static void main(String[] args) {
		String s = "123";
		String s1 = "123ABC";
		String s2 = "123ABC";
		System.out.println(s2==s1);
		
		String s3 = N+"ABC";//"123ABC"
		System.out.println(s2==s3);//true
		System.out.println(s3==s1);//true
		String s4 = 123 +"ABC";//"123ABC
		System.out.println(s3==s4);//true
		
		String s5 = 1+2+3+"ABC";//6ABC
		System.out.println(s4==s5);//false
		String s6 = '1'+'2'+'3'+"ABC";//,49+50+51"150ABC"
		System.out.println(s6==s5);//false
		String s7 = "1"+"2"+"3"+"ABC";
		System.out.println(s7==s1);//true
		
		String s8 = s+"ABC";//123ABC,编译期不运算
		System.out.println(s8==s1);//false
		String s9 = new String("123ABC");//123ABC
		System.out.println(s9==s1);//false
		System.out.println(s9==s8);//false
		String s10 = new String("123"+"ABC");//123ABC,new string("123	aBC zx 
		System.out.println(s10==s9);//false
	}

}
