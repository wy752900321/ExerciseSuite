package basic.day16;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String file = "data.dat";
		FileOutputStream out = new FileOutputStream(file);
		/*
		 * 左移位操作符（<<）能将操作符左边的运算对象向左移动操作符右侧指定的 位数（在低位补0）。
		 * “有符号”右移位操作符（>>）则将操作符左边的运算对象向右移动操作符右侧指定的位数。
		 * “有符号”右移位操作符使用了“符号扩展”：若符号为正，则在高位插 入 0；若符号为负，则在高位插入 1 Java
		 * 中增加了一种“无符号”右移位操作符（>>>） ，它 使用了“零扩展”：无论正负，都在高位插入 0。这一操作符是 C 或 C++没有的。
		 */
		int n = -3;
		out.write(n >>> 24);
		out.write(n >>> 16);
		out.write(n >>> 8);
		out.write(n);
		out.close();
		IOUtils_1.print(file);

		// 对比使用，DataOutputStream.比上边那个方法简单了
		file = "data2.dat";
		out = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(out);// 简化流的操作
		dos.writeInt(-3);
		dos.close();
		IOUtils_1.print(file);
	}
}
