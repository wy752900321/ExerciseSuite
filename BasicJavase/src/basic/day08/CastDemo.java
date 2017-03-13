package basic.day08;

import basic.day08.graph.Circle;
import basic.day08.graph.Rectangle;
import basic.day08.graph.Shape;

public class CastDemo {

	public static void main(String[] args) {
		//父类型定义的变量可以引用子类型实例,从小类型到大类型，往往自动转换的
//		Shape s = new Circle(3,4,5);
		//引用类型的自动类型(隐式类型转换)转换
		Circle c = new Circle(3,4,5);
		//转换的是引用变量的类型
		//由小类型到大类型自动完成
		Shape s = c;
		print(c);
		
		//引用类型变量的强制类型转换(显示类型转换)
		//由大类型到小类型的转换(造型)
		//转换是有风险的
		Circle cc = (Circle)s;//当s引用的实际对象是圆，这个转换会成功
		s = new Rectangle(4,5,6,7);
		print(s);
		cc = (Circle)s;//运行错误，s实际引用的对象不是圆造成的。 java.lang.ClassCastException
	}
	public static void print(Shape s){
		//instanceof 是运算符，判断s引用的变量是否是Circle类型的
		if(s instanceof Circle){
			System.out.println("这个图形是圆！");
		}
		System.out.println("图形面积："+s.area());
	}
}
