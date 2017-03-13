package basic.day19.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP论文：在网上搜"rfc tcp" 客户端程序，不能单独用
 */
public class TCPClientDemo {
	public static void main(String[] args) {
		TCPClientDemo clent = new TCPClientDemo();
		clent.open();
	}

	public void open() {
		try {
			// 服务器要先启动，才能去连接
			// new Socket()构造方法会连接服务器(与accept()方法相关联)，
			// 连接成功返回Socket实例s, 连接失败抛出异常，s代表客户端到服务器的连接
			Socket s = new Socket("localhost", 8000);
			InputStream in = s.getInputStream();// in交给write处理
			OutputStream out = s.getOutputStream();// out交给Reader处理
			new Writer(in, s).start();
			new Reader(out, s).start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器连接失败！");
		}
	}

	/** 负责将服务器发送来的消息写到控制台上 */
	class Writer extends Thread {
		InputStream in;

		Socket s;

		public Writer(InputStream in, Socket s) {
			this.in = in;
			this.s = s;
			setDaemon(true);// 后台线程
		}

		public void run() {
			// 负责将服务器发送来的消息写到控制台上
			Scanner sc = new Scanner(in);// 服务器，从Socket获得的in
			while (true) {
				String str = sc.nextLine();// IO Block的，在in里读到回车才结束。
				System.out.println(str);
			}
		}
	}

	/** 负责将控制台上的消息发送到服务器端 */
	class Reader extends Thread {
		OutputStream out;

		Socket s;

		public Reader(OutputStream out, Socket s) {
			this.out = out;
			this.s = s;
		}

		public void run() {// 控制台上的消息发到服务器
			Scanner sc = new Scanner(System.in);// 控制台
			while (true) {// 有很行，往服务器上发
				try {
					String str = sc.nextLine();
					out.write((str + "\n").getBytes());
					out.flush();
//					if (str.startsWith("bye")) {
//						break;
//					}
					 if(str.equals("bye")){
							out.write("再见，欢迎下次再来！\n".getBytes());
							out.flush();
							this.s.close();//in和out属于Socket。所以只要关了Socket就行了
							break;
					 }
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
}
