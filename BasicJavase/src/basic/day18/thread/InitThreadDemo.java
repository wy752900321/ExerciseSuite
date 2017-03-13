package basic.day18.thread;

public class InitThreadDemo {
	public static void main(String[] args) {
//		Runnable r = new Runnable(){};
		class Tester implements Runnable{//局部内部类
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		}
		Thread t1 = new Thread(new Tester());
		t1.start();
		//内部类
		Runnable r = new Runnable(){//
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		};
		Thread t2 =new Thread(r);
		Thread t3 = new Thread(r);
		t2.start();
		t3.start();
		//匿名内部类
		Thread t4 =new Thread(new Runnable(){
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		});
		t4.start();
		//内部类
		new Thread(){		
			public void run() {
			Thread t = Thread.currentThread();
			System.out.println(t.getName());
		}}.start();
		//内部类
		new Thread(new Runnable(){

			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			
			}}).start();
	}
}
