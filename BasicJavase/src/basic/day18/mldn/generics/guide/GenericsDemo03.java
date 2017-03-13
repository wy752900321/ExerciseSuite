package basic.day18.mldn.generics.guide;


//使用字符串表示坐标
public class GenericsDemo03 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX("东经180度");//String->Object
		p.setY("北纬210度");
		String x = (String)p.getX();//取出数据
		String y = (String)p.getY();
		System.out.println("整数表示,X坐标："+x);
		System.out.println("整数表示，Y坐标："+y);
	}
}
