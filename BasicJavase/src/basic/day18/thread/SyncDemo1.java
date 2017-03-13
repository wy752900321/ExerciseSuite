package basic.day18.thread;

import basic.day18.thread.Table.Person;

/**
 * 临界资源访问, 同步监视器，同步锁
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		Table table = new Table();
		Person p1 = table.new Person();
		Person p2 = table.new Person();
		p1.start();
		p2.start();
	}
}

class Table {
	int beans = 20;

	Object monitor = new Object();// 同步监视器，同步锁,可省略，下面写this

	// boolean monitor lock=false;//默认为false
	// 拿到锁时为true

	// 方法－ ,加上下面这句，后
	// Object monitor = new Object();// 同步监视器，同步锁,可省略，下面写this
	// public int getBean() {
	// synchronized (monitor) {
	// int a = 5;
	// if (beans == 0)
	// throw new RuntimeException("没了");
	// Thread.yield();
	// return beans--;
	// }
	// }

	// // 方法二 ,简写，去除下面这句， synchronized (monitor)中的monitor改成this
	// // Object monitor = new Object();// 同步监视器，同步锁,可省略，下面写this
	// public int getBean() {
	// synchronized (this) {
	// int a = 5;
	// if (beans == 0)
	// throw new RuntimeException("没了");
	// Thread.yield();
	// return beans--;
	// }
	// }

	// // 方法三，方法声明时写synchronized
	// public synchronized int getBean() {
	// int a = 5;
	// // synchronized (monitor) {
	// if (beans == 0)
	// throw new RuntimeException("没了");
	// Thread.yield();
	// return beans--;
	// }

	// 方法四，有问题代码有问题代码，临界问题出现
	public int getBean() {
		if (beans == 0)
			throw new RuntimeException("没了");
		// Thread.yield(); //改动方法一：可能 出问题
		try {
			Thread.sleep(100); // 改动方法二：数组容量越大问题越多
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return beans--;
	}

	class Person extends Thread {
		public void run() {
			while (true) {
				int bean = getBean();
				System.out.println(getName() + "拿到：" + bean);
				Thread.yield();
			}
		}
	}
}