package basic.day01;

public class FloatDemo {

	/**
	 * float
	 */
	public static void main(String[] args) {
		//float没有int精度高
		int max = 0x7fffffff;
		int i  = 0x7ffffff0;
		float f1 = max;
		float f2 = i;
		System.out.println(f1);//2.14748365E9
		System.out.println(f2);//2.14748365E9
		System.out.println(f2==f1);//true
		
		//double,尾数52，指数11，符号位1位，总64位。
		double x = 0.5;
		//float y = 0.5;//编译错误
		float y = 0.5f;
		//1 1.0 1D 1L 1f
		//浮点数运算不精确
		x = 3.6;
		double d = x -3D;
		System.out.println(d);//0.6000000000000001iannianjniannianniannian 
		
		System.out.println(Math.pow(2, 15));
	}

}
