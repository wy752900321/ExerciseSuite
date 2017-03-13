package basic.day18.thread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *同步：不是同时，同步是指按照先后次序，一步一步执行
 *		如：安检
 *		性能差！
 *同时：(在计算中不存在！)，计算机内部有：并发，宏观上相当于“同时”
 *异步：就是并发，异步就是步调不一致，的并发发生的事情
 *		如：在线视频的下载和播放是异步的，是并发发生的
 *		   是用线程实现的：一个线程负责下载，一个线程负责播放
 *		异步性能好
 */
public class WiteFileDemo {
	public static void main(String[] args) throws IOException {
		//从控制台读取信息写入到文件中
		String file = "sync.txt";
		PrintWriter out = new PrintWriter(new FileOutputStream(file));
		Scanner in = new Scanner(System.in);
		while (true) {
			String str = in.nextLine();
			out.println(str);
			if (str.equals("quit")) {
				break;
			}
		}
		out.close();
	}
}
