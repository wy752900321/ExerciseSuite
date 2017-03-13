package basic.day01;

public class trouble01 {

	/**
	 * 问题待处理
	 */
	public static void main(String[] args) {
		//为什么10就错了，9就是可以的
//		System.out.println((int)'10');//Invalid character constant！无效的字符常量
		
		/*
		 * 强制类型转换(显示类型转换）需求明确处理，是按照反方向，进行的转换，
		 * 这种转换会溢出，或者损失精度。要注意数据的范围
		 */
	/*	int z = 128+256;// 00000000 00000000 00000001 10000000 
		 byte z2 = (byte)z;
		 System.out.println(z2);//-128
		 long z3=0xf80000000L;
		 int z4 = (int)z3;
		 System.out.println(z4);//负数,-2147483648
		 z3 = 8;
		 int d = (int)z3;
		 System.out.println(d);//8
*/		 float pi = (float)3.1415926535;//损失精度
		 System.out.println(pi);//3.1415927
		 char c = '0';
		 char z5 = (char)(c+2);
		 System.out.println(z5);//2

		 
		 //long型怎么处理，下边怎么变成正数了
			int max = 0x7fffffff;
			System.out.println(max);//2147483647
			long y = max +1;
			System.out.println(y);//-2147483648
			y = max +  1L;
			System.out.println(y);//2147483648
			
			
			//System.out.println(Integer.toHexString(y));//编译错
			System.out.println(Long.toHexString(y));//80000000
			System.out.println(Long.toHexString(-1));//16个f
			System.out.println(Integer.toHexString(-1));//8个f
//			System.out.println(Byte.toHexString(-1));//编译错误。没有方法Byte.toHexString();
	}

}
