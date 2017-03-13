package basic.day18.thread;
/**
 * 关于同步：
 * 	应用原则：尽可能并发，减少同步范围
 * 	
 * 	临界资源：是多个线程共享访问(读写)的资源(对象／变量)
 * 		常见的临界资源：实例变量(对象的属性)和静态变量
 * 
 * 	临界资源的访问需要同步块保护！	
 * 
 * 		局部变量，是在方法内部分配的临时变量，不是临界资源！	
 * add()与add(b)是同步的
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Foo foo =new Foo();
		Thread t =new Thread(){
			public void run(){
				foo.add();
//				foo.add(5);
			}
		};
		t.start();
//		foo.add();
		foo.add(8);
	}
}
class Foo{
	int a = 1;
	/**
	 加synchronized输出：
	 			add start
				add over
				add start
				add over
	不加synchronized输出：
				add start
				add start
				add over
				add over
	*/
	public synchronized void add(){//方法的执行是同步的
		a++;
		System.out.println("add start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("add over");
	}
	public synchronized void add(int b){
		a+=b;
		System.out.println("add b start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("add b over");
	}
	
}