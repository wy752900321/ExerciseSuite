package basic.day06;

public class MethodDemo {

	/**
	 * 涉及到方法重载的问题
	 * 如下所示打印出不同的结果，是因为根据参数不同，调用了 
	 * System.out.println()不同的重载方法。
	 */
	public static void main(String[] args) {
		char[] chs = {'A','B','C'};
		int [] ary = {'A','B','C'};
		//char数组打印的是字符串
		System.out.println(chs);//ABC,println(char[])
		//int数组打印的是地址
		System.out.println(ary);//[I@42e816,println(Object)
		//打印int数组toString()方法的返回值
		System.out.println(ary.toString());//[I@42e816
		//打印字符
		System.out.println('A');//A,println(char)
		//打印数字
		System.out.println(65);//65,println(int)
	}

}
