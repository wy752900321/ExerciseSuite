package basic.day02;

import java.util.Scanner;

public class IfDemo3 {

	/**
	 *银行利率
	 */
	public static void main(String[] args) {
		double base = 7.8;//基本利率
		double rate = 0;
		Scanner console  = new Scanner(System.in);
		System.out.println("请输入贷款年限：");
		int years = console.nextInt();//贷款年限
		System.out.println(count(base,rate,years));
		
	}

	public static double count(double base, double rate, int years){

		if(years<=3){
			rate = base*0.7;
		}else if(years<=5){
			rate = base*0.8;
		}else if(years<=10){
			rate = base;
		}else{
			rate =base*1.1;
		}
		return rate;
	}
}
