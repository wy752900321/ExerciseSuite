package basic.day02;

public class CastDemo {

	/**
	 * char
	 */
	public static void main(String[] args) {
		int a = 128;
//		byte b = a;//int变量不能自动自制给byte变量
		byte b = (byte)a;
		System.out.println(b);//-128
		
		a = 128 +1024;
		b=(byte)a;//抹掉int变量的高24位，保留低8位
		System.out.println(b);//-128
		
		a = 128 +1024+2048+65536+0x10000000;
		b=(byte)a;//抹掉int变量的高24位，保留低8位
		System.out.println(b);//-128
		
		a = 127 +1024;
		b=(byte)a;//抹掉int变量的高24位，保留低8位
		System.out.println(b);//127
		
		a = -100;
		b = (byte)a;//强制类型转换，不超范围，没有问题
		System.out.println(b);//-100
		
		//一个不确切的说法：int不能给byte赋值
		//int字面量在不超过byte 范围时，可以给byte变量赋值
		
//		b = 0xffffff80;//-128
		b = (byte)0x80;//128
//		b = 0x00000080;//128
		System.out.println(b);//-128
		
		char c = 'A'+1;//('A'+1)是一个字面量，相当于int 66
		int i = 1;
//		c = 'A'+i;//编译错，‘A’＋i是int变量,不能给char变量赋值！
		c = (char)('A'+i);
//		c = 'A'+65535;//编译错误，字面量超范围!

	}

}
