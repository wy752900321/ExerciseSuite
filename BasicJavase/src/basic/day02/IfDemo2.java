package basic.day02;

import java.util.Scanner;

public class IfDemo2 {

	/**
	 * 第二杯半价
	 */
	public static void main(String[] args) {
		
		while(true){
			Scanner console = new Scanner(System.in);
			System.out.println("请问您需要多少杯：");
			int qty = console.nextInt();//数量，5杯
			int price =5;//价格，5块一杯
			double pay = pay(qty,price);
			System.out.println(pay);
		}
		
	}
	public static double pay(int qty,int price){
/*		double pay = 0;
		if(qty%2==0){//偶数
			pay = (price + (double)price/2)*(qty/2);
		}else{
			pay = (price + (double)price/2)*(qty/2)+price;
		}*/
		
		double pay = (price + (double)price/2)*(qty/2);
		if(qty%2!=0){
			pay = pay+price;//pay+=price;
		}
		return pay;
	}

}
