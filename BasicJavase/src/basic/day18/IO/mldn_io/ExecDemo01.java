package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**19.9.2 实例操作一：加法操作
 * 
 * 要求从键盘输入两个数字，然后完成两个整数的加法操作。因为从键盘接收过来的内容
 * 全部是彩字符串的形式存放的，所以直接将字符串通过包装类Intege将字符串变为基本数据类型。
 *
 */
public class ExecDemo01 {
	public static void main(String[] args) throws IOException {
		int i = 0;
		int j = 0;
		BufferedReader buf = null;		//接收键盘的输入数据
		buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;				//准备接收数据
		System.out.println("请输入第一个数字：");
		str = buf.readLine();
		i = Integer.parseInt(str);		//将字符串变成int型
		System.out.println("请输入第二个数字：");
		str = buf.readLine();
		j = Integer.parseInt(str);
		System.out.println(i+"+"+j+"="+(i+j));
		
	}
}
/**
	实现了题目要求，但存在以下问题：
	1.	如果输入的是字符串不是数字，则肯定无法转换，会出现数字格式化异常，所以在转换时应该使用正则进行验证，
		如果验证成功了，则表示可以进行转换；而如果验证失败了，表示无法进行转换，则要等待用户重新输入数字才可以。
	2. 只能输入整数
	3.代码重复，只要输入数据，则肯定使用BufferedReader，重复出现readLine()调用
	
*/