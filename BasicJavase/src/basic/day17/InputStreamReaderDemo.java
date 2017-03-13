package basic.day17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		String file="test/liyi.txt";
		InputStream in = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(in,"GBK");
		//read() 方法是继承于Reader类，不是继承于InputStream
		//read()会从基本byte流读取数据并解码为char字符，
		//填充到int类型的低16位，高16位保持0，返回这个整数
		//返回值范围：0000 0000 ～0000 ffff返回-1表示读取到文件尾
		int c ;
		while((c=reader.read())!=-1){
			System.out.println((char)c);
		}
//		int c = reader.read();
//		System.out.println(c+":"+(char)c);
//		c = reader.read();
//		System.out.println(c+":"+(char)c);
		//......

	}
}
