package basic.day06;

public class PointDemo {

	public static void main(String[] args) {
		  Point p1 = new Point(3,4);
		//月饼  枣泥月饼 ＝ new 月饼（面，油）
//		p1.x=3;
//		p1.y=4;
		System.out.println(p1.x+","+p1.y);
		Point p2 = new Point(5,5);
//		p2.x=5;
//		p2.y=5;
		System.out.println(p2.x+", "+p2.y);
	}
}
/**
public class Point {
	int x;
	int y;
	public Point(int x,int y){
		//this代表当前对象
		this.x=x;
		this.y=y;
	}
}*/