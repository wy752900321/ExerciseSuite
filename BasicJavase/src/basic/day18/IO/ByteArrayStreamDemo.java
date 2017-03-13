package basic.day18.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

//流不仅仅可以读文件 
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws IOException {
		// FileInputStream
		byte[] buf = { 5, (byte) 0xff, -1 };//{05,ff,ff};
		//			   ^
		//将byte数组作为流进行读取处理,流不仅仅是出来文件的！
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int b = in.read();//5
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//			   			 ^
		System.out.println(b);
		b = in.read();//255
		System.out.println(b);
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//								  ^	
		//byte类型的－1，为int的,ffff ffff转换成十六进制0000 0000 ffff ffff补零为十进制255
		b = in.read();//255,
		System.out.println(b);
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//    								 ^	
		b =in.read();//-1,读到最后一位了，API规定返回-1
		System.out.println(b);
		in.close();
		
		//将内存中的变长byte[]数组作为输出流
		//ByteArrayOutputStream中包含一个变长Byte数组
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(5);
		out.write(65);
		out.write("中国".getBytes("GBK"));
		out.close();
		byte[] ary = out.toByteArray();//把有效的数据导出来
		System.out.println(Arrays.toString(ary));
		IOUtils.print(ary);//十六进制输出
	}
}
