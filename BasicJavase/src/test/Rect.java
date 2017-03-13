package test;

public class Rect extends Shape{
	private int width;
	private int height;
	
	public Rect(int x,int y,int w,int h){
		super.location=new Point(x,y);
		width = w;
		height= h;
	}
	public double area(){
		return width*height;
	}
	public boolean contains(int x,int y){
		int xOff=x-location.x;
		int yOff=y-location.y;
		return xOff >= 0 && xOff <= width && yOff >= 0 && yOff <= height;
	}
}
