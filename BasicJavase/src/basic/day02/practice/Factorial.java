package basic.day02.practice;

import java.util.Scanner;

public class Factorial {

	/**
	 * factorial 阶乘：
	 */
	public static void main(String[] args) {
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int fac = sc.nextInt();
		int layer = fac;
		int j = 1;
		loop: while(true){
			//为什么不能是layer???
			layer=layer*(fac-j);//阶乘的具体实现
			j++;
			if(fac==j)
				break loop;
		}
		System.out.println(fac+"的阶乘为："+layer);
	}


}
