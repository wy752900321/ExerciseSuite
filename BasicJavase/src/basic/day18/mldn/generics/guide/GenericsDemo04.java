package basic.day18.mldn.generics.guide;


//异常
public class GenericsDemo04 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);//利用自动装箱操作：int->Integer->Object
		p.setY("北纬210度");//String->object
		int x = (Integer)p.getX();//取出数据时
		int y = (Integer)p.getY();//取出数据时->此处出现了类转换错误
		System.out.println("整数表示,X坐标："+x);
		System.out.println("整数表示，Y坐标："+y);
	}
}
