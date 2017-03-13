package basic.day03;

/*
 *return跳出方法，返回方法调用处
 *System.exit(1)退出程序
 */
public class Demo1 {

	public static void main(String[] args) {
		f();
		System.out.println("aaaa");
		ff();
	}
	public static void f(){
		for(int i =0;i<10;i++){
			if(i==5)return;
			System.out.println(i);
		}
	}
	
	public static void ff(){
		for(int j =0;j<10;j++){
			if(j==7)System.exit(1);
			System.out.println(j);
		}
	}
}