package test;

public class Shape {
	protected Point location;
	public double area(){
		return 0;
	}
	public boolean contains(int x,int y){
		return false;
	}
	public boolean contains(Point p){
		return contains(p.x,p.y);
	}
}
