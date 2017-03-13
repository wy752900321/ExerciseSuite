package basic.day18.IO.mldn_io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 读取DataOutputStreamDemo.java中写入的文件 
 * 从order.txt中读取数据
 * 使用输入流读取时，因为每条记录之间使用‘\t'作为分隔，每行记录之间使用‘\n'作为分隔，
 * 所以要分别使用readChar()读取这两个分隔符，才能将数据正确地还原
 */
public class DataInputStreamDemo2 {
	public static void main(String[] args) throws IOException {
		DataInputStream dis = null;// 声明数据输入流对象
		File f = new File("test" + File.separator + "order.txt");// 要读取文件
		dis = new DataInputStream(new FileInputStream(f));// 实例化数据输入流对象

		String name = null;// 接收名称
		float price = 0.0f;// 接收价格
		int num = 0;// 接收数据
		char temp[] = null;// 接收字符串数据
		char c = 0;// 声明字符变量
		int len = 0;// 接收读取数据
		try {
			while (true) {// 循环读取
				temp = new char[200];// 开辟空间
				len = 0;
				while ((c = dis.readChar()) != '\t') {// 读取字符
					temp[len] = c;// 接收内容
					len++;// 读取长度加1
				}
				name = new String(temp, 0, len);// 将字符数组变为String
				price = dis.readFloat();// 读取float
				dis.readChar();// 读出\t
				num = dis.readInt();// 读取int
				dis.readChar();// 读取\n

				// 使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。
				System.out.printf("名称：%s:价格：%5.2f:数量：%d\n", name, price, num);
			}
		} catch (Exception e) {// 如果读到底，则会现异常
			e.printStackTrace();
			System.out.println("读到最后了。");
		}
		dis.close();// 关闭输出流
	}
}
/*
 * public PrintStream printf(String format, Object ... args) 
 * {returnformat(format, args); 
 * 调用此方法的 out.printf(format, args) 形式，行为与以下调用完全相同：
 * out.format(format, args) 
 * 参数： format - 在格式字符串的语法中描述的格式字符串 
 * 		args -格式字符串中的格式说明符引用的参数。如果参数多于格式说明符，则忽略额外的参数。 
 * 参数的数量是可变的，并且可以为零。参数的最大数量受到 JavaVirtual Machine Specification 定义的
 *  Java 数组的最大维数的限制。针对 null 参数的行为依赖于conversion。
 *返回： 此输出流
 */