package basic.day17.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOUtils03 {
	public static void printHex(String fileName) throws IOException{
		// 1。创建文件输入流对象
		FileInputStream in = new FileInputStream(fileName);
		int b = 0;
		int i=1;
		// 2.循环读取byte
			if (b <= 0xf) {// 单位数前面补0，如：8－＞08
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b) + "");
			if(i++%10==0){//第10行换行
				System.out.println();
		}
		in.close();
	}
}
