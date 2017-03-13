package basic.day07;

/**方法是动态绑定到到对象的方法上！编译期间按照类型检查！运行期运行按具体对象的方法*/
public class Trouble_day07{
	public static void main(String[] args) {
//		Goo1 g=new Goo1();
//		Hoo h=(Hoo)g;//运行错误，运行期间按对象的方法检查。g是父类型，不能往子类转。java.lang.ClassCastException
		Hoo h = new Hoo();	
		Goo1 g=h;
		System.out.println(h.age);//20
		System.out.println(g.age);//10
		h.f();//20
		g.f();//20
//		System.out.println(h.f());
//		System.out.println(g.f());
		//Hoo h=g;//编译错误，编译期间按照类型检查！eclipse可以自动检查编译错，保存时就给提示。
		
		//Hoo h = new Hoo();
		//Goo1 g = h;
		//System.out.println(g.age);//10, 小类型可以往大类型转
	}
}
class Goo1{
	int age=10;
	public void f(){
		System.out.println(this.age);
		
	}
}
class Hoo extends Goo1{
	int age=20;
	public void f(){
		System.out.println(this.age);
	}
}
