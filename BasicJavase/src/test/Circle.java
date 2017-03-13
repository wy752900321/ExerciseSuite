package test;

public class Circle extends Shape{
	private double r;
	public Circle(Point center,double r){
		this.location=center;
		this.r=r;
	}
	public Circle(int x,int y,double r){
		this(new Point(x,y),r);
	}
	public double area(){
		return Math.PI*r*r;
	}
	public boolean contains(int x ,int y){
		return location.distance(x,y)<r;
	}
}
