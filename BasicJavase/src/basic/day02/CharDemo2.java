package basic.day02;

import java.util.Random;

public class CharDemo2 {

	/**
	 * char
	 */
	public static void main(String[] args) {
		//任何字面量整数，都是int。所以0x4e2d是int型的
		//整数字面量在不超地char范围情况下，可以给char变量赋值
		System.out.println(0x4e2d);//20013,整型的
		char c =0x4e2d;//字面量，直接量
//		c = 65536;//编译错误，超范围。Type mismatch:cannot conver from int to char
		int a = 20013;
//		c = a;//Type mismatch:cannot conver from int to char
		//问题：int 可以给char赋值吗？
		
		c = '5';//c值是53
		int n = c - '0';//n=53-48=5
		//数值字符c的编码是(int)c, 对应的整数值n
		System.out.println((int)c);//53
		System.out.println(c);//'5'
		System.out.println(n);//数值5
		System.out.println(c+1);//54
		System.out.println(n+1);//6
		Random random = new Random();
		int index = random.nextInt(26);//生成随机整数［0，26）
		c = (char)('A'+index);
		System.out.println(c);//随机字符'A'~'Z'
	}

}
