package basic.day03;

import java.util.Scanner;

public class WhileDemo {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int qty;
		while(true){
			System.out.println("ÊäÈë¹ºÂòÊýÁ¿");
			qty = console.nextInt();
			if(qty>0 && qty<=5){
				break;
			}
			System.out.println("Äã¿ÓµùÑ½£¡");
		}
		System.out.println("¹ºÂòÊýÁ¿£º"+qty);
		double pay  = pay(qty,5);
		System.out.println("½ð¶î£º"+pay);

	}
	public static double pay(int qty,int price){
		/*		double pay = 0;
				if(qty%2==0){//Å¼Êý
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
