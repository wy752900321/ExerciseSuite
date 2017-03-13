package basic.day08;

public class MainMethodDemo {

	int a =1;
	static int b = 5;
	public int add(int a){
		return a+this.a;
	}
	public static int f(int x){
		return x+1;
	}
	public static void main(String[] args) {
//		System.out.println(a);//±àÒë´íÎó
//		int x  = add(5);//±àÒë´íÎó
		System.out.println(b);
		int y = f(5);
		System.out.println(y);
		MainMethodDemo obj = new MainMethodDemo();
		System.out.println(obj.a);//1
		System.out.println(obj.add(5));//6
	}
	
}
