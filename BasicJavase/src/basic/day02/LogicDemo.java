package basic.day02;

import java.util.Scanner;

public class LogicDemo {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("ÊäÈëÄêÁä£º");
		int age = console.nextInt();
		char sex = 'ÄĞ';
		boolean isMan = sex =='ÄĞ';
		boolean isChild = age<16;
		boolean isBoy =isMan&&isChild;
		boolean isGirl =!isMan&&isChild;
		boolean isKid = isBoy||isGirl;
		System.out.println(isKid);

	}

}
