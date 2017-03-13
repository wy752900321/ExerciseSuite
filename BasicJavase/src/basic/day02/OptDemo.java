package basic.day02;

/**数学运算符演示*/
public class OptDemo {
	public static void main(String[] args){
		
		//多态现象，打印
		char c = 'A';
		int i =c+1;
		System.out.println(i);//66,char+char 是数学加法
		System.out.println(c+'\n');//75
		System.out.println(c+"\n"+"测试，换行了");//A，任何数据与字符串“+”,"+"都是连接运输
		
		int a = 5;
		byte b = 6;
		int x = a+b;//会把byte转成int,现转化。
		
		b = 1;
//		b = b+b;//编译错误，b+b是按int计算的
		b = (byte)(b+b);
//		b = b+1;//编译错，b+1是int
		b = (byte)(b+1);
		
		//边界问题
		b = 2+1;//字面量的运输在编译期间优化为运算结果。
		
		//危险情况
		int max = 0x7fffffff;
		int y  = max + max +2;
		long l = max + max +2;
		l = (long)max + max +2;//先把前边的max按long算，然后与后边的max相加，按long补位
		l = max + max + 2L;
		
		//除法，整数除法是整除 /
		a = 5;
		x = a/2;
		System.out.println(x);//2
		double d = (double)a/2;
		System.out.println(d);//2.5
		System.out.println(0/5);//0
		System.out.println(1/5);//0
		
		//取余 %
		a = 5;
		x = a%3;//2
		a = -5;//负数的余数是负数
		x = a%3;//-2
		System.out.println(0%3);//0
		System.out.println(1%3);//1
		System.out.println(2%3);//2
		System.out.println(3%3);//0
		System.out.println(4%3);//1
		System.out.println(5%3);//2
		System.out.println(6%3);//0
		System.out.println(7%3);//1
		//...
		
	}
}
