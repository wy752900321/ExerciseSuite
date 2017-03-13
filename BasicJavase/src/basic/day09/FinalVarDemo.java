package basic.day09;

/**final 的变量，可以初始化，不能修改*/
public class FinalVarDemo {

	public static /*final*/ void main(/*final*/String[] args) {//加不加fianl都可用
		final int a = 1;//局部变量，方法中声明的变量
		//a=a++;//A改了两次，两个错，final不能更改
		//a++;//编译错误，final不能更改
		System.out.println("a="+a);//a=1
		
		int b = add(a,a);
		System.out.println("b="+b);//3
		
		final int[] ary = {3,4,5};
//		ary = null ;//编译错误，不能修改fianl变量的值！
		ary[1] = 8;//可以修改对象的内容
		//说法不确切：final的数组是不能修改的
		final String[] names = {"Tom","Jerry"};
	}
	public static /*final*/ int add(final int a,int b ){
		//方法参数也是局部变量，
		//方法参数在调用方法，传递参数时候初始化
//		a++;//编译错，a不能修改
		b++;//没错，可以修改
		return a+1;
	}
}
