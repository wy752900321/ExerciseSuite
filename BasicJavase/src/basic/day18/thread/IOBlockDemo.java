package basic.day18.thread;

import java.util.Random;
import java.util.Scanner;

public class IOBlockDemo {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("线程" + t.getName() + "启动");
				Scanner in = new Scanner(System.in);
				// System.out.println("发生线程IO BIOCK！");
				// IO Block 阻塞线程，直到IO完成线程继续执行
				// String str = in.nextLine();//IO Block 直到IO完成线程继续执行
				// System.out.println("IO 完成 ！ str:"+str);
				// 非IO Block
				int n = in.nextInt();
				System.out.println("IO 完成 ！ str:" + n);
				Random random = new Random();
				n = random.nextInt();// 不是Block方法，不发生阻塞现象
				System.out.println(n);
			}
		};
		t.start();
	}
}
