package basic.day06.practice;

import java.io.IOException;

public class SwitchCycle_01 {
	public static void main(String[] args) throws IOException { 	// 因为调用read()方法而抛出的IO异常
		System.out.println("请从键盘输入一个小写字母：");
		char ch = (char) System.in.read();					// 得到从键盘输入的字符
		int num = (int) ch; 		// 将char型强制转换成int，目的是根据哈希码值来判断是否是小写字母
		if (num < 97 || num > 122) { 	// a～z的哈希码值：97～122
			System.out.println("您的输入有误，请输入正确的小写字母！！");
		} else {
			switch (ch) {			// 用switch语句来判断是否是元音字母（a,e,I,o,u）
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.println(ch + " 是元音字母");
				break;
			default:
				System.out.println(ch + " 是辅音字母");
			}
		}
	}
}
