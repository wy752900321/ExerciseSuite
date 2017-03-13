package basic.day07;

public class FieldDemo {

	public static void main(String[] args) {
		Tricker tricker = new Tricker("Jerry");
		Person person = tricker;
		//属性是绑定到变量类型上的！静态绑定！根据变量类型访问属性
		//Tricker类型的变量tricker.name返回Tricker的name
		//Person类型的变量Person.name 返回Person的name
		System.out.println(tricker.name+","+person.name);
		//方法是动态绑定到对象，由具体对象类型决定调用哪个方法
		//无论是tricker还是person都是Tricker对象的引用，getName()
		//调用的都是Tricker类型的方法！父类型方法被覆盖了！
		System.out.println(tricker.getName()+","+person.getname());
		//结论：
		//属性是绑定到变量类型上的！静态绑定！根据变量类型访问属性
		////方法是动态绑定到对象，由具体对象类型决定调用哪个方法
		//编程建议：
		//	A 子类不建议定义与父类同名的属性
		//  B 建议使用getXXX()方法访问属性的值（这种现象稳定）
	}

}
class Person{
	String name;
	public Person(String name){
		this.name=name;
	}
	/**方法覆盖*/
	public String getname(){
		return name;
	}
}
/**骗子*/
class Tricker extends Person{
	String name;
	public Tricker(String name){
		super("Tom");
		this.name=name;
	}
	public String getName(){
		return name;
	}
}	
//逻辑不合理
//class Student extends Person{
//	String name;
//}