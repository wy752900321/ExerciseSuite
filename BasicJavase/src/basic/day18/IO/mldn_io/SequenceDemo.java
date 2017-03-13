package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**合并 两个文件  合并流SequenceInputStream
 * 此程序在实例化SequenceInputStream类时指定了两个输入流，所以SequenceInputStream
 * 类在进行读取时实际上是从两个输入流中一起读取内容的
 * 执行完成后：把demo1.txt和demo2.txt的内容给了demo3.txt，demo3.txt文件内容丢了
 */
public class SequenceDemo {
	public static void main(String[] args) throws IOException {
		InputStream is1 = null;//输入流1
		InputStream is2 = null;//输入流2
		OutputStream os = null;//输出流
		SequenceInputStream ais =null;//合并流
		is1 = new FileInputStream("demo"+File.separator+"demo1.txt");
		is2 = new FileInputStream("demo"+File.separator+"demo2.txt");
		os = new FileOutputStream("demo"+File.separator+"demo3.txt");
		ais = new SequenceInputStream(is1,is2);//实例化合并流
		int temp = 0;
		while((temp=ais.read())!=-1){//循环输出
			os.write(temp);//保存内容
		}
		ais.close();//关闭合并流
		is1.close();//关闭输入流1
		is2.close();//关闭输入流2
		os.close();//关闭输出流
		
	}
}
