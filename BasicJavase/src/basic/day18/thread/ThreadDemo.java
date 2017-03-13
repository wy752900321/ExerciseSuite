package basic.day18.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getId()+","+t.getName());
			}
		};
		//不应该调用t.run()；这样不会开启新线程，不会开启并发线程
		//没有启动，自己（单线程的）推着汽车跑
		t.run();//在主线程中执行run()；在主线程中顺序执行，没有实现并发
		//开着，它自己启动run(),自己跑（多线程的，并发）
//		t.start();//启动新线程，在新线程中执行run(),是并发执行
	}
}
