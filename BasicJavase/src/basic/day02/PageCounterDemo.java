package basic.day02;

import java.util.Scanner;

	/**条件表达式*/
public class PageCounterDemo {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("请输入行数：");
		int rows = console.nextInt();
//		int rows = 35;//行数
		System.out.println("请输入页面大小：");
		int size = console.nextInt();//页面大小
		int pages = count(rows,size);//页数
		System.out.println("这个书一共要："+pages+"页。");
	}
	public static int count(int rows,int size){
		return rows%size==0?rows/size:rows/size+1;
	}
	
}
