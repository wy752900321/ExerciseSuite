package tarena.interview;

import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		System.out.println("请输入数字测试：");
		Scanner console = new Scanner(System.in);
		int temp = console.nextInt();
		System.out.println(isOdd(temp));
	}
	public static boolean isOdd(int i){
		//不完合理情况
//		return i%2==1;//在任何负整数和零上调用该方法都会返回false,不管是奇偶
		//合理情况1
//		return i%2 !=0;
		//更合理情况2
		/**
		   逻辑与运算，一般伙们把true理解为1,false理解为0.
			5＆3时,是1：   1 0 1
						＆0 1 1
					....................
		  				0	0 1
		 */
		return (i & 1)!=0;
	}

}
