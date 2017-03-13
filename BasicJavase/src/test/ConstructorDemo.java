package test;

public class ConstructorDemo {
	
	public static void main(String[] args) {
		
	}

}
class Foo2{
	int a;
	public Foo2(int a){
		this.a=a;
	}
}
class Koo2 extends Foo2{
	public Koo2(){
		super(2);
	}
}