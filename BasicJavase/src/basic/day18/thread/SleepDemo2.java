package basic.day18.thread;

public class SleepDemo2 {
	public static void main(String[] args) {
		//睡觉，被吵醒的线程
		 final Thread she = new Thread(){
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println("睡觉");
					try{
						Thread.sleep(1000);
						System.out.println("醒来了。。。。");
					}catch(InterruptedException e){
						System.out.println("干嘛哪！干吗呢！！0_＠");
						break;
					}
				}
			}
		};
		//咂墙线程，砸开以后吵醒she
		Thread he =new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("嘿，咂墙！");
					try{
						Thread.sleep(200);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("咂开了！！！");
				she.interrupt();
			}
		};
		she.start();
		he.start();
	}
}
