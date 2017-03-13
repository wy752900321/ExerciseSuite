package basic.day17;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import basic.day16.IOUtils;

/**
 * 最常见的文本文件写出方法println() 
 * PrintWriter类有println()方法，可以一次写出一行文本到文件中，
 * 自动添加回车或者换行(win/linux/mac不同)
 *  PrintWriter类是功能扩展，不能直接访问文件，依赖底层流
 */

public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		String file = "demo.txt";
		PrintWriter out = new PrintWriter(//逐行读写 
				new OutputStreamWriter(//转换流，字符转字节的
						new BufferedOutputStream(//过滤，缓冲，可去除
								new FileOutputStream(file)),"gbk"));
		out.println("HI,");
		out.println("我是贾东坡！");
		out.println("是北京达内公司学员！");
		out.close();
		IOUtils.print(file);
	}
}
