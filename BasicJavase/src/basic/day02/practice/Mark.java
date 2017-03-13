package basic.day02.practice;

import java.util.Scanner;

/**
 * 给定一个百分制的分数，输出相应的等级。
    90分以上        A级
    80~89          B级
    70~79          C级
    60~69          D级
    60分以下        E级

 */

public class Mark {


	public static void main(String[] args) {
		System.out.println("请输入需要查询的分数：");
		Scanner console = new Scanner(System.in);
		double mark = console.nextDouble();
		if(mark>100||mark<0){
			System.out.println("输入有误，程序退出！");
			System.exit(0);
		}
		if(mark>90){
			System.out.println("this mark is grade \'A\' ");
		}else if(mark>80){
			System.out.println("this mark is grade \'B\' ");
		}else if(mark>70){
			System.out.println("this mark is grade \'C\' ");
		}else if(mark>60){
			System.out.println("this mark is grade \'D\' ");
		}else{
			System.out.println("this mark is grade \'E\' ");
		}

	}

}
