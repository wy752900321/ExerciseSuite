package basic.day09;

public class ShapeDemo {

	public static void main(String[] args) {
		Shape s = new Circle(3,4,5);
//		Shape ss = new Shape();//编译错误
		System.out.println(s.area());
		//编译期间检查类型 的方法
		//运行期间在对象上执行对象的方法Circle.area()
		Point p1 = new Point(6,8);
		System.out.println(s.contains(p1));
		System.out.println(s.getR());//按类型检查
		System.out.println(((Circle)s));//强转
		System.out.println(((Circle)s).getR());//有风险，运行期间
//		System.out.println(s.r);//不合理，java按规则检查,矩形没半径
	}

}
