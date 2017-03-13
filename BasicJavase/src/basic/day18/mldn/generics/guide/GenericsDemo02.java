package basic.day18.mldn.generics.guide;


//使用小数表示坐标
public class GenericsDemo02 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10.5f);//利用自动装箱操作：float->Integer->Object
		p.setY(20.6f);
		float x = (Float)p.getX();//取出数据时先变成Float，之后自动拆箱
		float y = (Float)p.getY();
		System.out.println("整数表示,X坐标："+x);
		System.out.println("整数表示，Y坐标："+y);
	}
}
