package basic.day18.thread;

public class TestThread {
	public static void main(String[] args) {
		Person1 p1 = new Person1();// 创建了一个线程对象，线程实例
		Person2 p2 = new Person2();
		Person3 p3 = new Person3();
		p1.setPriority(Thread.MIN_PRIORITY);// 设置为最低的优先级，由1～10之间
		p1.setDaemon(true);// 设置为后台线程
		p3.setPriority(Thread.MAX_PRIORITY);// 最大级10
		p1.start();// 尽快的启动运行线程中的run()方法
		p2.start();// 默认优先级5
		p3.start();
		System.out.println("main over!主线程结束！");
	}

}

class Person2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("你是谁?");
			Thread.yield();// 当前线程让出处理器，由Running返回到时Runnable
		}
		System.out.println("你是谁? OVER!");
	}
}

class Person1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("做弹弓打你家玻璃！");
			Thread.yield();
		}
		System.out.println("弹弓子！OVER!");
	}
}

class Person3 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("查水表的！");
			Thread.yield();
		}
		System.out.println("查水表！OVER!");
	}
}
/**
 * 后台线程(守护线程, 精灵线程) 
 * t1.setDaemon(true); Java进程的结束: 
 * 当前所有前台线程都结束时, Java进程结束 后台线程,
 * 不管是否结束, 都被停掉! 因为并发的现象, 后台线程 不会立即结束!
 */
