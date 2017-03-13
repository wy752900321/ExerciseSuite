package basic.day08.graph;


public class Rectangle extends Shape{

	/**矩形，矩形是图形*/
		int width;
		int height;
		public Rectangle(){
		}
		public Rectangle(Point location,int w,int h){
			super.location=location;
			width = w;
			height = h;
		}
		public Rectangle(int x,int y,int w,int h){
			this(new Point(x,y),w,h);
		}
	public double area(){
		return width*height;
	}
	public boolean contains(int x,int y){
		int w = x-location.x;
		int h =y-location.y;
//		if((w >=0 && w<=width) && (h>=0 && h<=height))
		return (w >=0 && w<=width) && (h>=0 && h<=height);
		}
	}
