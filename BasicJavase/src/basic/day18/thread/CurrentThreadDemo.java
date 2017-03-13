package basic.day18.thread;

/**
 * 当前线程，和线程名
 */
public class CurrentThreadDemo {
	public static void main(String[] args) {
		// main方法是被主线程调用的
		// 主线程是Thread实例
		// 可以使用Thread.currentThread()获得正在调用当前方法的线程
		Thread main = Thread.currentThread();
		// 变量main就是主线程的引用
		// 线程有ID名字属性
		System.out.println(main.getId() + "," + main.getName());
		test();
		Thread t = new Thread() {
			@Override
			public void run() {
				// this代表当前类，是Thread的子类
				System.out.println("run:" + this.getId() + "," + this.getName());
				test();
			}
		};
		t.start();
	}

	public static void test() {
		Thread t = Thread.currentThread();
		// t引用的是正在调用test()方法的线程
		System.out.println("test:" + t.getId() + "," + t.getName());
	}
}
