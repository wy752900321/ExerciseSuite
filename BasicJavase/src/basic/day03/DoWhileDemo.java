package basic.day03;

import java.util.Scanner;

public class DoWhileDemo {

	public static void main(String[] args) {
		Scanner console  = new Scanner(System.in);
		int balance = 1000;
		int bet;
		//do while 看着不习惯！
//		do{
//			System.out.println("请输入押注数量：");
//			bet = console.nextInt();
//		}while(bet<=0||bet>balance);
//		System.out.println("数量:"+bet);

		while(true){
		System.out.println("请输入押注数量：");
		bet = console.nextInt();
		if(bet>=0&&bet<=balance){
			break;
		}
		System.out.println("错了！");
		}
		System.out.println("数量："+bet);
	}
}