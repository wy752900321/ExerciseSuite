package basic.day09;

/**
 	图形不具体（抽象的）但图形一定可以计算面积
 	如何计算面积也是抽象的
 	抽象类语法：
 		1.抽象类可以定义变量
 		2.抽象类不能实例化，创建对象
 		3.抽象类只能被继承
 		4.具体子类必须实现所有抽象方法
 		5.抽象类型变量可以引用具体子类型实例
 */
public abstract class Shape {
	
	protected Point location;
	
	public abstract double area();
	public abstract boolean contains(int x,int y);
	
	public boolean contains(Point p){
		return this.contains(p.x, p.y);
	}
	public Object getR() {//debug,自动增加
		return null;
	}
}
