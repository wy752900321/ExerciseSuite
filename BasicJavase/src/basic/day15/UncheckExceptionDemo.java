package basic.day15;

import java.util.Scanner;

/**
 * A.“非检查异常”:编译器javac不检查RuntimeException子类是否抛出，是否处理！ 
 * B.运行期间，非检查异常还是可能出现，还影响运行流程
 * C.非检查异常可以利用try....catch处理 可以父类型 捕获子类型 异常 
 * D.catch中应该写e.printStackTrace()
 */
public class UncheckExceptionDemo {
	public static void main(String[] args) {
		try {
			int age = readAge();
			System.out.println(age);
		} catch (NumberFormatException e) {
			// 凡是出现处理异常，一定打印异常跟踪堆栈
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}

	public static int readAge() {
		Scanner in = new Scanner(System.in);
		System.out.println("输入年龄：");
		String str = in.nextLine();
		// parseInt方法声明抛出了异常，NumberFormatException
		// 当输入str不能被解析整数时候发生，如：0xff;
		// NumberFormatException是RuntimeException的子类是

		// javac不检查，运行期间，还是可能出现，还影响运行流程
		int age = Integer.parseInt(str);
		return age;
	}
}
