package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**实例操作三：从文件中得到数据
 *		如果要从文件中取得数据，则直接将File类的实例传入到Scanner的构造
 *方法中即可。
 */
public class ScannerDemo04 {
	public static void main(String[] args) {
		//File.separator是文件分隔，可以跨平台
		File f = new File("test"+File.separator+"xiya.txt");//指定操作文件
		Scanner scan = null;
		try {
			scan = new Scanner(f);	//从文件接收数据
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer str = new StringBuffer();//用于接收数据
		while(scan.hasNext()){	//判断是否还有内容
			str.append(scan.next()).append("\n");//取出内容
		}
		System.out.println(str);
	}
}
