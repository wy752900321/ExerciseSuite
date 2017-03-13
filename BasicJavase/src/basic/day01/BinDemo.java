package basic.day01;

public class BinDemo {
	public static void main(String[] args){
		int i = -1;//11111111 11111111 11111111 11111111
		System.out.println(i);//-1
		i = 10;//00000000 00000000 00000000 00001010
		System.out.println(i);//10,将i的补码转化为10进制字符串显示
		System.out.println(Integer.toBinaryString(i));//1010
		
		System.out.println(Integer.toBinaryString(-128));//11111111 11111111 11111111 10000000
		System.out.println(Integer.toBinaryString(-127));//11111111 11111111 11111111 10000001
		System.out.println(Integer.toBinaryString(-126));//11111111 11111111 11111111 10000010
		System.out.println(Integer.toBinaryString(-125));//11111111 11111111 11111111 10000011
		//...
		System.out.println(Integer.toBinaryString(-10));//11111111111111111111111111110110
		System.out.println(Integer.toBinaryString(-10+1));//111111111111111111111111110111
		System.out.println(Integer.toBinaryString(-9));//111111111111111111111111111110111
		System.out.println(Integer.toBinaryString(-8));//11111111111111111111111111111000
		//...
		System.out.println(Integer.toBinaryString(-1));//11111111111111111111111111111111
		System.out.println(Integer.toBinaryString(0));//0
		System.out.println(Integer.toBinaryString(1));//1
		//...
		System.out.println(Integer.toBinaryString(10));//1010
		
		System.out.println(Integer.toBinaryString(~10+1));//1111111111111111111111111110110
		System.out.println(Integer.toBinaryString(-10));//11111111111111111111111111110110
		System.out.println(Integer.toBinaryString(-11));//11111111111111111111111111110101
		System.out.println(Integer.toBinaryString(-127));//11111111111111111111111110000001
		
		int a = 0xffffffff;
		System.out.println(a);//-1
		a = 0xfffffffe;
		System.out.println(a);//-2
		a = 0xfffffffd;
		System.out.println(a);//-3
		a = 0xfffffff6;
		System.out.println(a);//-10
		
		int max = 0x7fffffff;
		int min =0x80000000;
		//补码运算的问题(副作用，缺点)要在实际开发中避免！！
		System.out.println(max);//2147483647
		System.out.println(min);//-2147483648
		System.out.println(max+1==min);//true
		System.out.println(max*2+2);//0
		System.out.println(2*(max+1));//
		System.out.println(max*2+2+2);//2
		System.out.println(max*2+10);//8
		
		System.out.println(Integer.toHexString(-10));//fffffff6
//		int b = 018;//编译错误，八进制没有“8”！！ The literal Octal 018(digit 8)of type int is out of range.

}	
}