package basic.day18.thread;

public class SleepDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();//获得当前线程
				System.out.println("执行线程："+t.getName());
				try {
					Thread.sleep(1000);
					System.out.println("休眠结束："+t.getName());
				} catch (InterruptedException e) {
					//先发生错误流，再发生标准流，但是因为它们并发的，所以先后次序不定。
					e.printStackTrace();//System.error错误流上输出
					System.out.println("interrupt，你干吗啊！");//System.out标准流上输出
				}
			}
		};
		//启动线程时，先main启动，正在Ｒunning的
		t.start();//子线程，调用run，尽快实现并发
		Thread.sleep(500);
		t.interrupt();
		System.out.println("main 结束");
	}
}
