package basic.day02.practice;

import java.util.Scanner;

public class P_trouble02 {

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
		
			
			/**
			 * factorial 阶乘：
			 */

			System.out.println("请输入一个正整数：");
			Scanner console = new Scanner(System.in);
			int fac =console.nextInt();
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
