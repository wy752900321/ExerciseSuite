package basic.day18.IO.mldn_io;

import java.util.Scanner;

/**Scanner
 * 如果要输入int或float类型的数据，在Scanner中也有支持，但在输入之前最好先使用
 * hasNextXxx()方法进行验证。代码如下：
 */
public class ScannerDemo02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//从键盘接收数据
		int  i = 0;
		float f = 0.0f;
		System.out.println("输入整数：");
		if(scan.hasNextInt()){		//判断输入的是否是整数
			i = scan.nextInt();		//接收整数
			System.out.println("整数数据："+i);
		}else{
			System.out.println("输入的不是整数！");
		}
		System.out.println("输入小数：");
		if(scan.hasNextFloat()){	//判断输入的是否是小数
			f = scan.nextFloat();	//接收小数
			System.out.println("小数数据："+f);
		}else{
			System.out.println("输入的不是小数！");
		}
	}
}
