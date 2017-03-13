package basic.day18.mldn.generics.guide;
/**
 *	设计一个表示坐标的类，坐标表示有3种整数，小数，字符串。
 *接收三种，向上转形
 */
public class Point {
	private Object x;//x坐标
	private Object y;//y坐标
	public Object getX() {
		return x;
	}
	public void setX(Object x) {
		this.x = x;
	}
	public Object getY() {
		return y;
	}
	public void setY(Object y) {
		this.y = y;
	}
}
