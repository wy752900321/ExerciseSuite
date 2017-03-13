package basic.day18.IO.mldn_io;

import java.util.Scanner;

/**使用Scanner类输入数据
 * 	实例操作一：实现基本的数据输入: 
 * 问题：
 * 		运行结果可以发现，空格后的数据没有了，原因是Scanner将空格当作一个分隔符，
 * 所以为了保证程序的正确，可以将分隔符号修改为“\n(回车)".
 */
public class ScannerDemo01 {
	public static void main(String[] args) {
		//版本一，未处理空格
//		Scanner scan =new Scanner(System.in);
//		System.out.println("输入数据：");
//		String str = scan.next();
//		System.out.println("输入的数据为："+str);
		
		//版本二，空格处理
		Scanner scan = new Scanner(System.in);//从键盘接收数据
		//public Scanner useDelimiter(Pattern pattern)将此扫描器的分隔模式设置为指定模式。 
		scan.useDelimiter("\n");			//修改输入数据的分隔符
		System.out.println("输入数据：");
		String str = scan.next();
		System.out.println("输入数据为："+str);
	}
}
