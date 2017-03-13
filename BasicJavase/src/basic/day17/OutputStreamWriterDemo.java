package basic.day17;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import basic.day16.IOUtils;

/**
 * OutputStreamWriter也是一个流功能扩展，依赖于OutputStream 
 * OutputStreamWriter提供了write(int)方法，参数的低16位数据 (char 数据)进行编码，编码为byte序列，写入到OutputStream
 * OutputStream的write(byte)写出一byte，是int的低八位
 * OutputStreamWriter的write(char)编码char为byte写出到底层流
 */
public class OutputStreamWriterDemo {

	public static void main(String[] args) throws IOException {
		String file = "writer.txt";
		OutputStreamWriter out = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(file)), "utf-8");
		out.write('中');
		out.write('国');
		out.close();
		IOUtils.print(file);//e4 b8 ad e5 9b bd 
	}
}
