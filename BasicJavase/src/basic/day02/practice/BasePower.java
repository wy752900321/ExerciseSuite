package basic.day02.practice;

import java.util.Scanner;

public class BasePower {

	/**
	 *	输入底数与幂，算出值
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入底数：");
		int base = sc.nextInt();
		System.out.println("请输入幂：");
		int power = sc.nextInt();
		int result = 1;
		for(int i = 0;i<power;i++){
			result = result*base;
		}
		System.out.println(base+"的"+power+"次方是"+result);
	}
}
