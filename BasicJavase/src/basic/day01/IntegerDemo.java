package basic.day01;

public class IntegerDemo {

	/**
	 * byte int 
	 */
	public static void main(String[] args) {
		//默认的“整数字面量”是int类型
		//整数字面量在不超过byte范围时候可以给byte变量赋值
		int i = 5;//i是变量，5是字面量（直接量）
		byte b = 127;
//		b = 128;//编译错误，超过范围
		b = -128;
		//b = -129;//编译错误
		b = 0x7f;
//		b = 0x00000080;//cannot convert from int to byte
		System.out.println(0xffffff80);//-128
		b = 0xffffff80;
		b = 0xfffffff6;//-10
//		b = i;//编译错误，“整数变量”不能给byte变量赋值！
		
		long l = 0x7fffffffffffffffL;
		//以l/L后缀的字面量是long类型 
		System.out.println(l);
		
		long x = 0xf;
		x = -1;//自动的发生符号位扩展现象
		System.out.println(x);//-1
		b = -1;
		x = b;//自动的发生符号位扩展现象
		System.out.println(b);//-1
		
		short s = 5;
		//byte short 按照int运算
		short k = (short)(s + s);
		
		int max = 0x7fffffff;
		long y = max +1;
		System.out.println(y);//-2147483648
		y = max +  1L;
		System.out.println(y);//2147483648
		
		
		
//		System.out.println(Integer.toHexString(y));//编译错
		System.out.println(Long.toHexString(y));//80000000
		System.out.println(Long.toHexString(-1));//16个f
		System.out.println(Integer.toHexString(-1));//8个f
//		System.out.println(Byte.toHexString(-1));//编译错误。没有方法Byte.toHexString();
		/*
		 * 掩码
		 */
		byte min  =-128;
		System.out.println(Integer.toHexString(min));//ffffff80
		System.out.println(Integer.toHexString(min &  0xff));//80
		//10000000 byte -128
		//11111111 11111111 11111111 10000000 -128
		//00000000 00000000 00000000 11111111 0xff	mask
		//&---------------------------------------
		//00000000 00000000 00000000 10000000 0x80
		
		short n = -32768;
		System.out.println(Integer.toHexString(n));//ffff8000
		System.out.println(Integer.toHexString(n & 0xffff));//8000
		
		/*
		 * 强制类型转换，是按照反方向，进行转换，会溢出，或者损失精度。
		 */
		int z = 128+256;// 00000000 00000000 00000001 10000000 
		 byte z2 = (byte)z;
		 System.out.println(z2);//-128
		 long z3=0xf80000000L;
		 int z4 = (int)z3;
		 System.out.println(z4);//负数,-2147483648
		 z3 = 8;
		 int d = (int)z3;
		 System.out.println(d);//8
		 float pi = (float)3.1415926535;//损失精度
		 System.out.println(pi);//3.1415927
		 char c = '0';
		 char z5 = (char)(c+2);
		 System.out.println(z5);//2
		

	}
}
