package basic.day18.mldn.generics.guide;


//用整数表示坐标
public class GenericsDemo01 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);//利用自动装箱操作：int->Integer->Object
		p.setY(20);//利用自动装箱操作：int ->Integer->object
		int x = (Integer)p.getX();//取出数据时先变成Integer，之后自动拆箱
		int y = (Integer)p.getY();
		System.out.println("整数表示,X坐标："+x);
		System.out.println("整数表示，Y坐标："+y);
	}
}
