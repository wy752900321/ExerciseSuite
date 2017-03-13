package basic.day18.IO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 我们知道，在计算机里存放的就是一堆的二进制，那它是如何来表示一个字符，数字，字母，特殊符号，等， 这就要靠编解码了！
 * 字符流就可以用来解决字符编码的问题，使用它，可以保证编解码统一，防止出现乱码。 比如：一个字符‘ A’，采用 ASCII 码标准编码为 0X41。
 * 字符编码：
 */
public class TestCharacterDemo {
	public static void main(String[] args) throws IOException {
		String s1 = "达内科技";
		byte[] b1 = s1.getBytes("UTF-8");//指定使用UTF－8编码方式 
		String s2 = new String(b1,"GBK");//使用GBK方式解码，此时就会出现中文乱码
		System.out.println(s2);
		
		byte[] b2 = s2.getBytes("GBK");//采用同样方式反编回来
		String s3 = new String("UTF-8");//解码与上面编码时一致，打印正常
		System.out.println(s3);
	}
}
