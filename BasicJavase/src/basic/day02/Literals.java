package basic.day02;

public class Literals {

	/**
	 * 八进制与十六进制
	 */
	public static void main(String[] args) {
		int i1 = 0x2f;//Hexadecimal(lowercase)
		System.out.println("i1:"+Integer.toBinaryString(i1));//i1:101111
		int i2 = 0x2F;//Hexadecimal(uppercase)
		System.out.println("i2:"+Integer.toBinaryString(i2));//i2:101111
		int i3 = 0177;//Octal(leading zero)
		System.out.println("i3:"+Integer.toBinaryString(i3));//i3:1111111
		char c = 0xffff;//max char hex value
		System.out.println("c:"+Integer.toBinaryString(c));//c:1111111111111111
		byte b = 0x7f;//max byte hex value
		System.out.println("b:"+Integer.toBinaryString(b));//b:1111111
		short s = 0x7fff;//max short hex value
		System.out.println("s:"+Integer.toBinaryString(s));//s:111111111111111
		long n1 = 200L;//long suffix
		long n2 = 200l;//long suffix(but can be confusing)
		long n3 = 200;
		float f1 = 1;
		float f2 = 1F;//float suffix
		float f3 = 1f;//float suffix
		double d1 = 1d;//double suffix
		double d2 = 1D;//double suffix

		int max = Integer.MAX_VALUE;
		System.out.println("整型的最大值为："+max);//整型的最大值为：2147483647
		System.out.println("整型的最大值+1为："+(max+1));//整型的最大值+1为：-2147483648
		System.out.println("整型的最大值+2为："+(max+2));//整型的最大值+2为：-2147483647
		
	}

}
