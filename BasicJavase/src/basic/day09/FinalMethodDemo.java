package basic.day09;

public class FinalMethodDemo {
	public static void main(String[] args) {
		
	}
}
class Foo{
	public final int add(int a,int b){
		return a+b;
	}
	private final int add(int a,int b,int c){//私有方法不能继承，只能在本类中可见，在子类中不可见
		return a+b+c;
	}
	
	public int add(int b){
		return b+b;
	}
}
class Koo extends Foo{
	//子类只能继承父类可见方法！私有方法不能被继承，私有方法没有覆盖
	public int add(int a,int b,int c){//是新方法，不是覆盖 
		return a+b+c+1;
	}
//	public int add(int a,int b){//编译错误，final的方法不可被覆盖。
//		return a+b+1;
//	}
	public int add(int b){//方法覆盖
		return b+1;
	}
}