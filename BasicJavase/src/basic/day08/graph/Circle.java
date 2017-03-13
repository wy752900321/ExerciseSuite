package basic.day08.graph;


/**
 	圆类型是图形
  	extends继承，可以理解为“是”
 */
public class Circle extends Shape{
	/**半径*/
	int r;
	public Circle(){
	}
	public Circle(Point center,int r){
		super();
		this.location=center;
		this.r=r;
	}
	public Circle(int x,int y,int r){
		this(new Point(x,y),r);
	}
	public double area(){
		return Math.PI*r*r;
	}
//	public boolean contains(int x,int y){
//		return super.contains(x,y);
//	}
	public boolean contains(int x,int y){
		return this.location.distance(x,y)<=r;
	}
}
