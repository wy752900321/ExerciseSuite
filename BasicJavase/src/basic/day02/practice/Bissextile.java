package basic.day02.practice;

import java.util.Scanner;

/**
 * 1，编写程序，判断给定的某个年份是否是闰年。
  闰年的判断规则如下：
  （1）若某个年份能被4整除但不能被100整除，则是闰年。
  （2）若某个年份能被400整除，则也是闰年。
 */

public class Bissextile {

	public static void main(String[] args) {
		while(true){
			Scanner console = new Scanner(System.in);
			System.out.println("请输入需要查询的年份：");
			int year = console.nextInt();
			if(year<0 || year>3000){
				System.out.println("输入有误，程序退出。");
				System.exit(0);
			}
			if((year%4==0)&& (year%100!=0)||(year%400==0)){
				System.out.println(year+"  is bissextile!");
			}else{
				System.out.println(year+" is not bissextile!");
			}
		}
		
	}
}